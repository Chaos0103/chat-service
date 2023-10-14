package com.study.chatservice.api.controller.member.response;

import com.study.chatservice.domain.member.Member;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberResponse {

    private Long memberId;
    private String email;
    private String name;
    private String nickname;
    private LocalDateTime createdDate;

    @Builder
    private MemberResponse(Long memberId, String email, String name, String nickname, LocalDateTime createdDate) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.createdDate = createdDate;
    }

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
            .memberId(member.getId())
            .email(member.getEmail())
            .name(member.getName())
            .nickname(member.getNickname())
            .createdDate(member.getCreatedDate())
            .build();
    }
}
