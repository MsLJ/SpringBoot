package com.ms.aug04file.file;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class FileDAO {
	@Value("${file.dir}")
	private String fileDir;
	@Value("${downloadfile.dir}")	
	private String filedownDir;

	
	//이미지,영상....
	public Resource getPhoto(String name) {
		try {
			return new UrlResource("file:" + fileDir + "/" + name);

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
	//다운받을려면
	public ResponseEntity<Resource> getEtc(String name) {
		try {
			UrlResource ur=new UrlResource("file:" + filedownDir + "/" + name);
			String header="attachment; filename=\""+URLEncoder.encode(name,"utf-8")+"\"";
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, header).body(ur);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}
	//어차피 똑같은 작업할꺼 여기에 하나 만들어놓기
	private String getFileName(MultipartFile mf) {
		String fileName = mf.getOriginalFilename();// 업로드한 파일 명
		String type = fileName.substring(fileName.lastIndexOf("."));// .png
		fileName = fileName.replace(type, "");// ㅋ ㅋ
		String uuid = UUID.randomUUID().toString();
		return fileName+"_"+uuid+type;
		
	}

	public void fileupload(MultipartFile mpf,MultipartFile[] mpf2, HttpServletRequest request, MyFile mf) {
		try {
			String fileName=getFileName(mpf);
			File f = new File(fileDir + "/" + fileName);

			// UUID:네트워크같은데서 중복안되는 id값 필요할때 쓰는
			// (Universally Unique Identifier)

			// 파일명 중복되면 그냥 덮어쓰기
			// 안덮어쓰려면 파일명을 다르게 해야
			// 그 대책은 없음 아마 뒤에
			// 토큰을 생성해서 그 날짜를 기입하는쪽으로 아니면 UUID쓰든지
			ArrayList<String>fileNames=new ArrayList<>();
			String fileName2 = null;// 업로드한 파일 명
			File f2 = new File(filedownDir + "/" + fileName2);
			for (MultipartFile mpff : mpf2) {
				fileName2=getFileName(mpff);
				f2=new File (filedownDir + "/" + fileName2);
				mpff.transferTo(f2);// 실제 업로드
				fileNames.add(fileName2);
			}
			mf.setEtc(fileNames);
			mpf.transferTo(f);// 실제 업로드
			mf.setPhoto(fileName);

			request.setAttribute("mf", mf);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
