package com.simplecoding.simpleloginmybatis.fileDb.service;


import com.simplecoding.simpleloginmybatis.common.CommonUtil;
import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.fileDb.mapper.FileDbMapper;
import com.simplecoding.simpleloginmybatis.fileDb.vo.FileDbVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileDbService {

    private final FileDbMapper fileDbMapper;
    private final CommonUtil commonUtil;

    public List<?> selectFileDbList(Criteria criteria) {
        return fileDbMapper.selectFileDbList(criteria);
    }

    public int selectFileDbListTotCnt(Criteria criteria) {
        return fileDbMapper.selectFileDbListTotCnt(criteria);
    }

    public void insert(FileDbVO fileDbVO) throws Exception {
        String uuid = UUID.randomUUID().toString();                           // 1) UUID 만들기(기본키): 자바에서 중복안되게 만들어주는 글자(랜덤)
        fileDbVO.setUuid(uuid);
        if (fileDbVO.getFileData() != null) {
            String downloadURL = commonUtil.generateUrl("fileDb", uuid);  // 2) 업로드 파일이 있을때만 다운로드 URL 만들기
            fileDbVO.setFileUrl(downloadURL);
            commonUtil.saveFile(fileDbVO.getFileData(), uuid);                 // 3) 업로드 파일이 있을때만 파일 만들기
        }

        fileDbMapper.insert(fileDbVO);
    }

    public FileDbVO selectFileDb(String uuid) {
        return fileDbMapper.selectFileDb(uuid);
    }


    public void delete(String uuid) {
        commonUtil.deleteFile(uuid);                       // 1) 업로드 폴더에 파일 삭제하기
        fileDbMapper.delete(uuid);
    }
}

