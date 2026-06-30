package com.simplecoding.simpleloginmybatis.dept.controller;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.dept.service.DeptService;
import com.simplecoding.simpleloginmybatis.dept.vo.DeptVO;
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
public class DeptController {

    private final DeptService deptService;
	
	@GetMapping("/dept")
	public String selectDeptList(
			@ModelAttribute Criteria criteria,
			Model model) {
		criteria.calculateOffset(criteria.getPage());       // Offset 자동 계산
		
		List<?> depts = deptService.selectDeptList(criteria);
		log.info("depts : "+depts);
		model.addAttribute("depts", depts);
		
		int totCnt = deptService.selectDeptListTotCnt(criteria);
        criteria.calculateTotalPage(totCnt);

		log.info("totCnt : "+totCnt);
		model.addAttribute("criteria", criteria);
		
		return "dept/dept_all";
	}

//	추가 페이지 열기 함수
	@GetMapping("/dept/addition")
	public String createDeptView() {
		return "dept/add_dept";
	}

	@PostMapping("/dept/add")
	public String insert(@ModelAttribute DeptVO deptVO) {
		
		log.info("테스트 " + deptVO);
		deptService.insert(deptVO);
		
		return "redirect:/dept";
	}
	
	@GetMapping("/dept/edition")
	public String updateDeptView(@RequestParam int dno, Model model) 
			      {
		DeptVO deptVO = deptService.selectDept(dno);
		model.addAttribute("deptVO", deptVO);
		return "dept/update_dept";
	}
	
	@PostMapping("/dept/edit")
	public String update(@RequestParam int dno,
							@ModelAttribute DeptVO deptVO
			) {
		deptService.update(deptVO);
		return "redirect:/dept";
	}
	
	@PostMapping("/dept/delete")
	public String delete(@ModelAttribute DeptVO deptVO)
	{
        deptService.delete(deptVO);
		return "redirect:/dept";
	}
}






