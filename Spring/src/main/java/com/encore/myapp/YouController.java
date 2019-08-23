package com.encore.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.PersonVO;
import com.encore.domain.ProductVO;

@Controller//나 컨트롤러!! ---> servlet-context.xml등록
@RequestMapping("you")
public class YouController {
   
	@RequestMapping("0822/hello")//가상경로!!   단순JSP포워딩
	public void hello() {//return이 없는 경우(void)  가상경로==호출페이지
	}
	//prefix==> "/WEB-INF/views/"+"0822/hello" + //suffix==> ".jsp"
	// "/WEB-INF/views/0822/hello.jsp"
	
	@RequestMapping("gildong")//가상경로!!   단순JSP포워딩
	public String hello2() {//return이 없는 경우(void)  가상경로==호출페이지
	  return "0822/hello";	
	}
	
	@RequestMapping("form")//요청URL: /Spring/you/form
	public String form() {
	  return "0822/name_input";
	  //JSP찾기-->WEB-INF/views/+ 리턴문자열 + .jsp	
	}
	
	@RequestMapping("result")//요청URL: /Spring/you/result
	public void result(HttpServletRequest request) {
		String username = request.getParameter("username");
		System.out.println("입력된 이름: "+ username);
	}//리턴생략시: /WEB-INF/views/you/result.jsp 호출
	
	@RequestMapping("result2")//요청URL: /Spring/you/result2
	public String result2(String username, HttpServletRequest req) {
		System.out.println("입력된 이름2: "+ username);
		req.setAttribute("un", username);
		return "0822/result";
	}//WEB-INF/views/0822/result.jsp
	
	
	@RequestMapping("/personForm")// URL매핑: Spring/you/personForm
	public String person_form() {
	  return "0822/person_input";//(forward)이동할 페이지에 설정 	
	}//WEB-INF/views/   [0822/person_input]        .jsp
	
	@RequestMapping("/result3")// URL매핑: Spring/you/result3
	//public String result3(String name, int age, String job) {
	public String result3(PersonVO vo , Model model) {
     /*		
		PersonVO vo = new PersonVO();
		 vo.setName(request.getParameter("name"));
		 vo.setAge(Integer.parseInt(request.getParameter("age")));
		 vo.setJob(request.getParameter("job"));
	  */
		System.out.println("vo>>>"+ vo);
		
		model.addAttribute("person", vo);
		model.addAttribute(vo);//("personVO",vo)
		
		return "0822/result3";//(forward)이동할 페이지에 설정 	
	}//WEB-INF/views/   [0822/result3]        .jsp
	
	/*
	    문제) 웹브라우저에서   /Spring/you/product URL요청시
	    
	    - YouController의  product메소드가 실행되고 메소드내에서 임의의 상품등록
	    - 이동페이지는  /WEB-INF/views/0822/productDetail.jsp 로 설정.
	    - JSP페이지에서 상품정보출력
	 */
	
	 @RequestMapping("/product")
     public String product(Model m) {
		//ProductVO vo = new ProductVO("샘플상품",20000); 
		//m.addAttribute("product", vo);//== request.setAttribute("product",vo)
		m.addAttribute(new ProductVO("샘플상품",20000));
//만약 키값을 생략해서 데이터를 영역에 저장한다면 ==> 기본키값: 클래스명이 설정(첫글자 소문자)
		//== request.setAttribute("productVO",vo)
		
    	return "0822/productDetail";
     }
	 
	 
	 @RequestMapping("/product2")   //URL요청 정의  /Spring/you/product2
	 public String product2(Model m, RedirectAttributes attr) {
		 ProductVO vo = new ProductVO("꿀상품", 30000);
		 //m.addAttribute("vo",vo);//리다이렉트 이동시 데이터 공유X
		 attr.addFlashAttribute("vo",vo);//리다이렉트 이동시 데이터 공유O
		 /*
		     해결법1)
		        String product2(HttpSession session)
		          ---> session.setAttribute("vo",vo);
                     해결법2)		          
		        RedirectAttributes사용
		          ---> 리다이렉트 이동시 request공유할 데이터(일회성 데이터)를 표현
		  */
		 
		 //return "redirect:/WEB-INF/views/0822/productDetail.jsp";
		 return "redirect:/you/lime";
	 }
	 
	 @RequestMapping("/lime")     //URL요청 정의==> /Spring/you/lime
	 public String productDetail() {
		 return "0822/productDetail";
	 }
	 
}//YouController

















