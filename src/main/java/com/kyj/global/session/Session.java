package com.kyj.global.session;

import java.util.HashMap;
import java.util.Map;

public class Session {
  private Map<String, Object> sessionStorage;

  public Session() {
    sessionStorage = new HashMap<>();
  }

  // 생성, 조회, 삭제, 세션 존재여부
  public void setAttribute(String key, Object value) {
    sessionStorage.put(key,value);
  }
  public Object getAttribute(String key){
    return sessionStorage.get(key);
  }
  public void removeAttribute(String key){
    sessionStorage.remove(key);
  }
  public boolean hasAttribute(String key){
    return sessionStorage.containsKey(key);
  }

}
