package com.encore.j0820.di;

public class MessageBeanImpl implements MessageBean
{
	private String greeting;
	private String name;
	
	public MessageBeanImpl()
	{
		System.out.println("MessageBeanImpl 기본 생성자");
	}
	
	public MessageBeanImpl(String name)
	{
		String str = name;
		this.name = name;
		System.out.println("매개변수 받는 애 " + str);
	}
	
	public void setGreeting(String greeting)
	{
		
		this.greeting = greeting;
	}

	@Override
	public void sayHello()
	{
		String str = greeting + ", " + name + "!!!";
		System.out.println(str); // 콘솔 출력
	}
}
