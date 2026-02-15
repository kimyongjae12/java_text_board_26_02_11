package com.kyj.domain.article.controller;

import com.kyj.domain.article.dto.Article;
import com.kyj.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArticleController {
  List<Article> articles;
  int lastId;

  public ArticleController() {
    articles = new ArrayList<>();

    makeArticleTestData(articles);

    lastId = articles.getLast().id;
  }

  void makeArticleTestData(List<Article> articles) {
    IntStream.rangeClosed(1, 5)
        .forEach(
            i -> articles.add(new Article(i, "제목" + i, "내용" + i))
        );
  }

  public void doWrite() {
    System.out.println("== 게시물 작성==");
    System.out.print("제목 :");
    String title = Container.sc.nextLine();

    System.out.print("내용 :");
    String content = Container.sc.nextLine();


    int id = ++lastId;

    Article article = new Article(id, title, content);

    articles.add(article);


    System.out.printf("%d번 게시물이 등록 되었습니다.\n", id);
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
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }
    // 내가 입력한 id와 리스트 내부에 있는 게시물 객체의 id랑 일치한 게시물 객체만 필터링

    int finalId = id;
    Article findArticle = articles.stream()
        .filter(article -> article.id == finalId)
        .findFirst().orElse(null); // 찾은 것 중에 첫 번째 리턴 else null


    if (findArticle == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.printf("== %d번 게시물 상세보기 ==\n", findArticle.id);
    System.out.printf("번호 : %d\n", findArticle.id);
    System.out.printf("제목 : %s\n", findArticle.title);
    System.out.printf("내용 : %s\n", findArticle.content);
  }

  public void showList() {
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


