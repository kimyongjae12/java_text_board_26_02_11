package com.kyj.global.base.container;

import com.kyj.domain.article.controller.ArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;

  public static ArticleController articleController;
  static {
    sc = new Scanner(System.in);
    articleController = new ArticleController();
  }
}
