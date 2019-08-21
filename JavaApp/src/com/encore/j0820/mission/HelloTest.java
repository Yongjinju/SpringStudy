package com.encore.j0820.mission;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx =
				new GenericXmlApplicationContext("com/encore/j0820/mission/applicationContext.xml");
	
		FileOutput fo = (FileOutput) ctx.getBean("fileOut");
		fo.output();		
	}
}
