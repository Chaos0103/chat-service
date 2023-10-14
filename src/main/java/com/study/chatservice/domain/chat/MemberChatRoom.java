package com.study.chatservice.domain.chat;

import com.study.chatservice.domain.TimeBaseEntity;
import com.study.chatservice.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberChatRoom extends TimeBaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_chat_room_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @Builder
    private MemberChatRoom(Member member, ChatRoom chatRoom) {
        this.member = member;
        this.chatRoom = chatRoom;
        this.chatRoom.addMemberChatRoom(this);
    }
}
