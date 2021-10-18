package multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(BoardVO board) {
		int result = sqlSession.insert("erp.board.insert", board);
		return result;
	}

	@Override
	public List<BoardVO> boardList() {
		return sqlSession.selectList("erp.board.list");
	}

	@Override
	public List<BoardVO> searchList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		//SqlSession의 여러 메소드를 호출하면서 VO객체, 문자열 Map등에 데이터를 저장해서 전달할 수 있다.
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", search);
		System.out.println("dao!");
		return sqlSession.selectList("erp.board.dynamicsql", map);
	}

	@Override
	public List<BoardVO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO read(String board_no) {
		return sqlSession.selectOne("erp.board.read", board_no);
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
	public List<BoardVO> categorySearch(String category) {
		return sqlSession.selectList("erp.board.category", category);
	}
	
	
}
