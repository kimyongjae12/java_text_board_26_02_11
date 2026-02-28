package com.kyj.domain.article.article.controller;

import com.kyj.domain.article.Board.dto.Board;
import com.kyj.domain.article.Board.service.BoardService;
import com.kyj.domain.article.article.dto.Article;
import com.kyj.domain.article.article.service.ArticleService;
import com.kyj.domain.member.member.dto.Member;
import com.kyj.domain.member.service.MemberService;
import com.kyj.global.base.container.Container;
import com.kyj.global.base.controller.BaseController;
import com.kyj.global.base.rq.Rq;

import java.util.List;

public class ArticleController implements BaseController {
  private BoardService boardService;
  private MemberService memberService;
  private ArticleService articleService;


  public ArticleController() {
      articleService = Container.articleService;
      memberService = Container.memberService;
      boardService = Container.boardService;

  }

  @Override
  public void doAction(Rq rq) {
    switch (rq.getUrlPathUserAction()){
      case "write" -> doWrite(rq);
      case "detail" -> showDetail(rq);
      case "list" -> showList(rq);
      case "modify" -> doModify(rq);
      case "delete" -> doDelete(rq);
    }
  }



  public void doWrite(Rq rq) {
    int id = rq.getUrlPathVariable();

    if(id ==0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    Board board = boardService.findByBoardId(id);

    if(board == null) {
      System.out.println("해당 게시판은 존재하지 않습니다.");
      return;
    }

    System.out.println("== 게시물 작성==");
    System.out.print("제목 :");
    String title = Container.sc.nextLine();

    System.out.print("내용 :");
    String content = Container.sc.nextLine();

    int memberId = rq.getLoginedMember().getId();
    String writerName = memberService.findById(memberId).getUsername();

    int boardId = board.getId();

    Article article = articleService.write(title, content, memberId, writerName, boardId);

    System.out.printf("%d번 게시물이 등록 되었습니다.\n", article.getId());
  }


  public void showDetail(Rq rq) {
    int id = rq.getUrlPathVariable();

    if(id ==0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    List<Article> articles = articleService.getArticles();
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }
    // 내가 입력한 id와 리스트 내부에 있는 게시물 객체의 id랑 일치한 게시물 객체만 필터링


    Article article = articleService.findById(id);


    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    System.out.printf("== %d번 게시물 상세보기 ==\n", article.getId());
    System.out.printf("번호 : %d\n", article.getId());
    System.out.printf("제목 : %s\n", article.getTitle());
    System.out.printf("내용 : %s\n", article.getContent());
    System.out.printf("작성자 : %s\n", article.getWriterName());
  }

  public void showList(Rq rq) {
    String q = rq.getParam("q","");
    String sortcode = rq.getParam("sortCode", "idDesc");
    List<Article> articles = articleService.getArticles(q, sortcode);

    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }

    System.out.println("== 게시물 리스트 ==");
    System.out.println("번호 | 제목 | 작성자");

    articles.forEach(
        article ->
            System.out.printf("%d | %s | %s\n", article.getId(), article.getTitle(), article.getWriterName())
    );

  }
  private void doModify(Rq rq) {
    int id = rq.getUrlPathVariable();

    if(id ==0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    List<Article> articles = articleService.getArticles();
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }
    // 내가 입력한 id와 리스트 내부에 있는 게시물 객체의 id랑 일치한 게시물 객체만 필터링

    Article article = articleService.findById(id);


    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Member member = rq.getLoginedMember();

    if(article.getMemberId() != member.getId()) {
      System.out.println("해당 게시물에 대한 접근이 불가능합니다.");
      return;
    }

    System.out.printf("== %d번 게시물 수정 ==\n", id);

    System.out.print("새 제목 : ");
    String title = Container.sc.nextLine();

    System.out.print("새 내용 : ");

    String content = Container.sc.nextLine();

    articleService.modify(id, title, content);

    System.out.printf("%d번 게시물을 수정했습니다.\n", id);
  }


  private void doDelete(Rq rq) {
    int id = rq.getUrlPathVariable();

    if(id ==0) {
      System.out.println("올바른 값을 입력해주세요.");
      return;
    }

    List<Article> articles = articleService.getArticles();
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다");
      return;
    }
    // 내가 입력한 id와 리스트 내부에 있는 게시물 객체의 id랑 일치한 게시물 객체만 필터링

    Article article = articleService.findById(id);


    if (article == null) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Member member = rq.getLoginedMember();

    if(article.getMemberId() != member.getId()) {
      System.out.println("해당 게시물에 대한 접근이 불가능합니다.");
      return;
    }

    articleService.delete(id);

    System.out.printf("%d번 게시물을 삭제했습니다.\n", id);
  }
}


