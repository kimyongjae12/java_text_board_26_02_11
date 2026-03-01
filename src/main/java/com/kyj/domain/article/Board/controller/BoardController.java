package com.kyj.domain.article.Board.controller;

import com.kyj.domain.article.Board.dto.Board;
import com.kyj.domain.article.Board.service.BoardService;
import com.kyj.domain.member.member.dto.Member;
import com.kyj.global.base.container.Container;
import com.kyj.global.base.controller.BaseController;
import com.kyj.global.base.rq.Rq;

public class BoardController implements BaseController {
  private BoardService boardService;

  public BoardController() {
    boardService = Container.boardService;
  }


  @Override
  public void doAction(Rq rq) {
    switch (rq.getUrlPathUserAction()) {
      case "add" -> doAdd(rq);
    }
  }

  private void doAdd(Rq rq) {
    Member member = rq.getLoginedMember();

    if(!member.isAdmin()){
      System.out.println("관리자만 해당 기능을 사용할 수 있습니다.");
      return;
    }
    String boardName;
    String boardCode;

    System.out.println("== 게시판 추가 ==");

    // 게시판 이름 입력
    while (true) {
      System.out.print("게시판 이름 : ");
      boardName = Container.sc.nextLine();

      if(boardName.trim().isEmpty()) {
        System.out.println("게시판 이름을 입력해주세요.");
        continue;
      }

      Board boardByName = boardService.findByBoardName(boardName);

      if(boardByName != null) {
        System.out.printf("'%s' 게시판은 이미 존재하는 게시판입니다.\n",boardName);
        continue;
      }

      break;
    }

    System.out.println("== 게시판 코드 예시 ==");
    System.out.println("예: free, notice, qna, etc ...");
    System.out.println("=".repeat(20));
    // 게시판 코드 입력
    while (true) {
      System.out.print("게시판 코드(영문) : ");
      boardCode = Container.sc.nextLine();

      if(boardCode.trim().isEmpty()) {
        System.out.println("게시판 코드를 입력해주세요.");
        continue;
      }

      Board boardByCode = boardService.findByBoardCode(boardCode);

      if(boardByCode != null) {
        System.out.printf("'%s' 게시판은 이미 존재하는 코드입니다.\n",boardCode);
        continue;
      }

      break;
    }
    boardService.add(boardName, boardCode);

    System.out.printf("'%s' 게시판이 생성되었습니다.\n", boardName);
  }
}
