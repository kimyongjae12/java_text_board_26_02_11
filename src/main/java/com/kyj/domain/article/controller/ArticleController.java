package com.kyj.domain.article.controller;

import com.kyj.domain.article.dto.Article;
import com.kyj.domain.article.service.ArticleService;
import com.kyj.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArticleController {
  private ArticleService articleService;


  public ArticleController() {
      articleService = Container.articleService;

  }


  public void doWrite() {
    System.out.println("== 게시물 작성==");
    System.out.print("제목 :");
    String title = Container.sc.nextLine();

    System.out.print("내용 :");
    String content = Container.sc.nextLine();

    Article article = articleService.write(title, content);

    System.out.printf("%d번 게시물이 등록 되었습니다.\n", article.id);
  }


  public void showDetail(String urlPathVariable) {
    int id = 0;
    if (urlPathVariable != null) {
      try {
        id = Integer.parseInt(urlPathVariable);
      } catch (NumberFormatException e) {
        System.out.println("id를 숫자형태로 입력해주세요.");
        return;
      }
    }

    List<Article> articles = articleService.getArticles();
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }
    // 내가 입력한 id와 리스트 내부에 있는 게시물 객체의 id랑 일치한 게시물 객체만 필터링


    Article article = articleService.findById(id);


    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.printf("== %d번 게시물 상세보기 ==\n", article.id);
    System.out.printf("번호 : %d\n", article.id);
    System.out.printf("제목 : %s\n", article.title);
    System.out.printf("내용 : %s\n", article.content);
  }

  public void showList() {
    List<Article> articles = articleService.getArticles();

    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }

    System.out.println("== 게시물 리스트 ==");
    System.out.println("번호 | 제목 ");

    for (int i = articles.size() - 1; i >= 0; i--) {
      Article article = articles.get(i);
      System.out.printf("%d | %s\n", article.id, article.title);
    }
  }
}


