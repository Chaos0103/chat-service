package com.study.chatservice.domain.member.repository;

import com.study.chatservice.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByIdIn(List<Long> ids);
}
