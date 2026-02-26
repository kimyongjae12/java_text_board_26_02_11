import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QueryStringParsingTest {
  public static void main(String[] args) {
    String url = "/usr/article/list?page=1&code=title&q=제목1 입니까? 여기는.. &cale=dasd";

    Map<String, String> params = new HashMap<>();
    String[] urlBits = url.split("\\?",2);
    String queryString = urlBits[1];
    //System.out.println(Arrays.toString(urlBits));
//    System.out.println(queryString);

    String[] queryBits = queryString.split("&");
//    System.out.println(Arrays.toString(queryBits));

    for(String queryBit : queryBits){
      String[] queryBitBits = queryBit.split("=",2);
//      System.out.println(Arrays.toString(queryBitBits));

//      System.out.println(queryBitBits[0]);
//      System.out.println(queryBitBits[1]);
      String paramName = queryBitBits[0];
      String paramValue = queryBitBits[1];

      params.put(paramName, paramValue);
    }

    // System.out.println(params);
    System.out.println("== 원하는 쿼리 데이터 가져오기 ==");
    System.out.printf("page : %d\n", Integer.parseInt(params.get("page")));
    System.out.printf("code : %s\n", params.get("code"));
    System.out.printf("q : %s\n", params.get("q"));

  }
}
