package com.study.chatting.config

import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent

@Component
class WebSocketEventHandler {

    private val logger = LoggerFactory.getLogger(WebSocketEventHandler::class.java)

    @EventListener
    fun handleWebSocketSessionConnectEventListener(event: SessionConnectEvent) {
        logger.info ( ">>> Received a SessionConnectEvent")
    }

    @EventListener
    fun handleWebSocketSessionSubscribeEventListener(event: SessionSubscribeEvent) {
        logger.info ( ">>> Received a SessionSubscribeEvent" )
    }

    @EventListener
    fun handleWebSocketSessionUnsubscribeEventListener(event: SessionUnsubscribeEvent) {
        logger.info ( ">>> Received a SessionSubscribeEvent" )
    }

    @EventListener
    fun handleWebSocketSessionConnectedEventListener(event: SessionConnectedEvent) {
        logger.info ( ">>> Received a SessionConnectedEvent" )
    }

    @EventListener
    fun handleWebSocketSessionDisconnectEventListene(event: SessionDisconnectEvent) {
        logger.info ( ">>> Received a SessionDisconnectEvent" )
    }
}
