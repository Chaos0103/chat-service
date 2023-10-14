package com.study.chatservice.api.controller.chat.response;

import com.study.chatservice.domain.chat.Chat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatResponse {

    private String sender;
    private String chatRoomTitle;
    private String content;
    private LocalDateTime createdDate;

    @Builder
    private ChatResponse(String sender, String chatRoomTitle, String content, LocalDateTime createdDate) {
        this.sender = sender;
        this.chatRoomTitle = chatRoomTitle;
        this.content = content;
        this.createdDate = createdDate;
    }

    public static ChatResponse of(Chat chat) {
        return ChatResponse.builder()
            .sender(chat.getMember().getNickname())
            .chatRoomTitle(chat.getChatRoom().getTitle())
            .content(chat.getContent())
            .createdDate(chat.getCreatedDate())
            .build();
    }
}
