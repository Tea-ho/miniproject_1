package 과제08_미니프로젝트.Controllor;

import java.util.ArrayList;

import 과제08_미니프로젝트.Model.Product;

public class CProduct {

	private static CProduct pc = new CProduct();
	private CProduct () { }
	public static CProduct getInstance() {
		return pc;
	}
	
	private static ArrayList<Product> productDB = new ArrayList<>();
	public static ArrayList<Product> getInstances() {
		return productDB ;
	}
	
	// ?
			
	// 제품 출력
	public ArrayList<Product> print () {
		
		
		return productDB;
	}
	
	// 제품 등록
	public boolean register() {
		
		return true;
	}
	// 제품 상세
	public Product view() {
		
		Product product = new Product();
		
		return product;
	}
	// 제품 수정
	public boolean update() {
		
		return true;
	}
	// 제품 삭제
	public boolean delete() {
		
		return true;
	}
	// 제품 상태 변경
	public boolean compelete() {
		
		return true;
	}
	
	
}
