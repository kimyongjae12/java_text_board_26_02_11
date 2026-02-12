package com.kyj;


import com.kyj.domain.article.Article;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lastId = 0;

    System.out.println("== 자바 게시판 시작==");

    while(true){
      System.out.print("명령) ");
      String cmd = sc.nextLine();
      if(cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성==");
        System.out.print("제목 :");
        String title = sc.nextLine();

        System.out.print("내용 :");
        String content = sc.nextLine();


        int id = ++lastId;

        Article article = new Article();

        article.id = id;
        article.title = title;
        article.content = content;

        System.out.println("생성 된 게시물 객체 :" + article);

        System.out.printf("%d번 게시물이 등록 되었습니다.\n",id);
      }
      else if(cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else {
        System.out.println("명령어 확인 후 다시 입력해주세요.");
      }

      System.out.println("입력받은 명령어 : " + cmd);
    }
    System.out.println("== 자바 게시판 종료");

    sc.close();
  }
}