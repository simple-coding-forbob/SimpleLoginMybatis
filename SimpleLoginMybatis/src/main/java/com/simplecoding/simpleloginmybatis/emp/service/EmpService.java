/**
 * 
 */
package com.simplecoding.simpleloginmybatis.emp.service;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.emp.mapper.EmpMapper;
import com.simplecoding.simpleloginmybatis.emp.vo.EmpVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpMapper empMapper;
	
	
	public List<?> selectEmpList(Criteria searchVO) {
		return empMapper.selectEmpList(searchVO);
	}

	
	public int selectEmpListTotCnt(Criteria searchVO) {
		return empMapper.selectEmpListTotCnt(searchVO);
	}
	
	
	public void insert(EmpVO empVO) {
		empMapper.insert(empVO);
	}
	
	
	public EmpVO selectEmp(int eno) {
		EmpVO empVO = empMapper.selectEmp(eno);
		return empVO;
	}
	
	
	public void update(EmpVO empVO) {
		empMapper.update(empVO);
	}
	
	
	public void delete(EmpVO empVO) {
		empMapper.delete(empVO);
	}
}






