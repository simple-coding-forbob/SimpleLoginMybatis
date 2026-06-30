/**
 * 
 */
package com.simplecoding.simpleloginmybatis.emp.controller;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.emp.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author simple-coding
 * AutoComplete
 */
@RequiredArgsConstructor
@Log4j2
@RestController
public class EmpAjaxController {
	@Autowired
	private final EmpService empService;

	@GetMapping("/api/emp")
	public List<?> selectEmpList(@ModelAttribute("searchVO") Criteria criteria) throws Exception  {
		List<?> list = empService.selectEmpList(criteria);
		
		return list;
	}
}
