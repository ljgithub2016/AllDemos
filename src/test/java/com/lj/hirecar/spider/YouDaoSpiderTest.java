package com.lj.hirecar.spider;

import com.lj.hirecar.spider.youdao.MyYouDaoSpider;

import junit.framework.TestCase;

public class YouDaoSpiderTest extends TestCase{
	
	public void testSpider(){
		MyYouDaoSpider spider = new MyYouDaoSpider();
		spider.beginWork();
	}

}
