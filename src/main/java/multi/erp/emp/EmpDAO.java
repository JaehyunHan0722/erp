package multi.erp.emp;

import java.util.List;

public interface EmpDAO {
	int insert(EmpVO user);
	List<EmpVO> getMemberlist();
	boolean idCheck(String id);
	boolean login(String id, String pass);
}
