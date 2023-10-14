package com.study.chatservice.api.service.member.dto;

import com.study.chatservice.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateMemberDto {

    private String email;
    private String password;
    private String name;
    private String nickname;

    @Builder
    private CreateMemberDto(String email, String password, String name, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public Member toEntity() {
        return Member.builder()
            .email(this.email)
            .password(this.password)
            .name(this.name)
            .nickname(this.nickname)
            .build();
    }
}
