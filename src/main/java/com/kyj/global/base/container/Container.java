package com.kyj.global.base.container;

import com.kyj.domain.article.controller.ArticleController;
import com.kyj.domain.article.service.ArticleService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleService articleService;

  public static ArticleController articleController;
  static {
    sc = new Scanner(System.in);

    articleService = new ArticleService();
    articleController = new ArticleController();
  }
}
