package com.kyj.domain.article.article.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // public Article(int id, String title, String content))
@NoArgsConstructor  // public Article() {}
@ToString
public class Article {
  private static int lastId;
  private int id;
  private String regDate;
  private String updateDate;
  private String title;
  private String content;
  private int memberId;
  private String writerName;
  private int boardId;


  static {
    lastId = 0;
  }

  public Article(String regDate, String updateDate, String title, String content, int memberId, String writerName, int boardId) {

    this(++lastId, regDate, updateDate, title, content, memberId, writerName, boardId);

  }
}
