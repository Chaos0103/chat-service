package com.study.chatservice.domain.chat.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.chatservice.api.controller.chat.response.MemberChatRoomResponse;
import com.study.chatservice.domain.chat.QChatRoom;
import com.study.chatservice.domain.chat.QMemberChatRoom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.study.chatservice.domain.chat.QChatRoom.chatRoom;
import static com.study.chatservice.domain.chat.QMemberChatRoom.memberChatRoom;

@Repository
public class ChatRoomQueryRepository {

    private final JPAQueryFactory queryFactory;

    public ChatRoomQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<MemberChatRoomResponse> findByMemberId(Long memberId) {
        return queryFactory
            .select(Projections.constructor(MemberChatRoomResponse.class,
                chatRoom.id,
                chatRoom.title,
                chatRoom.memberChatRooms.size()
            ))
            .from(memberChatRoom)
            .join(memberChatRoom.chatRoom, chatRoom)
            .where(memberChatRoom.member.id.eq(memberId))
            .fetch();
    }
}
