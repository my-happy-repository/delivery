package com.study.chatting.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ChattingMessage(
    @JsonProperty("message")
    val message: String,
)
