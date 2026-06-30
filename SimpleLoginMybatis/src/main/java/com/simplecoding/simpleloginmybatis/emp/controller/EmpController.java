package com.simplecoding.simpleloginmybatis.emp.controller;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.emp.service.EmpService;
import com.simplecoding.simpleloginmybatis.emp.vo.EmpVO;
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
public class EmpController {

    private final  EmpService empService;
	
	@GetMapping("/emp")
	public String selectEmpList(@ModelAttribute Criteria criteria,
			Model model
			) {
        criteria.calculateOffset(criteria.getPage());       // Offset 자동 계산
		List<?> emps = empService.selectEmpList(criteria); 
		model.addAttribute("emps", emps);
		
		int totCnt = empService.selectEmpListTotCnt(criteria);
        criteria.calculateTotalPage(totCnt);
		model.addAttribute("criteria", criteria);
		
		return "emp/emp_all";
	}
	
	@GetMapping("/emp/addition")
	public String createEmpView() {
		return "emp/add_emp";
	}
	
	@PostMapping("/emp/add")
	public String insert(@ModelAttribute EmpVO empVO) {
		empService.insert(empVO);
		
		return "redirect:/emp";
	}
	

	@GetMapping("/emp/edition")
	public String updateEmpView(@RequestParam int eno, Model model) {
		EmpVO empVO = empService.selectEmp(eno);
		model.addAttribute("empVO", empVO);
		log.info(empVO);
		return "emp/update_emp";
	}
	
	@PostMapping("/emp/edit")
	public String update(@RequestParam int eno,
							@ModelAttribute EmpVO empVO
			) {
		empService.update(empVO);
		return "redirect:/emp"; 
	}
	
	@PostMapping("/emp/delete")
	public String delete(@ModelAttribute EmpVO empVO) {
        empService.delete(empVO);
		return "redirect:/emp"; 
	}
}









