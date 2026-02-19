package com.kyj.domain.article.dto;

public class Article {
  public  static int lastId;
  public int id;
  public String title;
  public String content;

  public Article(int id, String title, String content){
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public Article(String title, String content) {
    this(++lastId, title, content);

  }


  @Override
  public String toString() {
    return "{id: %d, title: '%s', content: '%s'}".formatted(id, title, content);
  }
}
