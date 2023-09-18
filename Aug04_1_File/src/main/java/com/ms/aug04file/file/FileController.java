package com.ms.aug04file.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileController {
	
	@Autowired
	private FileDAO fDAO;
	
	@RequestMapping("/file.upload")
	public String getfile(
			@RequestParam("photoo") MultipartFile mpf,
			@RequestParam("etccc") MultipartFile[] mpf2,
			HttpServletRequest request,MyFile mf) {
		fDAO.fileupload(mpf,mpf2,request, mf);
		return "output";
	}
	
	
	//주소로 요청하면 파일이 나오게
	//src="/photo/aa.png"
	@RequestMapping("/photo/{n}")
	public @ResponseBody Resource getPhoto(@PathVariable("n")String name) {
		return fDAO.getPhoto(name);
	}
	
	@RequestMapping("/download/{n}")
	public ResponseEntity<Resource> 
	getFile(@PathVariable("n")String name) {
		return fDAO.getEtc(name);
	}
	
	
	
}
