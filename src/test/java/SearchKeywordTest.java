import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchKeywordTest {
  public static void main(String[] args) {
    List<Article> articles = new ArrayList<>();
    articles.add(new Article(1,"안녕하세요","반갑습니다."));
    articles.add(new Article(2,"제목ㅎㅎ","코딩을 마링야.."));
    articles.add(new Article(3,"자바 입니까?","반가워"));

    String q = "안녕";

    List<Article> filterdArticles = articles.stream()
        .filter(article -> article.getTitle().contains(q))
        .collect(Collectors.toList());
    System.out.println(filterdArticles);
  }
}


@AllArgsConstructor
@Getter
@ToString
class Article {
  int id;
  String title;
  String content;


}
