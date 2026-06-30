package com.simplecoding.simpleloginmybatis.auth.controller;

import java.util.UUID;

import com.simplecoding.simpleloginmybatis.auth.service.MemberService;
import com.simplecoding.simpleloginmybatis.auth.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    
//  로그인 화면
    @GetMapping("/login")
    public String loginView() {
    	
		return "auth/login";
	}
    
    /**
     * 사용자로 부터 아이디, 패스워드를 입력받아 인증 성공이면 세션 객체에 계정정보를 담고 사원정보리스트 페이지로 포워딩한다. 인증에
     * 실패하면 로그인 페이지로 다시 리턴한다.
     */
    @PostMapping("/loginProcess")
    public String login(HttpSession session, @ModelAttribute MemberVO loginVO) throws Exception {
    	
        // TODO [Step 4-1-01] LoginService의 authenticate메소드를 이용하여 
    	// 로긴여부 체크 Member 객체를 리턴 받는다.
    	MemberVO memberVO = memberService.login(loginVO);
    	
        // memberVO 세션을 만듭니다.
    	session.setAttribute("memberVO", memberVO);
        // CSRF 토큰 생성
        session.setAttribute("CSRF_TOKEN", UUID.randomUUID().toString());
        
        return "redirect:/"; // 홈(첫페이지)로 이동
    	
    } 
    
//  회원 가입 화면 
    @GetMapping("/register")
    public String registerView() {
		return "auth/register";
	}
    
//  가입 버튼 클릭시 실행될 함수
    @PostMapping("/register/addition")
    public String register(Model model, @ModelAttribute MemberVO memberVO) throws Exception {
    	
//    	서비스의 insert 함수 실행
    	memberService.save(memberVO);
    	
    	model.addAttribute("msg", "회원 가입을 성공했습니다.");
        return "auth/register";
    	
    } 
    
//  로그아웃 화면
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
    	httpSession.invalidate();                // 무효화
		return "redirect:/login";                // 로그인 페이지로 강제이동
	}
}
