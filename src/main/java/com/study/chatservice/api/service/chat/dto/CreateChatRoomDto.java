package com.study.chatservice.api.service.chat.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateChatRoomDto {

    private String title;
    private List<Long> memberIds;

    @Builder
    private CreateChatRoomDto(String title, List<Long> memberIds) {
        this.title = title;
        this.memberIds = memberIds;
    }
}
