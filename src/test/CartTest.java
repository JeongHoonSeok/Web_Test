package test;

import java.util.ArrayList;

public class CartTest {

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();

        // 장바구니 목록 출력 테스트
        CartDTO rAllCartDTO = new CartDTO();
        rAllCartDTO.setSearchCondition("장바구니목록출력");
        ArrayList<CartDTO> cartList = cartDAO.selectAll(rAllCartDTO);
        for (CartDTO cartDTO : cartList) {
            System.out.println("장바구니 ID: " + cartDTO.getCid());
            System.out.println("회원 ID: " + cartDTO.getMid());
            System.out.println("상품 ID: " + cartDTO.getPid());
            System.out.println("수량: " + cartDTO.getcQty());
            System.out.println("상품명: " + cartDTO.getpName());
            System.out.println("판매 가격: " + cartDTO.getSellingPrice());
            System.out.println("이미지 경로: " + cartDTO.getImagePath());
            System.out.println("");
        }

        // 장바구니 추가 테스트
//        CartDTO insertCartDTO = new CartDTO();
//        insertCartDTO.setMid("teemo"); // 회원 ID
//        insertCartDTO.setPid(4); // 상품 ID
//        insertCartDTO.setcQty(2); // 수량
//        insertCartDTO.setSearchCondition("장바구니추가"); // 검색 조건 설정
//        boolean isSuccess = cartDAO.insert(insertCartDTO);
//        if (isSuccess) {
//            System.out.println("장바구니에 상품 추가 성공");
//        } else {
//            System.out.println("장바구니에 상품 추가 실패");
//        }
        
        
    }
}
