package com.kyj.global.base.controller;

import com.kyj.domain.article.controller.ArticleController;
import com.kyj.domain.article.dto.Article;
import com.kyj.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SystemController {
  private ArticleController articleController;

  public SystemController() {
    articleController = Container.articleController;

  }

  public void run() {
    Scanner sc = Container.sc;
    System.out.println("== 자바 게시판 시작==");

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine().trim();

      if(cmd.trim().isEmpty()){
        System.out.println("명령어를 입력해주세요.");
        continue;
      }

      if(cmd.equals("exit")){
        System.out.println("프로그램을 종료합니다.");
        System.out.println("== 자바 게시판 종료==");

        sc.close();
        break;
      }
      String[] urlBits = cmd.trim().split("/");

      if(urlBits.length<4){
        System.out.println("올바른 명령어 형식이 아닙니다. (예: /usr/article/list");
        continue;
      }
      String urlPathUserType = urlBits[1];
      String urlPathUserResource = urlBits[2];
      String urlPathUserAction = urlBits[3];
      String urlPathVariable = null;

      if (urlBits.length > 4) {
        urlPathVariable = urlBits[4];
      }

      if(!urlPathUserType.startsWith("usr")){
        System.out.println("명령어를 잘못입력하셨습니다.");
        continue;
      }

      switch (urlPathUserType) {
        case "usr" -> {
          switch (urlPathUserResource) {
            case "article" -> {
              switch (urlPathUserAction) {
                case "write" -> articleController.doWrite();
                case "detail" -> articleController.showDetail(urlPathVariable);
                case "list" -> articleController.showList();

              }
            }
          }
        }
      }

    }
  }
}