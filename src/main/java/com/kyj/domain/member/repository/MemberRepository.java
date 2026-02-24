package com.kyj.domain.member.repository;

import com.kyj.domain.member.member.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
  private List<Member> members;

  public MemberRepository() {
    members = new ArrayList<>();
  }

  public Member join(String username, String password, String name) {
    Member member = new Member(username, password, name);

    members.add(member);

    return member;
  }

  public Member findByUsername(String username) {
    return members.stream()
        .filter(member -> member.getUsername().equals(username))
        .findFirst().orElse(null);
  }
}
