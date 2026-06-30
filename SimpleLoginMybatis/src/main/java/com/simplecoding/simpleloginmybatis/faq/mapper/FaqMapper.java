/**
 * 
 */
package com.simplecoding.simpleloginmybatis.faq.mapper;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.faq.vo.FaqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author TaeGyung
 *
 */
@Mapper
public interface FaqMapper {
	List<?> selectFaqList(Criteria searchVO);   // 전체 조회
	int selectFaqListTotCnt(Criteria searchVO); // 개수 세기
	int insert(FaqVO faqVO);                   // insert 함수
	FaqVO selectFaq(int dno);                  // 상세조회 함수
	int update(FaqVO faqVO);                   // update 함수
	int delete(FaqVO faqVO);                   // delete 함수
}