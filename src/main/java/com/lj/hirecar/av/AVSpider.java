package com.lj.hirecar.av;

import org.apache.http.client.HttpClient;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;

import com.lj.hirecar.spider.bdFilm.MyConsoleFilmPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class AVSpider {

	public static void main(String[] args) {
		new AVSpider().beginWork();
		
	}
	
	public void beginWork(){
		Spider.create(new MyPageProcessor())
			.addUrl("http://seba360.com/forum-216-1.html")
			.thread(1)
			.run();
	}
	
	class MyPageProcessor implements PageProcessor{
		Site site = Site.me().setSleepTime(1000).setRetryTimes(5)
				.setRetrySleepTime(100);

		@Override
		public void process(Page page) {
			System.out.println(page.getHtml());
			
		}

		@Override
		public Site getSite() {
			// TODO Auto-generated method stub
			return site;
		}
		
		
	}
}
