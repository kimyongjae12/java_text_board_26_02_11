package com.kyj.domain.member.repository;

import com.kyj.domain.member.member.dto.Member;
import com.kyj.domain.member.member.dto.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MemberRepository {
  private List<Member> members;

  public MemberRepository() {
    members = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    Member member = join("admin","admin","관리자", Role.ROLE_ADMIN);
    members.add(member);

    Member member1 = join("user1","1111","홍길동", Role.ROLE_USER);
    members.add(member1);

    Member member2 = join("user2","2222","신짱구", Role.ROLE_USER);
    members.add(member2);

    Member member3 = join("user3","3333","김철수", Role.ROLE_USER);
    members.add(member3);

  }
  public Member join(String username, String password, String name, Role role){
    Member member = new Member(username, password, name, role);

    members.add(member);

    return member;
  }

  public Member join(String username, String password, String name) {
    Member member;
    if(username.equals("admin")){
      member = new Member(username, password, name, Role.ROLE_ADMIN);
      members.add(member);
    }
    member = new Member(username, password, name, Role.ROLE_USER);
    members.add(member);

    return member;
  }

  public Member findByUsername(String username) {
    return members.stream()
        .filter(member -> member.getUsername().equals(username))
        .findFirst().orElse(null);
  }

  public Member findById(int id) {
    return members.stream()
        .filter(member -> member.getId() == id)
        .findFirst().orElse(null);
  }
}
