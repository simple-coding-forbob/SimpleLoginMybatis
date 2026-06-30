/**
 * 
 */
package com.simplecoding.simpleloginmybatis.gallery.controller;


import com.simplecoding.simpleloginmybatis.common.CommonUtil;
import com.simplecoding.simpleloginmybatis.common.Criteria;
import com.simplecoding.simpleloginmybatis.gallery.service.GalleryService;
import com.simplecoding.simpleloginmybatis.gallery.vo.GalleryVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@Controller
public class GalleryController {

    private final GalleryService galleryService;
    private final  CommonUtil commonUtil;

	@GetMapping("/gallery")
	public String selectGalleryList(@ModelAttribute Criteria criteria, Model model) {

        criteria.calculateOffset(criteria.getPage());       // Offset 자동 계산

		List<?> gallerys = galleryService.selectGalleryList(criteria);
		model.addAttribute("gallerys", gallerys);
		
		int totCnt = galleryService.selectGalleryListTotCnt(criteria);
        criteria.calculateTotalPage(totCnt);
        model.addAttribute("criteria", criteria);
		
		return "gallery/gallery_all";
	}
	
	@GetMapping("/gallery/addition")
	public String createGalleryView() {
		return "gallery/add_gallery";
	}
	
	@PostMapping("/gallery/add")
	public String insert(       @Valid @ModelAttribute GalleryVO galleryVO,
                                BindingResult result
			) throws Exception {
        commonUtil.checkBindingResult(result);
		galleryService.insert(galleryVO);
		return "redirect:/gallery"; 
	}
	
	@GetMapping("/download/gallery")
	@ResponseBody
	public ResponseEntity<byte[]> fileDownload(@RequestParam(defaultValue = "") String uuid) throws Exception {
        GalleryVO galleryVO = galleryService.selectGallery(uuid);

        // 서버에 저장된 실제 파일 경로
        byte[] file= commonUtil.readFile(uuid);

        // ContentDisposition 사용 (브라우저 호환성 보장)
        ContentDisposition contentDisposition = ContentDisposition.attachment()
                .filename(galleryVO.getUuid(), StandardCharsets.UTF_8) // 실제 업로드한 파일명
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString())
                .body(file);
	}
	
	@PostMapping("/gallery/delete")
	public String delete(@RequestParam(defaultValue = "") String uuid) {
		galleryService.delete(uuid);
		return "redirect:/gallery";
	}
}
