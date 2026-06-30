package com.simplecoding.simpleloginmybatis.emp.vo;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class EmpVO extends Criteria {
	private int eno;            // 사원번호(기본키)
	private String ename;       // 사원명
	private String job;         // 직위
	private int manager;        // 관리자 사원번호
	private String hiredate;    // 입사일
	private int salary;         // 급여
	private int commission;     // 상여금
	private int dno;            // 부서번호
}
