package com.kyj.domain.article.Board.repository;

import com.kyj.domain.article.Board.dto.Board;
import com.kyj.domain.article.article.dto.Article;
import com.kyj.global.util.Ut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardRepository {
  private List<Board> boards;

  public BoardRepository() {
    boards = new ArrayList<>();

    makeTestData();
  }

  void makeTestData() {
    add("자유", "free");
    add("공지", "notice");
  }

  public Board findByBoardId(int id) {
    return boards.stream()
        .filter(Board -> Board.getId() == id)
        .findFirst().orElse(null); // 찾은 것 중에 첫 번째 리턴 else null
  }

  public Board findByBoardName(String boardName) {
    return this.boards.stream()
        .filter(board -> board.getName().equals(boardName))
        .findFirst().orElse(null);
  }

  public Board findByBoardCode(String boardCode) {
    return this.boards.stream()
        .filter(board -> board.getCode().equals(boardCode))
        .findFirst().orElse(null);
  }

  public void add(String name, String code) {
    String regDate = Ut.getNowDateStr();
    String updateDate = Ut.getNowDateStr();

    Board board = new Board(regDate, updateDate, name, code);

    boards.add(board);
  }
}
