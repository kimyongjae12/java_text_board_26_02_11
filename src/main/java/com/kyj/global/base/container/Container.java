package com.kyj.global.base.container;

import com.kyj.Main;
import com.kyj.domain.article.controller.ArticleController;
import com.kyj.domain.article.repository.ArticleRepository;
import com.kyj.domain.article.service.ArticleService;
import com.kyj.domain.member.controller.MemberController;
import com.kyj.domain.member.member.dto.Member;
import com.kyj.domain.member.repository.MemberRepository;
import com.kyj.domain.member.service.MemberService;
import com.kyj.global.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static ArticleRepository articleRepository;
  public static MemberRepository memberRepository;

  public static ArticleService articleService;
  public static MemberService memberService;

  public static ArticleController articleController;
  public static MemberController memberController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    articleRepository = new ArticleRepository();
    memberRepository = new MemberRepository();

    articleService = new ArticleService();
    memberService = new MemberService();


    articleController = new ArticleController();
    memberController = new MemberController();

  }
}
