package com.yuan.applicationcontext.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("rawtypes")
public class PropertyGettedListener implements ApplicationListener {
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.getSource().toString());
	}
}