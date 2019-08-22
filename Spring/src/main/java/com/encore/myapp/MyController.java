package com.encore.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // extends HttpServlet, extends Action 대신
public class MyController 
{
	@RequestMapping("/doA")// 가상의 경로 설정 ( /
	public void doA()
	{
		System.out.println("doA 요청이 들어와쓰요");
	}
	@RequestMapping("/yongjin") // 1.가상경로
	public String yongjin()
	{
		System.out.println("용진쓰"); 
		//2. getParameter
		//3. Model m = new Model
		//4. setArribute
		
		return "0821/hello"; //5. 페이지 이동 (기본 : forward )
	}
	/*
	 * [ return "hello" ]
	 * - servlet-context.xml
	 * <beans:property name = "prefix" value="/WEB-INF/views/" />
	 * <beans:property name = "suffix" value=".jsp" />
	 * 
	 * 접두사 : "/WEB-INF/views/"
	 * 			+ "0821/hello" +
	 * 접미사 : ".jsp"
	 * 
	 * 해서 리턴~! /WEB-INF/views/0821/hello.jsp
	 * 
	 */
}
