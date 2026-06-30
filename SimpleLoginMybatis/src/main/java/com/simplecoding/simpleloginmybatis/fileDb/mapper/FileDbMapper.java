package com.simplecoding.simpleloginmybatis.fileDb.mapper;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.fileDb.vo.FileDbVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDbMapper {
	List<?> selectFileDbList(Criteria searchVO);
	int selectFileDbListTotCnt(Criteria searchVO); 
	int insert(FileDbVO fileDbVO);
	FileDbVO selectFileDb(String  uuid);           
	int delete(String uuid);                       
}