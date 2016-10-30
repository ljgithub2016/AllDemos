package com.lj.hirecar.spider;

import com.lj.hirecar.spider.bdFilm.BDFilmSpider;

import junit.framework.TestCase;

public class BDFilmTest extends TestCase{

	public void testBD(){
		new BDFilmSpider().beginWork();
	}
	
}
