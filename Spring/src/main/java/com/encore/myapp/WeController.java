package com.encore.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.domain.PersonVO;
import com.encore.persistence.EmpDAO;
import com.encore.s0823.Calculator;

@Controller
@RequestMapping("/0823")//브라우저 URL요청의 표현 (가상의 경로)
public class WeController {
	
	@Autowired
	private EmpDAO dao;
	
   @RequestMapping("/hello")//브라우저 URL요청의 표현 (가상의 경로)	
   public String hello() {//hello.jsp 포워딩
	  return "0823/hello";   
   }
   //리턴된 문자열 "hello"는 ViewResolver에게 전달
   //---> /WEB-INF/views/  +  0823/hello  +        .jsp
   
   @RequestMapping("/remove")//브라우저 URL요청의 표현 (가상의 경로)	
   public @ResponseBody String remove() {//hello.jsp 포워딩
 // @ResponseBody : 리턴 "문자열"이 JSP페이지가 아니라(JSP페이지 사용 안함) 메시지 전달임!!
	  //return "success"; //응답데이터!!  
	  return "성공"; //응답데이터!!  
   }
   
   @RequestMapping("/doPerson")
   public @ResponseBody PersonVO doJSON() {
	   PersonVO p = new PersonVO("나길동",15,"학생");
	   return p;
   }
   
   @RequestMapping(value = "good", method = RequestMethod.GET)
   public void good1() {
	   System.out.println("good - GET요청!!");
   }
   
   @RequestMapping(value="good", method = RequestMethod.POST)
   public void good2() {
       System.out.println("good - POST요청!!");
   }
   
   @RequestMapping(value = "calc", method = RequestMethod.GET)
   public String calcForm() {//계산기 폼 보여주기
	  return "0823/calc_form"; 
   }
   
   @RequestMapping(value = "calc", method = RequestMethod.POST)
   public String calc(int su1, int su2, String oper,Model m) {//계산버튼 클릭해서 결과 리턴
	   //String oper = request.getParameter("oper");
	   //int su1 = Integer.parseInt(request.getParameter("su1"));
	   Calculator calc = new Calculator(su1, su2, oper);
	   m.addAttribute("result",calc.getResultStr());//JSP페이지와 공유할 데이터를 저장
	 return "0823/calc_form";  
   }
   
   
   @RequestMapping("/input")//브라우저 URL요청의 표현 (가상의 경로)
   public void input() {} //==> 요청URL과 응답페이지 같은 경우 리턴을 void로 표시
//   public String input() {//input.jsp 포워딩
//	  return "0823/input";   
//   }
   @RequestMapping("/input2")//브라우저 URL요청의 표현 (가상의 경로)
   public void input2() {} //==> 요청URL과 응답페이지 같은 경우 리턴을 void로 표시
   
   @RequestMapping("/result")//브라우저 URL요청의 표현 (가상의 경로)
   public void print(String name) {//input.jsp에 입력된 값 확인
	   System.out.println("input.jsp에 입력된 이름==> "+ name);
   }
   
   
   @RequestMapping("/result2")//브라우저 URL요청의 표현 (가상의 경로)
   //public void print2(String name,int age,String job) {//input2.jsp에 입력된 값 확인
   public void print2(PersonVO person) {//input2.jsp에 입력된 값 확인
	   System.out.println("input2.jsp에 입력된 값 ==> "+ person);
   }
   
   @RequestMapping("/selectEnames")
   public String selectEname(Model m)
   {
	   m.addAttribute("list", dao.selectEnames());
	   
	   return "0823/emp";//jsp페이지
   }

}






