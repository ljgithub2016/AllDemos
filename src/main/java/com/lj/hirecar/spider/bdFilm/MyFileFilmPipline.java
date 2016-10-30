package com.lj.hirecar.spider.bdFilm;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyFileFilmPipline implements Pipeline{

	Logger logger = LoggerFactory.getLogger(MyFileFilmPipline.class);
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String,Object> result = resultItems.getAll();
		Iterator<String> keys =  result.keySet().iterator();
		while(keys.hasNext()){
			String name=keys.next();
			String link = result.get(name).toString();
			logger.info("\r\n" +name +"\t" + link);
		}
		
	}

	
}
