package com.kyj.domain.article.service;

import com.kyj.domain.article.dto.Article;
import com.kyj.domain.article.repository.ArticleRepository;
import com.kyj.global.base.container.Container;

import java.util.List;

public class ArticleService {

  public ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public Article write(String title, String content) {

    return articleRepository.write(title,content);
  }

  public List<Article> getArticles() {
    return articleRepository.findByAll();
  }

  public Article findById(int id) {
    return articleRepository.finById(id);
  }

  public void modify(int id, String title, String content) {
    articleRepository.modify(id, title, content);
  }
}
