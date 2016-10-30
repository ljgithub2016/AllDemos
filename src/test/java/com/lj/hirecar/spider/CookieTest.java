package com.lj.hirecar.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CookieTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\1.txt");
		try(BufferedReader buffer = new BufferedReader(new FileReader(file))){
			String temp = null;
			while((temp=buffer.readLine()) != null){
				String[] array = temp.trim().split("=");
				String name = array[0].trim();
				String value = array[1].trim();
				value = value.substring(0,value.length()-1);
				//.addCookie("", "")
				String str = ".addCookie(\"" +name+"\",\""+value+"\")";
				System.out.println(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
