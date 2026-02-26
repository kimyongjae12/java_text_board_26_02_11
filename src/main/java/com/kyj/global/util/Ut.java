package com.kyj.global.util;

import java.util.HashMap;
import java.util.Map;

public class Ut {

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
