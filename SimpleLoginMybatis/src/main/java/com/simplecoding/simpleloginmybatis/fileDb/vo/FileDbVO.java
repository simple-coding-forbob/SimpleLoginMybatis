package com.simplecoding.simpleloginmybatis.fileDb.vo;


import com.simplecoding.simpleloginmybatis.common.Criteria;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDbVO extends Criteria {
	private String uuid;            // 기본키
    @NotBlank
	private String fileTitle;       // 제목
    @NotBlank
	private String fileContent;     // 내용
	private MultipartFile fileData;    // 내부적 사용(이미지파일)
	private String fileUrl="https://placehold.co/600x400";     // 서버에 저장된 파일 URL
}



