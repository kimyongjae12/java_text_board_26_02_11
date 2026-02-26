import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QueryStringParsingTest {
  public static void main(String[] args) {
    String url = "/usr/article/list?page=1&code=title&q=제목1 입니까? 여기는.. &cale=dasd";
    String urlPath = Ut.getPathFromUrl(url);
    Map<String, String> params = Ut.getParamFromUrl(url);

  }
  class Ut {

    public static Map<String, String> getParamFromUrl(String url) {

      Map<String, String> params = new HashMap<>();
      String[] urlBits = url.split("\\?",2);

      if(urlBits.length==1) return params;
      
      String queryString = urlBits[1];

      String[] queryBits = queryString.split("&");

      for(String queryBit : queryBits){
        String[] queryBitBits = queryBit.split("=",2);

        String paramName = queryBitBits[0];
        String paramValue = queryBitBits[1];

        params.put(paramName, paramValue);
      }

      return params;
    }

    public static String getPathFromUrl(String url) {
      String[] urlBits = url.split("\\?",2);
      return urlBits[0];
    }
  }
    }
