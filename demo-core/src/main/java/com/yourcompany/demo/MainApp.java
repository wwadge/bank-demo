/**
 * 
 */
package com.yourcompany.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wwadge
 *
 */
public class MainApp {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		
		new ClassPathXmlApplicationContext("beans.demo.core.xml");

		while(true){
			Thread.sleep(Long.MAX_VALUE);
		}
	}
}

