package com.study.chatservice.api.controller.chat;

import com.study.chatservice.api.ApiResponse;
import com.study.chatservice.api.controller.chat.request.CreateChatRequest;
import com.study.chatservice.api.controller.chat.response.ChatResponse;
import com.study.chatservice.api.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/{chatRoomId}/send/{memberId}")
    public ApiResponse<ChatResponse> sendChat(
        @PathVariable Long chatRoomId,
        @PathVariable Long memberId,
        @RequestBody CreateChatRequest request
        ) {
        log.debug("call ChatController#sendChat");

        ChatResponse response = chatService.createChat(memberId, chatRoomId, request.getContent());
        log.debug("ChatResponse={}", response);

        return ApiResponse.created(response);
    }
}
