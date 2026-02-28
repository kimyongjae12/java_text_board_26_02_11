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
  private String title;
  private String content;
  private int memberId;
  private String writerName;


  static {
    lastId = 0;
  }

  public Article(String title, String content, int memberId, String writerName) {
    this(++lastId, title, content, memberId, writerName);

  }
}
