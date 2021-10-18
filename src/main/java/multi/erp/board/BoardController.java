package multi.erp.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/board/insert.do")
	public String insert(BoardVO command) {
		String url = "";
		int result = service.insert(command);
		if(result >= 1) {
			url = "redirect:/board/list.do?category=all";
		}else {
			url = "redirect:/board/insertPage.do";
		}
		return url;
	}
	@RequestMapping("/board/list.do")
	public ModelAndView boardList(String category) {
		
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardVO> boardlist = service.findByCategory(category);
		
		mav.addObject("boardlist", boardlist);
		mav.addObject("category", category);
		System.out.println("보드리스트!");
		return mav;
	}
	//Ajax로 카테고리별 게시판 데이터를 요청하는 메소드
	//-> 컨트롤러 메소드처럼 ModelAndView를 리턴하지 않고 일반메소드처럼 ArrayList<BoardVO>를 리턴하며
	//	 jackson json라이브러리가 자동으로 ArrayList<BoardVO>를 json으로 변환해서 리턴해준
	@RequestMapping(value="/board/ajax_list.do", method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody ArrayList<BoardVO> categoryList(String category){
		ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>)service.findByCategory(category);
		System.out.println("ajax통신: "+boardlist.size());
		return boardlist;
	}
	@RequestMapping(value="/board/read.do")
	public ModelAndView read(String board_no, String state) {
		System.out.println("readController=> "+board_no+", "+state);
		ModelAndView mav = new ModelAndView();
		BoardVO board = service.read(board_no);
		String viewName = "";
		if(state.equals("READ")) {
			viewName = "board/read";
		}else {
			viewName = "board/update";
		}
		mav.setViewName(viewName);
		mav.addObject("board", board);
		return mav;
	}
	@RequestMapping("/board/search.do")
	public ModelAndView search(String tag, String search) {
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>) service.searchList(tag,search);
		mav.addObject("boardlist", boardlist);
		mav.addObject("category", "all");
		mav.setViewName("board/list");
		return mav;
	}
}
