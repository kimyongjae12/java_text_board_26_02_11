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

  static {
    lastId = 0;
  }

  public Member(String username, String password, String name) {
    this(++lastId, username, password, name);
  }
}