package com.canbe.websocket

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class WebSocketHandler: TextWebSocketHandler() {

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println(">>>> Connection Closed ${session.id}")
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(">>>> Service Message : $message")
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println(">>>> Connection Established ${session.id}")
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        println(">>>> Connection Error: $exception")
    }
}
