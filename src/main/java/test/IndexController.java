package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import multi.erp.board.BoardService;
import multi.erp.board.BoardVO;

@Controller
public class IndexController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/userinfo/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		List<BoardVO> boardlist = service.findByCategory("게시판");
		mav.addObject("boardlist", boardlist);
		return mav;
	}
//	@RequestMapping("/emp/login.do")
//	public String loginPage() {
//		return "login";
//	}
	@RequestMapping("/menu/board.do")
	public String boardlist() {
		return "board/list";
	}
}
