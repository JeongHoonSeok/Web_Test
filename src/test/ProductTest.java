package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {

		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();

		// 상품추가
//		productDTO.setSearchCondition("상품추가");
//		productDTO.setpName("테스트 페이지 새로운 제품");	//1
//		productDTO.setCostPrice(10000);				//2
//		productDTO.setRegularPrice(15000);			//3
//		productDTO.setSellingPrice(12000);			//4
//		productDTO.setpQty(50);						//5
//		productDTO.setIngredient("새로운 성분");		//6
//		productDTO.setCategory("새로운 카테고리");		//7
//		productDTO.setSellingState("판매중");			//8
//		productDTO.setImagePath("이미지 경로");			//9
//		productDTO.setpDetail("상품정보");				//10
//
//		boolean isSuccess = productDAO.insert(productDTO);
//		
//		if (isSuccess) {
//			System.out.println("제품 추가 성공");
//		} else {
//			System.out.println("제품 추가 실패");
//		}

		// 필터검색
        productDTO.setSearchCondition("상품출력필터");      
        productDTO.setSellingState("판매중");
        productDTO.setpName("");	//1
        System.out.println(productDTO.getpName());
        productDTO.setCategory("");	//2
        System.out.println(productDTO.getCategory());
        productDTO.setSellingPrice(0);//3
        ArrayList<ProductDTO> productList = productDAO.selectAll(productDTO);
        System.out.println("[로그_테스트] selectAll 성공");
        
        if (productList != null) {
        	System.out.println("[로그_테스트] != null");
            for (ProductDTO product : productList) {
                System.out.println("상품명: " + product.getpName());
                System.out.println("가격: " + product.getSellingPrice());
                System.out.println("재고: " + product.getpQty());
                System.out.println("판매량: " + product.getAncTotalQty());
            }
        } else {
            System.out.println("상품 리스트가 없거나 오류가 발생했습니다.");
        }

		// 상품상세
//		productDTO.setSearchCondition("상품상세정보");
//		productDTO.setPID(1);	//1
//		productDTO =productDAO.selectOne(productDTO);
//		System.out.println(productDTO);			

		// 상품출력페이지
//		productDTO.setSearchCondition("상품목록페이지");
//		productDTO.setAncSelectMin(1);
//		productDTO.setAncSelectMax(8);
//        ArrayList<ProductDTO> productList = productDAO.selectAll(productDTO);
//        
//        if (productList != null && !productList.isEmpty()) {
//            System.out.println("상품 목록 조회 성공");
//            
//            Iterator<ProductDTO> iterator = productList.iterator();
//            while (iterator.hasNext()) {
//                ProductDTO product = iterator.next();
//                System.out.println("상품번호: " + product.getPID());
//                System.out.println("상품명: " + product.getpName());
//                System.out.println("상품정보: " + product.getpDetail());
//                System.out.println("원가: " + product.getCostPrice());
//                System.out.println("정가: " + product.getRegularPrice());
//                System.out.println("판매가: " + product.getSellingPrice());
//                System.out.println("재고: " + product.getpQty());
//                System.out.println("성분: " + product.getIngredient());
//                System.out.println("카테고리: " + product.getCategory());
//                System.out.println("등록일: " + product.getRegTime());
//                System.out.println("판매상태: " + product.getSellingState());
//                System.out.println("이미지 경로: " + product.getImagePath());
//                System.out.println("==========================");
//            }
//        } else {
//            System.out.println("상품 목록 조회 실패");
//        }

		// 상품출력전체
//		productDTO.setSearchCondition("상품출력전체");
//        ArrayList<ProductDTO> productList = productDAO.selectAll(productDTO);
//        
//        if (productList != null && !productList.isEmpty()) {
//            System.out.println("상품 목록 조회 성공");
//            
//            Iterator<ProductDTO> iterator = productList.iterator();
//            while (iterator.hasNext()) {
//                ProductDTO product = iterator.next();
//                System.out.println("상품번호: " + product.getPID());
//                System.out.println("상품명: " + product.getpName());
//                System.out.println("상품정보: " + product.getpDetail());
//                System.out.println("원가: " + product.getCostPrice());
//                System.out.println("정가: " + product.getRegularPrice());
//                System.out.println("판매가: " + product.getSellingPrice());
//                System.out.println("재고: " + product.getpQty());
//                System.out.println("성분: " + product.getIngredient());
//                System.out.println("카테고리: " + product.getCategory());
//                System.out.println("등록일: " + product.getRegTime());
//                System.out.println("판매상태: " + product.getSellingState());
//                System.out.println("이미지 경로: " + product.getImagePath());
//                System.out.println("==========================");
//            }
//        } else {
//            System.out.println("상품 목록 조회 실패");
//        }

		// 상품판매상태 변경
//		productDTO.setSearchCondition("판매중지");
//		productDTO.setPID(1);
//		boolean flag = productDAO.update(productDTO);
//		if (flag == true) {
//			System.out.println("판매상태 변경완료");
//		} else {
//			System.out.println("판매상태 변경 실패");
//		}

	}

}
