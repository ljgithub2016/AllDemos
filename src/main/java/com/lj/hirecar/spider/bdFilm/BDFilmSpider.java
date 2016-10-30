package com.lj.hirecar.spider.bdFilm;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
/**
 * 爬出百度云链接
 * @author Administrator
 *
 */
public class BDFilmSpider {

	public static void main(String[] args) {
		new BDFilmSpider().beginWork();
	}
	
	public void beginWork(){
		Spider.create(new MyPageProccessor())
			.addUrl("http://www.bd-film.com/zx/index.htm") //设置需要爬的网站
			//.addUrl("http://www.bd-film.com/zx/22641.htm") //
			.thread(4)
			.addPipeline(new MyConsoleFilmPipeline())
			.addPipeline(new MyFileFilmPipline())
			.start();
	}
	
	public static int maxCount = 1000;
	public static int current = 0;
	
	class MyPageProccessor implements PageProcessor{
		Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

		@Override
		public void process(Page page) {
			current++;
			if(current > maxCount){
				return;
			}
			boolean isListPage = false;
			List<String> nlist = page.getHtml().$("div .pagination li").links().all();
			if(nlist != null && nlist.size() > 0){
				isListPage = true;
			}
			Selectable listSelect = page.getHtml().$("table.shadow-frame a[title]");
			if(isListPage){ //列表
				List<Selectable> nodes = listSelect.nodes();
				for(Selectable node : nodes){
					String link = node.xpath("//a/@href").toString();
					page.addTargetRequest(link);
				}
			}else{ //详情 
				String itemTitle = "";
				String itemLink = "";
				Selectable itemTitleSelect = page.getHtml().$("div.shadow-frame h3").xpath("//h3/text()"); //爬出标题文本
				if(itemTitleSelect != null){ //详细内容 标题
					itemTitle = itemTitleSelect.get();
					Selectable itemLinkSelect = page.getHtml().$("div.span12.bs-docs-download a").xpath("//a").regex(".+百度.+"); //百度云链接
					//System.out.println(itemLinkSelect);
					String baiduhref = "";
					String baidupwd = "";
					Pattern pattern = Pattern.compile("[a-zA-z]+://[^\\s]*");
					Matcher matcher =  pattern.matcher(itemLinkSelect.toString());
					if(matcher.find()){
						baiduhref = matcher.group(0);
						baiduhref = baiduhref.substring(0, baiduhref.length()-2);
					}
					pattern = Pattern.compile("百.+<");
					matcher = pattern.matcher(itemLinkSelect.toString());
					if(matcher.find()){
						baidupwd = matcher.group(0);
						baidupwd = baidupwd.substring(0, baidupwd.length()-1);
					}
					
					itemLink = baiduhref + "\t" + baidupwd;
					System.out.println(itemTitle);
					System.out.println(itemLink);
					
					page.putField(itemTitle, itemLink);
					return;
				}
				
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
