package com.study.basic1.hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Temp1 {


	
	public static void main(String[] args) {
		
		try {
			new Temp1().sample2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sample1() throws IOException{
		File euc = new File("C:\\Users\\준영\\Documents\\temp\\euckr.txt");
		File utf = new File("C:\\Users\\준영\\Documents\\temp\\utf8.txt");
		
		FileInputStream fis = new FileInputStream(euc);
		InputStreamReader isr = new InputStreamReader(fis,"euc-kr");
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer(1024);
		String temp = "";
		while  ( (temp =  br.readLine() ) != null){
			sb.append(temp);
		}
		
		
		String lastText = sb.toString();

		System.out.println(lastText);
		
		// euc-kr 파일
		// euc-kr 로 읽으나, utf-8 로 읽으나, 바이트로 찍으면 결과는 항상 `[B@659e0bfd` 이다.

		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\준영\\Documents\\temp\\utf8-broken.txt"));
	
		OutputStreamWriter osw = new OutputStreamWriter(fos, "euc-kr");

		BufferedWriter bw = new BufferedWriter(osw);

		osw.write(lastText);
		osw.flush();
		osw.close();
	}
	
	public void sample2() throws IOException{
		
		File euc = new File("C:\\Users\\준영\\Documents\\temp\\euckr.txt");
		FileInputStream fis = new FileInputStream(euc);
		InputStreamReader isr = new InputStreamReader(fis,"euc-kr");
		BufferedReader br = new BufferedReader(isr,1024);
		
		StringBuffer sb = new StringBuffer();
		String temp = "";
		while( (temp = br.readLine()) != null){
			sb.append(temp);
		}
		String complateText = sb.toString();
		
		System.out.println("최초의 문자열 : "+complateText);

		String utf8 = new String (complateText.getBytes("euc-kr"),"utf-8" );	// euc-kr 문자열을 읽어서, utf-8 문자열로 생성
		System.out.println("utf-8 로 변환 한 문자열 : "+utf8);
		
		
		String euckr = new String(utf8.getBytes("utf-8"),"euc-kr");	// utf-8 문자열을 읽어서, euc-kr 로 생성
		System.out.println("euc-kr 로 변환 한 문자열"+euckr);
		
	}
	
	
	
	
}
