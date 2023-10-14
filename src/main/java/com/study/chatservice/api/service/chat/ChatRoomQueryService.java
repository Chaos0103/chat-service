package com.study.chatservice.api.service.chat;

import com.study.chatservice.api.controller.chat.response.MemberChatRoomResponse;
import com.study.chatservice.domain.chat.repository.ChatRoomQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ChatRoomQueryService {

    private final ChatRoomQueryRepository chatRoomQueryRepository;

    public List<MemberChatRoomResponse> searchMyChatRoom(Long memberId) {
        return chatRoomQueryRepository.findByMemberId(memberId);
    }
}
