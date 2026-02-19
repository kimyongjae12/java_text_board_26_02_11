package com.kyj.domain.article.service;

import com.kyj.domain.article.dto.Article;
import com.kyj.domain.article.repository.ArticleRepository;
import com.kyj.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
}
