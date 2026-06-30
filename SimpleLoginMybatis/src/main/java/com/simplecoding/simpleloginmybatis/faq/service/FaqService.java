/**
 * 
 */
package com.simplecoding.simpleloginmybatis.faq.service;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.faq.mapper.FaqMapper;
import com.simplecoding.simpleloginmybatis.faq.vo.FaqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FaqService {

    private final  FaqMapper faqMapper;

	
	public List<?> selectFaqList(Criteria criteria) {
		return faqMapper.selectFaqList(criteria);
	}
	
	
	public int selectFaqListTotCnt(Criteria criteria) {
		return faqMapper.selectFaqListTotCnt(criteria);
	}
	
	
	public void insert(FaqVO faqVO) {
		faqMapper.insert(faqVO);
	}
	
	
	public FaqVO selectFaq(int fno) {
		FaqVO faqVO = faqMapper.selectFaq(fno);
		return faqVO;
	}

	
	public void update(FaqVO faqVO) {
		faqMapper.update(faqVO);
	}

	
	public void delete(FaqVO faqVO) {
		faqMapper.delete(faqVO);
	}
}








