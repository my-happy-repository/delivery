package com.canbe.websocket

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfiguration: WebSocketConfigurer {
    val log = LoggerFactory.getLogger(WebSocketConfiguration::class.java)

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        log.info("")
        registry.addHandler(WebSocketHandler(), "/hello")
            .setAllowedOrigins("*")
    }

    @Bean
    fun simpleWebSocketHandler(): WebSocketHandler =
        WebSocketHandler()
}