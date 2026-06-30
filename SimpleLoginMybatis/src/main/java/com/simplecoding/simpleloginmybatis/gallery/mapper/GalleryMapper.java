package com.simplecoding.simpleloginmybatis.gallery.mapper;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.gallery.vo.GalleryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {
	List<?> selectGalleryList(Criteria searchVO);
	int selectGalleryListTotCnt(Criteria searchVO); 
	int insert(GalleryVO galleryVO);
	GalleryVO selectGallery(String  uuid);          
	int delete(String uuid);                       
}





