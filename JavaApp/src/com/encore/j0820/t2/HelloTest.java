package com.encore.j0820.t2;

public class HelloTest
{
	public static void main(String[] args)
	{
		// 부모클래스 = 자식클래스!! Parent p = new Child();
		MessageBean msg;// 인터페이스
			msg = new MessageBeanKo();
			msg = new MessageBeanEn();
			msg = new MessageBeanVi();
		msg.sayHello("댕댕딩듀");
	}
}
