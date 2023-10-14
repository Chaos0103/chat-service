package com.study.chatservice.api.controller.member.request;

import com.study.chatservice.api.service.member.dto.CreateMemberDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateMemberRequest {

    private String email;
    private String password;
    private String name;
    private String nickname;

    @Builder
    private CreateMemberRequest(String email, String password, String name, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public CreateMemberDto toDto() {
        return CreateMemberDto.builder()
            .email(this.email)
            .password(this.password)
            .name(this.name)
            .nickname(this.nickname)
            .build();
    }
}
