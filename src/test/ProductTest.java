package test;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductTest {

	public static void main(String[] args) {		

		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();
		
		
		//상품상세
		productDTO.setSearchCondition("상품상세정보");
		productDTO.setPID(1);	//1
		productDTO =productDAO.selectOne(productDTO);
		System.out.println(productDTO);

		//상품추가
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
				
		
		//상품출력페이지
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
        
        //상품출력전체
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
	}

}
