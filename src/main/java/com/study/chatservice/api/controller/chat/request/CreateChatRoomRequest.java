package com.study.chatservice.api.controller.chat.request;

import com.study.chatservice.api.service.chat.dto.CreateChatRoomDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CreateChatRoomRequest {

    private String title;
    private List<Long> memberIds;

    @Builder
    private CreateChatRoomRequest(String title, List<Long> memberIds) {
        this.title = title;
        this.memberIds = memberIds;
    }

    public CreateChatRoomDto toDto() {
        return CreateChatRoomDto.builder()
            .title(this.title)
            .memberIds(this.memberIds)
            .build();
    }
}
