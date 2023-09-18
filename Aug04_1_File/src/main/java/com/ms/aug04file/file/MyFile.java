package com.ms.aug04file.file;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyFile {
	private String title;
	private String photo;
	private ArrayList<String>etc;
}
