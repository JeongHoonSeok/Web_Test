package test.test;

import java.util.ArrayList;

import test.dao.CartDAO;
import test.dto.CartDTO;

public class CartTest {

    public static void main(String[] args) {
        CartDAO cDAO = new CartDAO();
        CartDTO cDTO = new CartDTO();
        ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();
        
        // 상품삭제
//        System.out.println("[로그]_1");
//        for(int i = 7; i<11; i++) {
//        	cDTO = new CartDTO();
//        	System.out.println("[로그]_2");
//        	cDTO.setCID(i);
//        	System.out.println("i = "+cDTO.getCID());
//        	cartList.add(cDTO);
//        }
//        for(int i = 0; cartList.size() > i; i++) {
//        	System.out.println("i = "+cartList.get(i).getCID());
//        	cDTO=cartList.get(i);
//        	cDTO.setSearchCondition("장바구니비우기");
//        	System.out.println("i = "+cDTO.getCID());
//        	boolean result = cDAO.delete(cDTO);
//        	if(result == true) {
//        		System.out.println("삭제성공");
//        	} else {
//        		System.out.println("삭제실패");
//        	}
//        }
          
        
        // 장바구니 상품확인
//        cDTO.setSearchCondition("상품확인");
//        cDTO.setMID("teemo");
//        cDTO.setPID(1);
//        cDTO = cDAO.selectOne(cDTO);
//        if(cDTO != null) {
//        	System.out.println("상품확인 결과 이미 있는 상품");
//        	System.out.println("ID : "+cDTO.getMID());
//        	System.out.println("P_ID : "+cDTO.getPID());
//        } else {
//        	System.out.println("상품확인 결과 장바구니에 없는 상품");
//        }
        
        
        // 장바구니 삭제
////        cDTO.setSearchCondition("장바구니삭제");
////        cDTO.setCid(1);
//        cDTO.setSearchCondition("장바구니비우기");
//        cDTO.setMid("teemo");
//
//        boolean result = cDAO.delete(cDTO);
//
//        if (result) {
//            System.out.println("장바구니 삭제 성공");
//        } else {
//            System.out.println("장바구니 삭제 실패");
//        }
        
        

        // 장바구니 목록 출력 테스트
        cDTO.setMID("teemo");
        cDTO.setSearchCondition("장바구니목록출력");
        cartList = cDAO.selectAll(cDTO);

        if (cartList.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            System.out.println("장바구니 목록:");
            for (CartDTO cartDTO : cartList) {
                System.out.println("장바구니 ID: " + cartDTO.getCID());
                System.out.println("상품 ID: " + cartDTO.getPID());
                System.out.println("수량: " + cartDTO.getcQty());
                System.out.println("상품명: " + cartDTO.getAncPName());
                System.out.println("판매 가격: " + cartDTO.getAncSellingPrice());
                System.out.println("이미지 경로: " + cartDTO.getAncImagePath());
                System.out.println("");
            }
        }
        

        // 장바구니 추가 테스트
//        cDTO.setMID("teemo"); // 회원 ID
//        cDTO.setPID(4); // 상품 ID
//        cDTO.setcQty(100); // 수량
//        cDTO.setSearchCondition("장바구니추가"); // 검색 조건 설정
//        boolean result = cDAO.insert(cDTO);
//        if (result) {
//            System.out.println("장바구니에 상품 추가 성공");
//        } else {
//            System.out.println("장바구니에 상품 추가 실패");
//        }
        
        
    }
}
