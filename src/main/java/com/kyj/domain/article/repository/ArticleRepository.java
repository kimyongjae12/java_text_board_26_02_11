package com.kyj.domain.article.repository;

import com.kyj.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
  private List<Article> articles;

  public ArticleRepository() {
    articles = new ArrayList<>();

    makeArticleTestData();
  }

  void makeArticleTestData() {
    IntStream.rangeClosed(1, 5)
        .forEach(
            i -> write("제목" + i, "내용"+ i)
        );
  }

  public Article write(String title, String content) {
    Article article = new Article(title, content);
    articles.add(article);

    return article;
  }

  public List<Article> findByAll() {
    return articles;
  }

  public Article finById(int id) {
    return articles.stream()
        .filter(article -> article.getId() == id)
        .findFirst().orElse(null); // 찾은 것 중에 첫 번째 리턴 else null

  }
}
