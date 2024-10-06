package com.study.chattingclient.handler

import com.fasterxml.jackson.databind.ObjectMapper
import com.study.chattingclient.handler.dto.ResponseMessage
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.util.HashMap

// WebSocket 과 관련 된 Session Handler 임 !
// Stomp Protocol 은 Frame 단위임 !
@Component
@Order(value = 1)
class ClientWebSocketSessionHandler (
    private val objectMapper: ObjectMapper,
): StompSessionHandlerAdapter() {

    companion object {
        private const val SUBSCRIPTION_TOPIC = "/topic/chatting"
        private const val PUBLISH_DEST = "/app/chatting-message"

        private val logger = LoggerFactory.getLogger(ClientWebSocketSessionHandler::class.java)
    }

    // Message 에 Content 에 담겨져 온 Message 타입이 무엇인 지 확인 하는 코드 !
    override fun getPayloadType(headers: StompHeaders): Type {
        return Any::class.java
    }

    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        logger.info(">>>>> Handle Frame !!, $headers")
        // 메세지는 Frame 단위로 옴 !
        val responseRawMessage = String(payload as ByteArray)
        val responseMessage = objectMapper.readValue(responseRawMessage, ResponseMessage::class.java)

        logger.info("Content : ${responseMessage.content}")
    }

    // Connection 이 끝난 뒤에는 간단 히 메세지만 보냄 !
    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        logger.info(">>> afterConnected")

        // 구독
        session.subscribe(SUBSCRIPTION_TOPIC, this)
        val params: MutableMap<String, Any> = HashMap()
        params["message"] = "반갑습니다. 저는 2번째 클라이언트입니다."

        // 메세지 보냄
        session.send(PUBLISH_DEST, params)
        logger.info ("params = $params")
    }

    override fun handleException(
        session: StompSession,
        command: StompCommand?,
        headers: StompHeaders,
        payload: ByteArray,
        exception: Throwable
    ) {
        logger.info(">>> handleException" )
        logger.info("exception: $exception" )
    }

    override fun handleTransportError(session: StompSession, exception: Throwable) {
        logger.info(">>> handleTransportError, ${exception.message}")
    }
}
