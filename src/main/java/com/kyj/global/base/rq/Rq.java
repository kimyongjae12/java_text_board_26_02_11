package com.kyj.global.base.rq;

import com.kyj.domain.member.member.dto.Member;
import com.kyj.global.base.container.Container;
import com.kyj.global.session.Session;
import com.kyj.global.util.Ut;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class Rq {
  @Getter
  public String url;
  @Getter
  public Map<String, String> params;
  @Getter
  public String urlPath;


  @Getter
  @Setter
  public String urlPathUserType;

  @Getter
  @Setter
  public String urlPathControllerName;

  @Getter
  @Setter
  public String urlPathUserAction;

  public Session session;

  public String loginedMember = "loginedMember";

  public Rq() {
    session = Container.session;
  }
  public void setCommand(String url) {
    this.url = url;
    this.params = Ut.getParamFromUrl(url);
    this.urlPath = Ut.getPathFromUrl(url);
  }

  public String getActionPath() {
    String[] urlBits = urlPath.trim().split("/");

    urlPathUserType = urlBits[1];
    urlPathControllerName = urlBits[2];
    urlPathUserAction = urlBits[3];

    return "/%s/%s/%s".formatted(urlPathUserType, urlPathControllerName, urlPathUserAction);

  }

  public int getUrlPathVariable() {
    String[] urlBits = urlPath.trim().split("/");
    int id = 0;
    try {
      id = Integer.parseInt(urlBits[4]);
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      return id;
    }
    return id;
  }

  // 로그인 여부 확인
  public boolean isLogined() {
    return hasAttr(loginedMember);
  }
  // 로그아웃 여부 확인
  public boolean isLogout() {
    return !isLogined();
  }

  public void login(Object data) {
    setAttr(loginedMember, data);
  }

  public void logout(){
    removeAttr(loginedMember);
  }


  public void setAttr(String key, Object value) {
    session.setAttribute(key, value);
  }

  public Object getAttr(String key) {
    return session.getAttribute(key);
  }

  public void removeAttr(String key) {
    session.removeAttribute(key);
  }

  public boolean hasAttr(String key) {
    return session.hasAttribute(key);
  }

  public Member getLoginedMember() {
    return (Member) getAttr(loginedMember);
  }
}
