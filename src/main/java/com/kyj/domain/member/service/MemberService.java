package com.kyj.domain.member.service;

import com.kyj.domain.member.member.dto.Member;
import com.kyj.domain.member.repository.MemberRepository;
import com.kyj.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
  private MemberRepository memberRepository;


  public MemberService(){
    memberRepository = Container.memberRepository;
  }


  public Member join(String username, String password, String name) {

    return memberRepository.join(username, password, name);
  }

  public Member findByUsername(String username) {
    return memberRepository.findByUsername(username);
  }

  public Member findById(int id){
    return memberRepository.findById(id);
  }
}
