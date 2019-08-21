package com.encore.j0820.mission;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputImpl implements FileOutput
{
	private String greeting;
	private String name;
	
	public FileOutputImpl()
	{
		System.out.println("기본생성자");
	}
	
	public FileOutputImpl(String st)
	{
		String str = st;
		this.name = str;
		System.out.println("st 들어옴, " + st);
	}
	
	public void setGreeting(String greeting)
	{
		
		this.greeting = greeting;
	}

	@Override
	public void output()
	{
		String str = greeting + ", " + name + "!!!";
		System.out.println(str);
		File file = new File("C:\\Users\\Playdata\\hello.txt");
		
		try
		{
			FileWriter fw = new FileWriter(file);
			fw.write(str);
			fw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
