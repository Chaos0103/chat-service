package com.study.chatservice.api.controller.member;

import com.study.chatservice.api.ApiResponse;
import com.study.chatservice.api.controller.member.request.CreateMemberRequest;
import com.study.chatservice.api.controller.member.response.MemberResponse;
import com.study.chatservice.api.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ApiResponse<MemberResponse> join(@RequestBody CreateMemberRequest request) {
        log.debug("call MemberController#join");
        log.debug("CreateMemberRequest={}", request);

        MemberResponse response = memberService.createMember(request.toDto());
        log.debug("MemberResponse={}", response);

        return ApiResponse.created(response);
    }
}
