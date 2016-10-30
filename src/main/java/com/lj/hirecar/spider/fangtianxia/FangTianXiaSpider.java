package com.lj.hirecar.spider.fangtianxia;

import java.util.List;

import net.minidev.json.JSONUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class FangTianXiaSpider {

	public void beginWork(){
		Spider.create(new MyPageProcessor())
		.addUrl("http://esf.gz.fang.com/")
		.thread(1)
		.run();
	}
	
	class MyPageProcessor implements PageProcessor{

		private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
		
		@Override
		public void process(Page page) {
			//System.out.println(page.getHtml());
			List<String> result = page.getHtml().$("//div[@class='houseList']").all();
			System.out.println(result);
		}

		@Override
		public Site getSite() {
			// TODO Auto-generated method stub
			return site;
		}
		
	}
}
