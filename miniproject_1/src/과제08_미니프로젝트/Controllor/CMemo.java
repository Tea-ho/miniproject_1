package 과제08_미니프로젝트.Controllor;

import java.util.ArrayList;

import 과제08_미니프로젝트.Model.MMemo;

public class CMemo {

	// 필드 영역
	private ArrayList<MMemo> memoDB = new ArrayList<>();
	
	// 생성자 영역
	// 싱글톤 적용
	private static CMemo memo = new CMemo();
	private CMemo() {}
	public static CMemo getInstance() { return memo; }
	
	// 메소드 영역
	// 1. 메시지 작성 메소드 (기능: 로그인 유무 체크)
	
	// 2. 메시지 발송 처리 메소드 (기능: DB 저장)
	
	// 3. 메시지 출력 메소드 (기능: MMemo tostring 출력)
	
	// 4. 메시지 상세보기 메소드 (기능: 선택된 메시지 내용 상세 보기)
	
}
