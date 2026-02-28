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
    return articleRepository.findByAll();
  }


  public List<Article> getArticles(String keyword, String sortcode) {
    // 검색 수행
    List<Article> filteredArticles = getFilteredArticles(keyword);
    // 정렬 수행
    return sortedArticles(filteredArticles, sortcode);
  }

  private List<Article> sortedArticles(List<Article> articles, String sortcode) {
    List<Article> sortedArticles = new ArrayList<>(articles);

    if(!sortcode.isEmpty()){
      switch (sortcode){
        case "idAsc":
          sortedArticles.sort((a1,a2)-> a1.getId() - a2.getId());
          break;
        case "idDesc":
          sortedArticles.sort((a1,a2)-> a2.getId() - a1.getId());
          break;
      }
    }

    return sortedArticles;
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
