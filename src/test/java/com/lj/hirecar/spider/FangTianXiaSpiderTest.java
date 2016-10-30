package com.lj.hirecar.spider;

import com.lj.hirecar.spider.fangtianxia.FangTianXiaSpider;

import junit.framework.TestCase;

public class FangTianXiaSpiderTest extends TestCase{

	public void testFangTianXia(){
		FangTianXiaSpider spider = new FangTianXiaSpider();
		spider.beginWork();
	}
}
