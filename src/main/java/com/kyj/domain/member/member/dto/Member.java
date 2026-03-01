package com.kyj.domain.member.member.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // public Article(int id, String title, String content))
@NoArgsConstructor  // public Article() {}
@ToString
public class Member {
  private static int lastId;
  private int id;
  private String username;
  private String password;
  private String name;
  private Role role;

  static {
    lastId = 0;
  }
  // 일반 회원 생성자
  public Member(String username, String password, String name) {
    this(++lastId, username, password, name, Role.ROLE_USER);
  }
  // 관리자 포함 생성자
  public Member(String username, String password, String name, Role role) {
    this(++lastId, username, password, name, role);
  }

  public boolean isAdmin() {
    return this.role == Role.ROLE_ADMIN;
  }

  public boolean isUser() {
    return !isAdmin();
  }

  public String getType() {
    return isAdmin() ? "관리자" : "일반회원";
  }

}