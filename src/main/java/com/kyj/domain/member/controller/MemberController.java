package com.kyj.domain.member.controller;

import com.kyj.domain.article.dto.Article;
import com.kyj.domain.member.member.dto.Member;
import com.kyj.domain.member.service.MemberService;
import com.kyj.global.base.container.Container;
import com.kyj.global.base.controller.BaseController;
import com.kyj.global.base.rq.Rq;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class MemberController implements BaseController {
  private MemberService memberService;


  public MemberController() {
    memberService = Container.memberService;
  }

  @Override
  public void doAction(Rq rq) {
    switch (rq.getUrlPathUserAction()) {
      case "join" -> doJoin();
    }
  }

  private void doJoin() {
    String username;
    String password;
    String passwordConfirm;
    String name;
    Member oldMember;
    System.out.println("== 회원 가입 ==");

    // 아이디
    while (true) {
      System.out.printf("아이디 : ");
      username = Container.sc.nextLine();

      oldMember = memberService.findByUsername(username);

      if(oldMember != null) {
        System.out.println("이미 존재하는 아이디입니다.");
        continue;
      }

      if (username.trim().isEmpty()) {
        System.out.println("아이디를 입력해주세요.");
        continue;
      }
      break;
    }
    // 비밀번호
    while (true) {
      System.out.printf("비밀번호 : ");
      password = Container.sc.nextLine();

      if (password.trim().isEmpty()) {
        System.out.println("비밀번호를 입력해주세요.");
        continue;
      }
      break;
    }
      while (true) {
      System.out.printf("비밀번호 확인: ");
      passwordConfirm = Container.sc.nextLine();

      if (passwordConfirm.trim().isEmpty()) {
        System.out.println("비밀번호 확인을 입력해주세요.");
        continue;
      }
      if (!passwordConfirm.equals(password)) {
        System.out.println("비밀번호가 일치하지 않습니다.");
        continue;
      }
      break;
    }
    while (true) {
      System.out.printf("이름 : ");
      name = Container.sc.nextLine();

      if (name.trim().isEmpty()) {
        System.out.println("이름을 입력해주세요.");
        continue;
      }
      break;
    }

    Member member = memberService.join(username, password, name);


    System.out.printf("'%s'님 회원 가입 되었습니다.\n",member.getName());
  }
}

