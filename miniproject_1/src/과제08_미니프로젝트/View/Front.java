package 과제08_미니프로젝트.View;

import java.util.ArrayList;
import java.util.Scanner;

import 과제08_미니프로젝트.Controllor.CProduct;
import 과제08_미니프로젝트.Controllor.Mcontroller;
import 과제08_미니프로젝트.Model.Accessories;
import 과제08_미니프로젝트.Model.Beauty;
import 과제08_미니프로젝트.Model.Dresses;
import 과제08_미니프로젝트.Model.Electronics;
import 과제08_미니프로젝트.Model.Product;



public class Front {
	
	Scanner scanner = new Scanner(System.in);
	
	Mcontroller mc = new Mcontroller();
	
	Product p  = new Product();
	Product p1 = new Dresses();
	Product p2 = new Beauty();
	Product p3 = new Accessories();
	Product p4 = new Electronics();

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
	public void product( String id ) { }
	
	// 7. 메인
	public void main_page() {
		System.out.println(">>>>main>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------------\n"
					+ "1. 의류\n2. 화장품\n3. 악세사리\n4. 전자제품\n"
					+ "---------------------------------------------------------------------\n"
					+ "메뉴 > 1. 카테고리 선택  2. 마이페이지\n"
					+ "----------------------------------------------------------------------");
		
		int ch = scanner.nextInt();
		
		if		(ch==1) {print_page(p1.print("01")); }
		else if	(ch==2) {print_page(p2.print("02")); }
		else if	(ch==3) {print_page(p3.print("03")); }
		else if	(ch==4) {print_page(p4.print("04"));; }
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
	}
	
	// 8. 출력
	public void print_page(ArrayList<Product> result) {
		
		ArrayList<Product> List = result;
		
		System.out.println(">>>>출력>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("카테고리번호\t제품번호\t제품이름\t제품가격");
		for (Product p :List)
		{System.out.println(p.pCode+"\t"+p.pno+"\t"+p.title+"\t"+p.price+"\t"+p.state); }
		
		System.out.println("---------------------------------------------------------------------\n"
						+ "메뉴 > 1. 제품등록	    2. 제품상세\n"
						+ "----------------------------------------------------------------------");
		
		System.out.println("[알림] 등록 완료되었습니다.");
	}
	// 9. 등록
	public void resgister_page(int mno) {
		
		System.out.println(">>>>등록>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1. 의류 2. 화장품 3. 악세사리 4. 전자제품");
		System.out.println("카테 고리:");	String pcode 	= scanner.next();
		System.out.println("제품 이름:"); 	String title 	= scanner.next();
		System.out.println("제품 내용:"); 	String content 	= scanner.next();
		System.out.println("제품 가격:"); 	String price 	= scanner.next();
		
		if		(pcode.equals("1")) {p1.register(mno, title, content, price);}
		else if	(pcode.equals("2")) {p2.register(mno, title, content, price);}
		else if	(pcode.equals("3")) {p3.register(mno, title, content, price);}
		else if	(pcode.equals("4")) {p4.register(mno, title, content, price);}
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
	
	}
	// 10. 상세
	public void view_page(int mno) {
		System.out.println(">>>>상세>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("제품 번호:");  int pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------------------------------");
		p.view(mno, pno);
	}
	
	
	// 11. 등록제품 출력
	public void myproduct_page(int mno) {
		
		ArrayList<Product> myP = CProduct.getInstance().myProducts(mno);
		System.out.println(">>>>등록 제품 목록 >>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("카테고리번호\t제품번호\t제품이름\t제품가격");
		for(Product p : myP)
			{System.out.println(p.pCode+"\t"+p.pno+"\t"+p.title+"\t"+p.price+"\t"+p.state);}
		System.out.println("---------------------------------------------------------------------\n"
					+ "메뉴 > 1. 제품수정   2. 제품삭제  3. 판매완료  4. 쪽지함\n"
					+ "----------------------------------------------------------------------");
		
		int ch = scanner.nextInt();
		
		if		(ch==1) {update_page(mno); }
		else if	(ch==2) {delete_page(mno); }
		else if	(ch==3) {compelete_page(mno);}
		else if	(ch==4) {}
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
	}
	
	// 12. 제품 수정
	public void update_page(int mno) {
		
		System.out.println(">>>>수정>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("제품 번호:");  int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("제품 이름:"); 	String title 	= scanner.next();
		System.out.println("제품 내용:"); 	String content 	= scanner.next();
		System.out.println("제품 가격:"); 	String price 	= scanner.next();
		
		p.update(mno, pno, title, content, price);
		
	}
	// 13. 제품 삭제
	public void delete_page(int mno) {
		System.out.println(">>>>삭제>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("제품 번호:");  int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------------------------------");
		
		p.delete(mno, pno);
	}
	// 14. 제품 상태 변경
	public void compelete_page(int mno) {
		System.out.println(">>>>완료>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("제품 번호:");  int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------------------------------");
		
		p.compelete(mno, pno);
	}
	
	
	
	
	
	
} // class e
