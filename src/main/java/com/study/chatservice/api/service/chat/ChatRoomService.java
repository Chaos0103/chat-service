package com.study.chatservice.api.service.chat;

import com.study.chatservice.api.controller.chat.response.ChatRoomResponse;
import com.study.chatservice.api.service.chat.dto.CreateChatRoomDto;
import com.study.chatservice.domain.chat.ChatRoom;
import com.study.chatservice.domain.chat.repository.ChatRoomRepository;
import com.study.chatservice.domain.member.Member;
import com.study.chatservice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;

    public ChatRoomResponse createChatRoom(CreateChatRoomDto dto) {
        List<Member> members = memberRepository.findByIdIn(dto.getMemberIds());

        if (members.size() != dto.getMemberIds().size()) {
            throw new IllegalArgumentException("채팅방 생성에 문제가 발생했습니다.");
        }

        ChatRoom chatRoom = ChatRoom.createChatRoom(dto.getTitle(), members);

        ChatRoom savedChatRoom = chatRoomRepository.save(chatRoom);

        return ChatRoomResponse.of(savedChatRoom);
    }

}
