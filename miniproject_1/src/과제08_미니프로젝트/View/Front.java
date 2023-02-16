package 과제08_미니프로젝트.View;

import java.util.Scanner;

import 과제08_미니프로젝트.Controllor.Mcontroller;


public class Front {
	
	// 싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 메인페이지
	public void index() {
		while(true) {
			System.out.println(" ---------------이젠 중고--------------- ");
			System.out.println(" 1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기");	// 즐겨찾기 품목 추가??
			System.out.println("메뉴 선택 : ");int ch = scanner.nextInt();
			if ( ch == 1 ) { signup_page(); }
			else if ( ch == 2 ) { login_page(); }
			else if ( ch == 3) { findId_page(); }
			else if ( ch == 4 ) { findPw_page(); } 
			else { System.err.println("메뉴선택을 [1] ~ [4]번 안에서 해주세요."); }
		}
	}
	
	// 2. 회원가입 페이지
	public void signup_page() {
		System.out.println("ID : ");			String id = scanner.next();
		System.out.println("PW : ");			String pwd = scanner.next(); 
		System.out.println("Password 확인 : ");	String confirmpwd = scanner.next();
		System.out.println("이름 : ");			String name = scanner.next();
		System.out.println("전화번호 : ");			String phone = scanner.next();
		
		int result = Mcontroller.getInstance().signup(id, pwd, confirmpwd, name, phone );
		if ( result == -6) { System.out.println("[알림] 회원가입 성공 축하드립니다!"); } // 회원가입 성공 시 product 페이지로 이동
		else if ( result == -1 ) { System.out.println("비밀번호가 다릅니다.");}
		else if ( result == -2 ) { System.out.println("ID의 길이를 5~10글자로 해주세요.");}
		else if ( result == -3 ) { System.out.println("ID는 영문과 숫자로 입력해주세요.");}
		else if ( result == -4 ) { System.out.println("전화번호에 숫자만 입력해주세요."); }
		else if ( result == -5 ) { System.out.println("ID와 Password 값이 같습니다. 다르게 입력해주세요.");  }
	}
	
	// 3. 로그인 페이지
	public void login_page() {
		System.out.println("ID : "); String id = scanner.next();
		System.out.println("PW : "); String pw = scanner.next();
		int result = Mcontroller.getInstance().login( id, pw );
		if ( result == -1 ) {System.out.println("ID나 PW가 옳지 않습니다.");}
		else if ( result == -2 ) { System.out.println("로그인 실패. 해당 아이디가 존재하지 않습니다."); } 
		else if ( result >= 0){ System.out.println("[알림]로그인 성공" + result); product( ); } // result가 0이상일때 로그인성공 + mno 부여
		
	}
	
	// 4. 아이디 찾기 페이지
	public void findId_page(){
		System.out.println(" 이름 입력 : ");		String name = scanner.next();
		System.out.println(" 전화번호 입력 : ");	String phone = scanner.next();
		String result = Mcontroller.getInstance().findId(name, phone);
		if ( result == null ) { System.out.println("아이디 찾기 실패"); }
		else { System.out.println("회원님의 아이디 : " + result + "입니다."); }
	}
	
	// 5. 비밀번호 찾기 페이지
	public void findPw_page() {
		System.out.println("ID 입력 : ");			String id = scanner.next();
		System.out.println("전화번호 입력 : ");		String phone = scanner.next();
		String result = Mcontroller.getInstance().findPw(id, phone);
		if ( result == null ) { System.out.println("비밀번호 찾기 실패"); }
		else { System.out.println("회원님의 비밀번호 : " + result + "입니다."); }
 	}
	
	
	// 7. product로 화면 이동
	public void product( ) { System.out.println("product 페이지"); }
	
	
	
	
	
	
	
	
	
	
	
	
} // class e
