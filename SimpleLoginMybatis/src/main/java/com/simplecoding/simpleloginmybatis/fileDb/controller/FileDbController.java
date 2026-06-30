/**
 * 
 */
package com.simplecoding.simpleloginmybatis.fileDb.controller;


import com.simplecoding.simpleloginmybatis.common.CommonUtil;
import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.fileDb.service.FileDbService;
import com.simplecoding.simpleloginmybatis.fileDb.vo.FileDbVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
public class FileDbController {

    private final FileDbService fileDbService;
    private final CommonUtil commonUtil;

	@GetMapping("/fileDb")
	public String selectFileDbList(@ModelAttribute Criteria criteria, Model model) {

        criteria.calculateOffset(criteria.getPage());       // Offset 자동 계산

		List<?> fileDbs = fileDbService.selectFileDbList(criteria);
		model.addAttribute("fileDbs", fileDbs);
		
		int totCnt = fileDbService.selectFileDbListTotCnt(criteria);
        criteria.calculateTotalPage(totCnt);
        model.addAttribute("criteria", criteria);
		
		return "fileDb/fileDb_all";
	}

//	추가 페이지 열기 :
	@GetMapping("/fileDb/addition")
	public String createFileDbView() {
		return "fileDb/add_fileDb";
	}
	
	@PostMapping("/fileDb/add")
	public String insert(        @Valid @ModelAttribute FileDbVO fileDbVO,
                                 BindingResult result
			) throws Exception {
        commonUtil.checkBindingResult(result);
		fileDbService.insert(fileDbVO);
		return "redirect:/fileDb"; 
	}
	
	@GetMapping("/download/fileDb")
	@ResponseBody
	public ResponseEntity<byte[]> fileDownload(@RequestParam(defaultValue = "") String uuid) throws Exception {
		FileDbVO fileDbVO = fileDbService.selectFileDb(uuid);

        // 서버에 저장된 실제 파일 경로
        byte[] file= commonUtil.readFile(uuid);

        // ContentDisposition 사용 (브라우저 호환성 보장)
        ContentDisposition contentDisposition = ContentDisposition.attachment()
                .filename(fileDbVO.getUuid(), StandardCharsets.UTF_8) // 실제 업로드한 파일명
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString())
                .body(file);
	}
	
	@PostMapping("/fileDb/delete")
	public String delete(@RequestParam(defaultValue = "") String uuid) {
		log.info("테스트 : " + uuid);
		fileDbService.delete(uuid);
		return "redirect:/fileDb"; 
	}
}









