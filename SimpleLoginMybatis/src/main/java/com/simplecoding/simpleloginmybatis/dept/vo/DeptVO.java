/**
 * 
 */
package com.simplecoding.simpleloginmybatis.dept.vo;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class DeptVO extends Criteria {
	private int dno;           // 부서번호(기본키)
	private String dname;      // 부서명
	private String loc;        // 부서위치
}