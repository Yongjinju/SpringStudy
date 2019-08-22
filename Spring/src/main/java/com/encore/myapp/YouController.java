package com.encore.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.PersonVO;
import com.encore.domain.ProductVO;

@Controller // 내가 컨트롤러라는걸 밝혀줘야 한다. => servlet-context.xml 에도 등록!
@RequestMapping("you")
public class YouController
{
	@RequestMapping("/0822/hello") // 가상경로, 단순 JSP 포워딩~!
	public void hello() // return 이 없는 경우 (void), 가상경로 == 호출 페이지
	{
		// prefix = "/WEB-INF/views/" + "0822/hello" +
		// suffix = ".jsp"
	}

	@RequestMapping("yongjin")
	public String hello2()
	{
		return "0822/hello";

	}

	@RequestMapping("form")
	public String form()
	{
		return "0822/name_input";
	}

	@RequestMapping("result")
	public void result(HttpServletRequest request)
	{
		System.out.println(" 하이 " + request.getParameter("username"));
	}// 리턴 생략시에는 /WEB-INF/views/you/result.jsp 호출

	@RequestMapping("result2")
	public String result2(String username, HttpServletRequest req)
	{
		System.out.println(" 하이2 " + username);
		req.setAttribute("un", username);

		return "0822/result";
	}

	@RequestMapping("personForm") // URL 매핑 : Spring/you/personForm
	public String person_form()
	{
		return "0822/person_input"; // (forwad)이동할 페이지
	}

	@RequestMapping("result3")
	public String result3(PersonVO vo, Model model)
	{
		/*
		 * PersonVO vo = new PersonVO(); vo.setName(request.getParameter("name"));
		 * vo.setName(request.getParameter("age"));
		 * vo.setName(request.getParameter("job"));
		 */
		System.out.println("vo>>>" + vo);

		model.addAttribute("person", vo);

		return "0822/result3";
	}

	/*
	 * 문제 ) 웹프라우저에서 /Spring/you/product URL 요청시 YouController의 product메소드가 실행되고
	 * 이동페이지는 /WEB-INF/views/0822/
	 */

	@RequestMapping("/product")
	public String product(Model mo)
	{
		ProductVO vo = new ProductVO();
		String name = "딩꼬스";
		double price = 1025;

		vo.setName(name);
		vo.setPrice(price);
		mo.addAttribute("product", vo);
		return "0822/productDetail";
	}

	@RequestMapping("product2")
	public String product2(Model mo, RedirectAttributes attr)
	{
		ProductVO vo = new ProductVO("꿀상품", 30000);

		// mo.addAttribute("vo", vo); //리다이렉트 이동시 데이터 공유 안함
		/*
		 * 해결법1) String product2(HttpSession session) -> sesseion.setAttribute("vo",
		 * vo); 해결법2) RedirectAttributes사용 -> 리다이렉트 이동시 request공유할 데이터 ( 일회성 데이터 ) 를 표현
		 */
		attr.addFlashAttribute("vo", vo);

//		return "redirect:0822/productDetail"; 이렇게는 안된다 404 에러
		return "redirect:/you/lime";
	}

	@RequestMapping("/lime")
	public String productDetail()
	{
		return "0822/productDetail";
	}
}
