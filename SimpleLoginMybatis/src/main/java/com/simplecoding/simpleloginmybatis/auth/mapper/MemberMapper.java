package com.simplecoding.simpleloginmybatis.auth.mapper;


import com.simplecoding.simpleloginmybatis.auth.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<MemberVO> findByEmail(String email);
	
    void save(MemberVO memberVO);
}
