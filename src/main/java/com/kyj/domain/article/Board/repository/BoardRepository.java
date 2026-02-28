package com.kyj.domain.article.Board.repository;

import com.kyj.domain.article.Board.dto.Board;
import com.kyj.domain.article.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardRepository {
  private List<Board> boards;

  public BoardRepository() {
    boards = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    boards.add(new Board("자유", "free"));
    boards.add(new Board("공지", "notice"));
  }

  public Board findByBoardId(int id) {
    return boards.stream()
        .filter(Board -> Board.getId() == id)
        .findFirst().orElse(null); // 찾은 것 중에 첫 번째 리턴 else null
  }
}
