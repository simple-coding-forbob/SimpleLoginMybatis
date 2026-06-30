package com.simplecoding.simpleloginmybatis.faq.controller;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.faq.service.FaqService;
import com.simplecoding.simpleloginmybatis.faq.vo.FaqVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
public class FaqController {

    private final  FaqService faqService;
	
	@GetMapping("/faq")
	public String selectFaqList(
			@ModelAttribute Criteria criteria,
			Model model) {
        criteria.calculateOffset(criteria.getPage());       // Offset 자동 계산
		
		List<?> faqs = faqService.selectFaqList(criteria);
		model.addAttribute("faqs", faqs);
		int totCnt = faqService.selectFaqListTotCnt(criteria);
        criteria.calculateTotalPage(totCnt);
        model.addAttribute("criteria", criteria);
		
		return "faq/faq_all";
	}

//	추가 페이지 열기 함수
	@GetMapping("/faq/addition")
	public String createFaqView() {
		return "faq/add_faq";
	}

	@PostMapping("/faq/add")
	public String insert(@ModelAttribute FaqVO faqVO) {
		
		log.info("테스트 " + faqVO);
		faqService.insert(faqVO);
		
		return "redirect:/faq";
	}
	
	@GetMapping("/faq/edition")
	public String updateFaqView(@RequestParam int fno, Model model) 
			      {
		FaqVO faqVO = faqService.selectFaq(fno);
		model.addAttribute("faqVO", faqVO);
		return "faq/update_faq";
	}
	
	@PostMapping("/faq/edit")
	public String update(@RequestParam int fno,
							@ModelAttribute FaqVO faqVO
			) {
		faqService.update(faqVO);
		return "redirect:/faq"; 
	}
	
	@PostMapping("/faq/delete")
	public String delete(@ModelAttribute FaqVO faqVO)
	{
        faqService.delete(faqVO);
		return "redirect:/faq"; 
	}
}






