package multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return dao.boardList();
	}

	@Override
	public int txinsert(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BoardVO board) {
		int result = dao.insert(board);
		return result;
	}

	@Override
	public List<BoardVO> searchList(String search) {
		return dao.boardList();
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		return dao.searchList(tag, search);
	}

	@Override
	public List<BoardVO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO read(String board_no) {
		return dao.read(board_no);
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> findByCategory(String category) {
		List<BoardVO> boardlist = null;
		if(category != null) {
			if(category.equals("all")) {
				System.out.println("all");
				boardlist = dao.boardList(); //카테고리 없이 전체 조회하는 dao메소드
			}else {
				boardlist = dao.categorySearch(category); //카테고리별 검색
			}
		}
		return boardlist;
	}

}
