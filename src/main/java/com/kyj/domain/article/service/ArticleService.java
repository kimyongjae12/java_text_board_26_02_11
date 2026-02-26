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

  public Article write(String title, String content, int writerId, String writerName) {

    return articleRepository.write(title,content, writerId, writerName);
  }
  public List<Article> getArticles() {
    return articleRepository.findByAll();
  }


  public List<Article> getArticles(String keyword) {
    if(keyword.isEmpty()) return articleRepository.findByAll();

    return getFilteredArticles(keyword);
  }

  private List<Article> getFilteredArticles(String keyword) {
    return articleRepository.findByKeywordContaining(keyword);
  }

  public Article findById(int id) {
    return articleRepository.finById(id);
  }

  public void modify(int id, String title, String content) {
    articleRepository.modify(id, title, content);
  }

  public void delete(int id) {
    articleRepository.delete(id);
  }
}
