package com.kyj.domain.article.Board.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // public Article(int id, String title, String content))
@NoArgsConstructor  // public Article() {}
@ToString
public class Board {
  private static int lastId;
  private int id;
  private String name;// notice, free
  private String code; // 공지사항, 자유


  static {
    lastId = 0;
  }

  public Board(String name, String code) {
    this(++lastId, name, code);

  }
}