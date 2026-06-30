/**
 * 
 */
package com.simplecoding.simpleloginmybatis.dept.mapper;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.dept.vo.DeptVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
	List<?> selectDeptList(Criteria criteria);   // 전체 조회
	int selectDeptListTotCnt(Criteria criteria); // 개수 세기
	int insert(DeptVO deptVO);                   // insert 함수
	DeptVO selectDept(int dno);                  // 상세조회 함수
	int update(DeptVO deptVO);                   // update 함수
	int delete(DeptVO deptVO);                   // delete 함수
}
