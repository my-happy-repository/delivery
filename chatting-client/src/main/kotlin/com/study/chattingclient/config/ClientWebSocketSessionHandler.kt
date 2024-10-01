package com.study.chattingclient.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.annotation.Order
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
@Order(value = 1)
class ClientWebSocketSessionHandler (
    private val objectMapper: ObjectMapper,
): StompSessionHandlerAdapter() {
    // TODO - 아래 메서드 구현 필요ㅕ !!
    override fun getPayloadType(headers: StompHeaders): Type {
        TODO("Not yet implemented")
    }

    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        TODO("Not yet implemented")
    }

    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        TODO("Not yet implemented")
    }

    override fun handleException(
        session: StompSession,
        command: StompCommand?,
        headers: StompHeaders,
        payload: ByteArray,
        exception: Throwable
    ) {
        TODO("Not yet implemented")
    }

    override fun handleTransportError(session: StompSession, exception: Throwable) {
        TODO("Not yet implemented")
    }
}
