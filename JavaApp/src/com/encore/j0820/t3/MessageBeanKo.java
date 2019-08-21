package com.encore.j0820.t3;

public class MessageBeanKo implements MessageBean
{
	public MessageBeanKo()
	{
		System.out.println(" >>> MessageBeanKo기본생성자 ");
	}
	
	@Override
	public void sayHello(String name)
	{
		// TODO Auto-generated method stub
		System.out.println("안녕, " + name + "!!!");
	}

}
