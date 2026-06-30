package com.simplecoding.simpleloginmybatis.auth.vo;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO extends Criteria {
    private String email;    // 기본키, 로그인 id
    private String password; // 암호
    private String name;     // 유저명
    private Long eno;        // 사번
}
