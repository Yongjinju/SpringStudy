package com.encore.j0820.t3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest
{
	public static void main(String[] args)
	{
		//applicationContext.xml문서 읽기	

		ApplicationContext ctx 
			= new GenericXmlApplicationContext("com/encore/j0820/t3/applicationContext.xml");
		
		//XML 문서에 정의 Bean 가져오기 = ctx.getBean("정의된 id명")
		MessageBean msg = (MessageBean)ctx.getBean("msgBean");
		msg.sayHello("딩딩딩");
	}
}