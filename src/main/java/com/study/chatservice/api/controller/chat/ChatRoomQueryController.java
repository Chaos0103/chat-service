package com.study.chatservice.api.controller.chat;

import com.study.chatservice.api.ApiResponse;
import com.study.chatservice.api.controller.chat.response.MemberChatRoomResponse;
import com.study.chatservice.api.service.chat.ChatRoomQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/chat-rooms")
public class ChatRoomQueryController {

    private final ChatRoomQueryService chatRoomQueryService;

    @GetMapping("/{memberId}")
    public ApiResponse<List<MemberChatRoomResponse>> searchMyChatRoom(@PathVariable Long memberId) {
        log.debug("call ChatRoomQueryController#searchMyChatRoom");
        log.debug("request memberId={}", memberId);

        List<MemberChatRoomResponse> responses = chatRoomQueryService.searchMyChatRoom(memberId);
        log.debug("List<MemberChatRoomResponse>={}", responses);

        return ApiResponse.ok(responses);
    }
}
