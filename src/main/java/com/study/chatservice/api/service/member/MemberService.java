package com.study.chatservice.api.service.member;

import com.study.chatservice.api.controller.member.response.MemberResponse;
import com.study.chatservice.api.service.member.dto.CreateMemberDto;
import com.study.chatservice.domain.member.Member;
import com.study.chatservice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse createMember(CreateMemberDto dto) {
        Member member = dto.toEntity();

        Member savedMember = memberRepository.save(member);

        return MemberResponse.of(savedMember);
    }
}
