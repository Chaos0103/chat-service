package com.study.chatservice.domain.chat;

import com.study.chatservice.domain.TimeBaseEntity;
import com.study.chatservice.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends TimeBaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberChatRoom> memberChatRooms = new ArrayList<>();

    @Builder
    private ChatRoom(String title) {
        this.title = title;
    }

    //== 연관관계 편의 메서드 ==//
    public static ChatRoom createChatRoom(String title, List<Member> members) {
        ChatRoom chatRoom = ChatRoom.builder()
            .title(title)
            .build();

        for (Member member : members) {
            MemberChatRoom memberChatRoom = MemberChatRoom.builder()
                .member(member)
                .chatRoom(chatRoom)
                .build();
        }

        return chatRoom;
    }

    public void addMemberChatRoom(MemberChatRoom memberChatRoom) {
        this.memberChatRooms.add(memberChatRoom);
    }
}
