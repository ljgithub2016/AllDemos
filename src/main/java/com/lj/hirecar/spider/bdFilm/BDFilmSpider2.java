package com.lj.hirecar.spider.bdFilm;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePageModelPipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.pipeline.MultiPagePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
/**
 *  爬出列表链接
 * @author Administrator
 *
 */
public class BDFilmSpider2 {

	public void beginWork(){
		Spider.create(new MyPageProccessor())
			.addUrl("http://www.bd-film.com/zx/index.htm") //设置需要爬的网站
			.thread(4)
			//.addPipeline(new MyConsoleFilmPipeline())
			.addPipeline(new MyFileFilmPipline())
			.run();
	}
	
	public static int maxCount = 120;
	public static int current = 0;
	
	class MyPageProccessor implements PageProcessor{
		Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

		@Override
		public void process(Page page) {
			
			current ++;
			if(current >= maxCount){
				return;
			}
			Selectable select = page.getHtml().$("table.shadow-frame a[title]");
			List<Selectable> nodes = select.nodes();
			for(Selectable node : nodes){
				String link = node.xpath("//a/@href").toString();
				String title = node.xpath("//a/@title").toString();
				page.putField(title, link);
			}
			List<String> nextlist = page.getHtml().$("div .pagination li.active + li").links().all();
			if(nextlist == null || nextlist.size() ==0){
				return;
			}
			String nexthref = nextlist.get(0);
			System.out.println("================" + nexthref);
			page.addTargetRequest(nexthref); //设置下一次扫描的页面
		}

		@Override
		public Site getSite() {
			// TODO Auto-generated method stub
			return site;
		}
		
		
	}
	
	public static void writeToFile(String filePath){
		
	}
}
