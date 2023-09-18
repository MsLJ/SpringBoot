package com.ms.rbk2.mp;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MyPhotoDAO {

	@Autowired
	private MyPhotoRepo mpr;
	@Value("${file.dir}")
	private String folder;

	private String makeFileName(MultipartFile mf) {
		String file =mf.getOriginalFilename();//a.png
		String type=file.substring(file.lastIndexOf("."));//.png
		String uuid=UUID.randomUUID().toString();//asdadlsw-asddsa-123123
		file=file.replace(type, "");//a
		return file+uuid+type;
	}
	
	public MyPhoto upload(MultipartFile mf, MyPhoto mp) {
		try {
			String file=makeFileName(mf);
			mf.transferTo(new File(folder+"/"+file));
			mp.setFile(file);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			mpr.save(mp);
			return mp;
		} catch (Exception e) {
			// DB문제
			e.printStackTrace();
			return null;
		}
		

	}

	public MyPhotos get() {
		try {
			
			return new MyPhotos(mpr.findAll());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
			public Resource getPhoto(String name) {
				try {
					//파일주는거
					return new UrlResource("file:"+folder+"/"+name);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}

}
