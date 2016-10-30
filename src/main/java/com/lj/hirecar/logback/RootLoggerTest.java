package com.lj.hirecar.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootLoggerTest {

	private static Logger logger = LoggerFactory.getLogger(RootLoggerTest.class);
	
	public static void main(String[] args) {
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		
	}
}
