package com.kyj.global.base.container;

import com.kyj.domain.article.Board.repository.BoardRepository;
import com.kyj.domain.article.Board.service.BoardService;
import com.kyj.domain.article.article.controller.ArticleController;
import com.kyj.domain.article.article.repository.ArticleRepository;
import com.kyj.domain.article.article.service.ArticleService;
import com.kyj.domain.member.controller.MemberController;
import com.kyj.domain.member.repository.MemberRepository;
import com.kyj.domain.member.service.MemberService;
import com.kyj.global.base.interceptor.NeedLoginInterceptor;
import com.kyj.global.base.interceptor.NeedLogoutInterceptor;
import com.kyj.global.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static NeedLoginInterceptor needLoginInterceptor;
  public static NeedLogoutInterceptor needLogoutInterceptor;

  public static BoardRepository boardRepository;
  public static ArticleRepository articleRepository;
  public static MemberRepository memberRepository;

  public static BoardService boardService;
  public static ArticleService articleService;
  public static MemberService memberService;

  public static ArticleController articleController;
  public static MemberController memberController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    needLoginInterceptor = new NeedLoginInterceptor();
    needLogoutInterceptor = new NeedLogoutInterceptor();

    boardRepository = new BoardRepository();
    articleRepository = new ArticleRepository();
    memberRepository = new MemberRepository();

    boardService = new BoardService();
    articleService = new ArticleService();
    memberService = new MemberService();


    articleController = new ArticleController();
    memberController = new MemberController();

  }
}
