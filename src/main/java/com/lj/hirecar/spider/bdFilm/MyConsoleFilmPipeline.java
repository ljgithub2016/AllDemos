package com.lj.hirecar.spider.bdFilm;

import java.util.Iterator;
import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyConsoleFilmPipeline implements Pipeline{

	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String,Object> result = resultItems.getAll();
		Iterator<String> iterator =  result.keySet().iterator();
		while(iterator.hasNext()){
			String name = iterator.next();
			String link = result.get(name).toString();
			System.out.println("----" + name + "\t" + link);
		}
		
		
	}

}
