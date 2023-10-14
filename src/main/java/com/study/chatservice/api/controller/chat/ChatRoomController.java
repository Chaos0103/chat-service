package com.study.chatservice.api.controller.chat;

import com.study.chatservice.api.ApiResponse;
import com.study.chatservice.api.controller.chat.request.CreateChatRoomRequest;
import com.study.chatservice.api.controller.chat.response.ChatRoomResponse;
import com.study.chatservice.api.service.chat.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/chat-rooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/create")
    public ApiResponse<ChatRoomResponse> createChatRoom(@RequestBody CreateChatRoomRequest request) {
        log.debug("call ChatRoomController#createChatRoom");
        log.debug("CreateChatRoomRequest={}", request);

        ChatRoomResponse response = chatRoomService.createChatRoom(request.toDto());
        log.debug("ChatRoomResponse={}", response);

        return ApiResponse.created(response);
    }
}
