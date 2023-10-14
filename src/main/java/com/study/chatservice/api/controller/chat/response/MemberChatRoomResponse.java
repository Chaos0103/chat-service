package com.study.chatservice.api.controller.chat.response;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberChatRoomResponse {

    private Long chatRoomId;
    private String title;
    private int participantCount;

    @Builder
    public MemberChatRoomResponse(Long chatRoomId, String title, int participantCount) {
        this.chatRoomId = chatRoomId;
        this.title = title;
        this.participantCount = participantCount;
    }
}
