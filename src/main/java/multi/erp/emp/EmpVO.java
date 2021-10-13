package multi.erp.emp;
/*
 * 테이블에 레코드를 모델링한 클래스
 * 정해진 규칙이 있다.
 * 프레임워크 내부에서 사용
 * 	- public 클래스로 작성
 * 	- 멤버 변수는 private (테이블의 커럼)
 * 	- 기본 생성자 만들기
 * 	- 매개변수가 있는 생성자 만들기
 */
public class EmpVO {
	private String id;
	private String pass;
	private String name;
	private String addr;
	private int point;
	private String deptno;
	
	public EmpVO() {
		
	}
	//insert용
	public EmpVO(String id, String pass, String name, String addr, String deptno) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.deptno = deptno;
	}
	//select용
	public EmpVO(String id, String pass, String name, String addr, int point, String deptno) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.point = point;
		this.deptno = deptno;
	}
	public EmpVO(String id, String addr) {
		super();
		this.id = id;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", point=" + point
				+ ", deptno=" + deptno + "]";
	}
	
	public String getId() {
		System.out.println("getId===============");
		return id;
	}
	public void setId(String id) {
		System.out.println("setId===============");
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
}
