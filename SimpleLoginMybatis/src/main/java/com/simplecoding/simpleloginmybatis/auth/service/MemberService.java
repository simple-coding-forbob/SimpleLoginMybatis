package com.simplecoding.simpleloginmybatis.auth.service;


import com.simplecoding.simpleloginmybatis.auth.dto.MypageDto;
import com.simplecoding.simpleloginmybatis.auth.mapper.MemberMapper;
import com.simplecoding.simpleloginmybatis.auth.vo.MemberVO;
import com.simplecoding.simpleloginmybatis.common.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final CommonUtil commonUtil;

// email 로 회원 찾기
    public MemberVO findByEmail(String email) {
        //        JPA 상세조회 함수 실행
        MemberVO memberVO = memberMapper.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(commonUtil.getMessage("errors.not.found")));

        return memberVO;
    }

    public MemberVO login(MemberVO loginVO) {

//	사용자 있는지 DB 조회
        MemberVO memberVO = findByEmail(loginVO.getEmail());

//	회원이 있으면 암호 체크
        if (!BCrypt.checkpw(loginVO.getPassword(), memberVO.getPassword()))
            throw new RuntimeException(commonUtil.getMessage("errors.login"));

        return memberVO;
    }

    public void save(MemberVO registerVO) {
//		사용자 있는지 DB 조회 
        Optional<MemberVO> optional = memberMapper.findByEmail(registerVO.getEmail());
        if(optional.isPresent()){
            throw new RuntimeException(commonUtil.getMessage("errors.register"));
        }
//    	TODO: 사용자 없으면 암호화 Bcryt(salting 난수화 알고리즘 적용: 레인보우테이블 해킹공격 방어), 암호는 해싱(암호화)해서 DB 에 저장함.
        String hashedPassword = BCrypt.hashpw(registerVO.getPassword(), BCrypt.gensalt());
        registerVO.setPassword(hashedPassword);

        memberMapper.save(registerVO);
    }

    // MypageDto 로 변경하기(암호 제외)
    public MypageDto getMypage(String email) {
        //        JPA 상세조회 함수 실행
        MemberVO memberVO = findByEmail(email);

        MypageDto mypageVO = new MypageDto();
        mypageVO.setName(memberVO.getName());
        mypageVO.setEmail(memberVO.getEmail());

        return mypageVO;
    }


}
 