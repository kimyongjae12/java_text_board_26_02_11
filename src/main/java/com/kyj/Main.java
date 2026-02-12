package com.kyj;


import com.kyj.domain.article.Article;

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Article> articles = new ArrayList<>();
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


        articles.add(article);


        System.out.printf("%d번 게시물이 등록 되었습니다.\n",id);
      } else if(cmd.startsWith("/usr/article/detail")){
        String[] urlBits = cmd.trim().split("/");

        //int id = Integer.parseInt(urlBits[4]);

        if(articles.isEmpty()){
          System.out.println("게시물이 존재하지 않습니다");
          continue;
        }
        Article article = articles.get(articles.size() -1 ); // getLast()

        if(article == null){
          System.out.println("해당 게시물은 존재하지 않습니다");
          continue;
        }

        System.out.printf("== %d번 게시물 상세보기 ==\n", article.id);
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.content);
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