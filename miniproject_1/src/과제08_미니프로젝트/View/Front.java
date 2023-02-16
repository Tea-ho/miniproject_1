package 과제08_미니프로젝트.View;

import java.util.Scanner;

import 과제08_미니프로젝트.Controllor.CMemo;
import 과제08_미니프로젝트.Controllor.Mcontroller;
import 과제08_미니프로젝트.Model.MMemo;



public class Front {
	
	Scanner scanner = new Scanner(System.in);
	
	Mcontroller mc = new Mcontroller();
	
	// 1. 메인페이지
	public void index() {
		while(true) {
			System.out.println(" ************이젠 중고************ ");
			System.out.println(" 1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기");	// 즐겨찾기 품목 추가??
			System.out.println("메뉴 선택 : ");int ch = scanner.nextInt();
			if ( ch == 1 ) { signup(); }
			else if ( ch == 2 ) { login(); }
			else if ( ch == 3) { findId(); }
			else if ( ch == 4 ) { findPw(); } 
			else { System.err.println("메뉴선택을 [1] ~ [4]번 안에서 해주세요."); }
		}
	}
	
	// 2. 회원가입 페이지
	void signup() {
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pwd = scanner.next(); 
		System.out.println("비밀번호 확인 : ");	String confirmpwd = scanner.next();
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		
	}
	
	// 3. 로그인 페이지
	void login() {
		
	}
	
	// 4. 아이디 찾기 페이지
	void findId(){
		
	}
	
	// 5. 비밀번호 찾기 페이지
	void findPw() {
		
	}
	
	// 6. product로 화면 이동
	public void product( ) { }
	
	
	
	
	//----------------------------------------------------- 메모 Strat
	// 1. 쪽지 작성 화면
	public void writeMemo( int mno, int pno ) {
		System.out.println("-----------------------쪽지 작성 페이지-----------------------");
		System.out.print("제목: ");					String title = scanner.next();
		System.out.print("내용: ");					String content = scanner.next();
		System.out.print("[하단 버튼] 1.발송 2.취소: ");	int send = scanner.nextInt();
		
		boolean result = CMemo.getInstance().writeMemo(mno, pno, title, content, send);
		if(result) {
			System.out.println("[알림]쪽지 발송 완료");
		}
		// 확인 필요 내용: 2번 눌렀을 때, 뒤 메뉴로 가는지 확인
	}
	
	// 2. 쪽지 출력 화면
	public void printMemo( int pno ) {
		while( true ) {
			System.out.println("-----------------------쪽지함-----------------------");
			System.out.println("번호\t제목\t작성자");
			CMemo.getInstance().printMemo(pno);
			System.out.print("[쪽지 클릭] 쪽지 번호 입력: ");	int mNo = scanner.nextInt();
			detailMemo(mNo, pno);
		}
	}
	
	public void detailMemo( int mNo, int pno ) {
		CMemo.getInstance().detailMemo(mNo);
		System.out.print("[하단 버튼] 1.답장 2.뒤로가기 3.삭제");	int choice = scanner.nextInt();
		if( choice == 1 ) {
			
		}
		else if( choice == 2 ) {
			
		}
		else if( choice == 3 ) {
			
		}
		else { System.out.println("번호를 다시 입력해주세요.");	}
	}
	
	
	
	
} // class e
