package com.kyj.domain.article.dto;

public class Article {
  private static int lastId;
  private int id;
  private String title;
  private String content;

  public Article(int id, String title, String content){
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public Article(String title, String content) {
    this(++lastId, title, content);

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "{id: %d, title: '%s', content: '%s'}".formatted(id, title, content);
  }
}
