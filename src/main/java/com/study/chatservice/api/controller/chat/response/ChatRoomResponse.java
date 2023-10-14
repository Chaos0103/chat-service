package com.study.chatservice.api.controller.chat.response;

import com.study.chatservice.domain.chat.ChatRoom;
import lombok.Builder;
import lombok.Data;

@Data
public class ChatRoomResponse {

    private Long chatRoomId;
    private String title;
    private int participantCount;

    @Builder
    private ChatRoomResponse(Long chatRoomId, String title, int participantCount) {
        this.chatRoomId = chatRoomId;
        this.title = title;
        this.participantCount = participantCount;
    }

    public static ChatRoomResponse of(ChatRoom chatRoom) {
        return ChatRoomResponse.builder()
            .chatRoomId(chatRoom.getId())
            .title(chatRoom.getTitle())
            .participantCount(chatRoom.getMemberChatRooms().size())
            .build();
    }
}
