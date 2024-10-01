package com.study.chatting.controller

import com.study.chatting.controller.dto.ChattingMessage
import com.study.chatting.controller.dto.ChattingResponse
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils

@Controller
class ChattingController {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @MessageMapping("/chatting-message")
    @SendTo("/topic/chatting")
    fun chatting(chattingMessage: ChattingMessage): ChattingResponse {
        logger.info("Chatting Message Response ! $chattingMessage")

        return ChattingResponse(HtmlUtils.htmlEscape(chattingMessage.message))
    }
}
