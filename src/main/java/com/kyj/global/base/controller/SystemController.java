package com.kyj.global.base.controller;

import com.kyj.domain.article.controller.ArticleController;
import com.kyj.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SystemController {
  private ArticleController articleController;

  public SystemController() {
    articleController = new ArticleController();

  }

  public void run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("== 자바 게시판 시작==");

    while (true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine();

      if(cmd.equals("exit")){
        System.out.println("프로그램을 종료합니다.");
        System.out.println("== 자바 게시판 종료==");
        break;
      }
      String[] urlBits = cmd.trim().split("/");


      String urlPathUserType = urlBits[1];
      String urlPathUserResource = urlBits[2];
      String urlPathUserAction = urlBits[3];
      String urlPathVariable = null;

      if (urlBits.length > 4) {
        urlPathVariable = urlBits[4];
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
        case "exit" -> {

        }
        default -> System.out.println("명령어 확인 후 다시 입력해주세요.");

      }

    }
  }
}