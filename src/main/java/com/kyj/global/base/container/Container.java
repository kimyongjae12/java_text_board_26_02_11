package com.kyj.global.base.container;

import com.kyj.Main;
import com.kyj.domain.article.controller.ArticleController;
import com.kyj.domain.article.repository.ArticleRepository;
import com.kyj.domain.article.service.ArticleService;
import com.kyj.domain.member.controller.MemberController;
import com.kyj.domain.member.member.dto.Member;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleRepository articleRepository;

  public static ArticleService articleService;

  public static ArticleController articleController;

  public static MemberController memberController;

  static {
    sc = new Scanner(System.in);

    articleRepository = new ArticleRepository();
    articleService = new ArticleService();

    articleController = new ArticleController();
    memberController = new MemberController();

  }
}
