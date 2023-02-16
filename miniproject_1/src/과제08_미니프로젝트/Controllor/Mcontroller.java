package 과제08_미니프로젝트.Controllor;

import java.util.ArrayList;

import 과제08_미니프로젝트.Model.Member;


public class Mcontroller {
	
	// Mcontroller 싱글톤
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() { return mc; }
	private ArrayList<Member> memberDb = new ArrayList<>();
	
	// 보통 logSession 안쓴다 = mno 를 회원가입 고유번호 붙여야함 방법은?

	
	// 1. 회원가입 로직
	public int signup( String id, String pwd, String confirmpwd, String name , String phone ){
		// 1. 유효성검사( + 등록된 id 값과 비교도 하기 )
			// 1. pwd, confirmpwd 값 비교
		if (!pwd.equals(confirmpwd) ) { return 1; } // 비밀번호확인 오류  = return 1
		else if ( id.length() < 5 && id.length() > 10   ) { return 2; } // id 길이 5~10 아닐 경우 = return 2
		else if ( id.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) { return 3;} // id에 한글 받으면 = return 3
		else if ( !phone.matches("[0-9]+")) { return 4; } // phone에 숫자 입력받으면 = return 4
		else if ( id.equals(pwd) ) { return 5; } // id와 pwd 같으면 = return 5 
		return 0; // 회원가입 성공
	}
	
	// 2. 로그인 로직
	public int login ( String id , String pw , int mno) {
		
		for ( int i = 0 ; i<memberDb.size(); i++ ) {
			if(memberDb.get(i).getPwd().equals(pw)) {
				if(memberDb.get(i).getId().equals(id) ) {
					return mno;
				}
			}
		}
		
		return 0;
	}
	
	// 3. 아이디 찾기 로직
	
	// 4. 비밀번호 찾기 로직
}
