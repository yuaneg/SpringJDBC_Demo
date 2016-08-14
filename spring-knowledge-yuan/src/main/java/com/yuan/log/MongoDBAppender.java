package com.yuan.log;

import java.net.UnknownHostException;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class MongoDBAppender extends UnsynchronizedAppenderBase<LoggingEvent> {	
	
	private MongoTemplate mongoTemplate;
	
	/**
	 * 往mongodb 数据库插入数据
	 */
	@Override
	protected void append(LoggingEvent eventObject) {
		BasicDBObject dbobject = new BasicDBObject();  
		dbobject.put("date", eventObject.getTimeStamp());
		dbobject.put("message", eventObject.getMessage());
		dbobject.put("level", eventObject.getLevel());
		dbobject.put("thread", eventObject.getThreadName());
		dbobject.put("loggerName", eventObject.getLoggerName());
		mongoTemplate.insert(dbobject, "spring");
	}
	
	
	/**
	 * 数据库连接
	 */
	@Override
	public void start() {
		try {
			Mongo mongo = new MongoClient();
			mongoTemplate = new MongoTemplate(mongo, "test");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		super.start();
	}

	/**
	 * 断开连接
	 */
	@Override
	public void stop() {
		mongoTemplate = null;
		super.stop();
	}
	

}
