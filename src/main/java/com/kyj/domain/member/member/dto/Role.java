package com.kyj.domain.member.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// enum : 상수 인스턴스
public enum Role {
  ROLE_USER("일반회원"),
  ROLE_ADMIN("관리자");

  private final String description;
}
