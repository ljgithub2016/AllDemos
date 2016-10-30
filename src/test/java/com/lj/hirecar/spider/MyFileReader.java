package com.lj.hirecar.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\11.txt");
		
		try(BufferedReader buffer = new BufferedReader(new FileReader(file))){
			String temp = null;
			while((temp=buffer.readLine()) != null){
				System.out.print(temp.trim()+"主,");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
