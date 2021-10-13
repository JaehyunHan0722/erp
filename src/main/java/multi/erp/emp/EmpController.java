package multi.erp.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping("/emp/insert.do")
	//스프링 MVC의 DispatherServlet이 넘겨주는 VO객체를 서비스단의 메소드를 호출하면서 넘겨준다.
	public String insert(EmpVO command) { //VO객체를 command객체라 한다.
		System.out.println("==============>"+command);
		service.insert(command);
		return "redirect:/emp/loginPage.do"; //회원가입이 완료되면 로그인을 하기 위한 페이지로 redirect하도록 설정
	}
	@RequestMapping("/emp/list.do")
	public ModelAndView getMemberList() {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> userlist = service.getMemberList();
		System.out.println("=============================");
		System.out.println(userlist);
		//tiles에 등록한 뷰의 이름
		mav.setViewName("emp/list");
		mav.addObject("userlist", userlist);
		return mav;
	}
//	@RequestMapping("/emp/idCheck.do")
//	public ModelAndView idCheck(String id) {
//		ModelAndView mav = new ModelAndView();
//		boolean state = service.idCheck(id);
//		String result = "";
//		if(state) {
//			result = "사용불가능한 아이디";
//		}else {
//			result = "사용 가능한 아이디";
//		}
//		mav.setViewName("emp/insert");
//		mav.addObject("result", result);
//		return mav;
//	}
	//Ajax로 요청되는 메소드
	/*
	 * produces속성: Ajax요청 후 클라이언트로 전송할 데이터의 타입을 정의
	 * 				application/text는 Ajax요청을 처리하고 클라이언트로 보내는 응답메시지 타입이 text라는 의미
	 */
	//String은 response되는 데이터의 형식 - 어노테이션을 이용해서 response되는 데이터라는 것을 표시
	@RequestMapping(value="/emp/idcheck.do", method = RequestMethod.GET,
			produces = "application/text;charset=utf-8")
	public @ResponseBody String idCheck(String id) {
		boolean state = service.idCheck(id);
		String result = "";
		if(state) {
			result = "사용불가능한 아이디";
		}else {
			result = "사용 가능한 아이디";
		}
		return result;
	}
	
	@RequestMapping(value="/emp/login.do", method=RequestMethod.POST)
	public ModelAndView login(EmpVO user) {
		ModelAndView mav = new ModelAndView();
		EmpVO state = service.login(user);
		if(state != null) {
			mav.setViewName("login/ok");
			mav.addObject("user", user);
		}else {
			mav.setViewName("redirect:/emp/loginPage.do");
		}
		return mav;
	}
}
