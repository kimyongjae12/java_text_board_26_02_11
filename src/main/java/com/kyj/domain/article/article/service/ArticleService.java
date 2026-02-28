package com.kyj.domain.article.article.service;

import com.kyj.domain.article.article.dto.Article;
import com.kyj.domain.article.article.repository.ArticleRepository;
import com.kyj.global.base.container.Container;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {

  public ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public Article write(String title, String content, int writerId, String writerName, int boardId) {

    return articleRepository.write(title,content, writerId, writerName, boardId);
  }
  public List<Article> getArticles() {
    return articleRepository.findAll();
  }

  public List<Article> getArticles(String keyword, String sortCode, int boardId) {
    List<Article> articles = articleRepository.findAll();

    // 1. 게시판 필터링
    articles = getBoardArticles(articles, boardId);

    // 2. 키워드 필터링
    articles = getFilteredArticles(articles, keyword);

    // 3. 정렬
    articles = getsortedArticles(articles, sortCode);

    // 정렬 수행
    return articles;
  }

  private List<Article> getsortedArticles(List<Article> articles, String sortcode) {

    List<Article> sorted = new ArrayList<>(articles);

    if(!sortcode.isEmpty()){
      switch (sortcode){
        case "idAsc":
          sorted.sort((a1,a2)-> a1.getId() - a2.getId());
          break;
        case "idDesc":
          sorted.sort((a1,a2)-> a2.getId() - a1.getId());
          break;
      }
    }

    return sorted;
  }

  private List<Article> getBoardArticles(List<Article> articles, int boardId) {
    return articleRepository.findByBoardId(articles, boardId);
    }

  private List<Article> getFilteredArticles(List<Article> articles, String keyword) {
    return articleRepository.findByKeywordContaining(articles, keyword);
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
