package com.lj.hirecar.spider.youdao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 有道云爬虫
 * @author Administrator
 *
 */
public class MyYouDaoSpider {

	/**
	 * 爬虫入口
	 */
	public void beginWork(){
		String url = "https://note.youdao.com/web/#/file/794273BCD6144D3998ABA2D625C224D5/note/03A72FA352D54295A117F8A6EDB81BA4/";
		Spider.create(new MyPageProcessor()).addUrl(url)
			.thread(1)
			.run();
	}
	
	
	class MyPageProcessor  implements PageProcessor{

		private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
				.addCookie("OUTFOX_SEARCH_USER_ID","1785305938@113.119.135.243")
				.addCookie("YOUDAO_EAD_UUID","ae790a9f-cbce-420e-8169-12e4b06ae349")
				.addCookie("OUTFOX_SEARCH_USER_ID_NCOO","1522358558.7910964")
				.addCookie("__yadk_uid","Bf0hkjL2dtaz2XvMC8MPaFbnlsIxXBxs")
				.addCookie("Hm_lvt_30b679eb2c90c60ff8679ce4ca562fcc","1470372735")
				.addCookie("CNZZDATA1255095031","1476980077-1474426760-%7C1474426760")
				.addCookie("JSESSIONID","aaaSOtD3io14KbIVLhUDv")
				.addCookie("YNOTE_PERS","v2|urstoken||YNOTE||web||-1||1477272429159||58.62.53.232||xdliujia2008@163.com||eunHTuh4YA0QFOMJuRHz5Rpy6MQBRLPLRkfkMUWnMUY0eZ0fOEnfQB0qShLeBRfwFRlW6LQF64QK0kWRfUGhMQFR")
				.addCookie("YNOTE_SESS","v2|8Rr6S75RyBPzO4qZOfkf0lEkfUMRfUE0lGhHgL64YW0pFhMTL0LTK0guRHwu0MQZ0qzhMzlOLey0zWhM6BkLJu0zWkLOERfeLR")
				.addCookie("YNOTE_LOGIN","5||1477274369391")
				.addCookie("_ga","GA1.2.504302515.1464512971")
				.addCookie("Hm_lvt_4566b2fb63e326de8f2b8ceb1ec367f2","1477272357")
				.addCookie("Hm_lpvt_4566b2fb63e326de8f2b8ceb1ec367f2","1477275144")
				.addCookie("YNOTE_CSTK","ZFm65tR");
		
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
