package com.study.chatservice.api.service.chat;

import com.study.chatservice.api.controller.chat.response.ChatResponse;
import com.study.chatservice.domain.chat.Chat;
import com.study.chatservice.domain.chat.ChatRoom;
import com.study.chatservice.domain.chat.repository.ChatRepository;
import com.study.chatservice.domain.chat.repository.ChatRoomRepository;
import com.study.chatservice.domain.member.Member;
import com.study.chatservice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Transactional
public class ChatService {

    private final ChatRepository chatRepository;
    private final MemberRepository memberRepository;
    private final ChatRoomRepository chatRoomRepository;

    public ChatResponse createChat(Long memberId, Long chatRoomId, String content) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(NoSuchElementException::new);

        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
            .orElseThrow(NoSuchElementException::new);

        Chat chat = toEntity(member, chatRoom, content);

        Chat savedChat = chatRepository.save(chat);

        return ChatResponse.of(savedChat);
    }

    private Chat toEntity(Member member, ChatRoom chatRoom, String content) {
        return Chat.builder()
            .content(content)
            .member(member)
            .chatRoom(chatRoom)
            .build();
    }
}
