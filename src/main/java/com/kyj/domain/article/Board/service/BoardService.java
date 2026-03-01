package com.kyj.domain.article.Board.service;

import com.kyj.domain.article.Board.dto.Board;
import com.kyj.domain.article.Board.repository.BoardRepository;
import com.kyj.global.base.container.Container;

public class BoardService {
  private BoardRepository boardRepository;
  public BoardService() {
    boardRepository = Container.boardRepository;

  }

  public Board findByBoardId(int id) {
    return boardRepository.findByBoardId(id);
  }

  public Board findByBoardName(String boardName) {
    return boardRepository.findByBoardName(boardName);
  }

  public Board findByBoardCode(String boardCode) {
    return boardRepository.findByBoardCode(boardCode);
  }

  public void add(String name, String code) {
    boardRepository.add(name, code);
  }
}
