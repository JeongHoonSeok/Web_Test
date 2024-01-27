package test;

import java.util.ArrayList;

public class BuyInfoTest {

	public static void main(String[] args) {

		BuyInfoDAO bDAO = new BuyInfoDAO();
		BuyInfoDTO bDTO = new BuyInfoDTO();
		
		// 주문번호 반환
		bDTO.setSearchCondition("주문번호");
		bDTO = bDAO.selectOne(bDTO);
		if(bDTO != null) {
			System.out.println("구매번호+1 : "+bDTO.getMaxOrderNum());
		} else {
			System.out.println("구매번호 실패");
		}
		
        // 구매상태변경
//        bDTO.setSearchCondition("구매상태변경");
//        bDTO.setBID(1);
//        bDTO.setDeliState("배송 완료");
//
//        boolean result = bDAO.update(bDTO);
//
//        if (result) {
//            System.out.println("배송 상태가 업데이트되었습니다.");
//        } else {
//            System.out.println("배송 상태 업데이트 실패");
//        }

		// 구매내역
		bDTO.setSearchCondition("구매내역");
        bDTO.setMID("teemo");
        ArrayList<BuyInfoDTO> buyList = bDAO.selectAll(bDTO);       
        if (buyList != null && !buyList.isEmpty()) {
            for (BuyInfoDTO buyInfoDTO : buyList) {
                System.out.println("구매번호: " + buyInfoDTO.getBID());
                System.out.println("회원ID: " + buyInfoDTO.getMID());
                System.out.println("상품번호: " + buyInfoDTO.getPID());
                System.out.println("쿠폰번호: " + buyInfoDTO.getCPID());
                System.out.println("주문번호: " + buyInfoDTO.getOrderNum());
                System.out.println("배송상태: " + buyInfoDTO.getDeliState());
                System.out.println("구매수량: " + buyInfoDTO.getbQty());
                System.out.println("결제금액: " + buyInfoDTO.getPaymentPrice());
                System.out.println("구매일: " + buyInfoDTO.getBuyTime());
                System.out.println("우편번호: " + buyInfoDTO.getbPostCode());
                System.out.println("도로명주소: " + buyInfoDTO.getbAddress());
                System.out.println("상세주소: " + buyInfoDTO.getbDetailedAddress());
                System.out.println("---------------------------------");
            }
        } else {
            System.out.println("구매내역이 없습니다.");
        }

		// 판매량
//		bDTO.setSearchCondition("판매량");
//		bDTO.setPID(1);
//		BuyInfoDTO resultDTO = bDAO.selectOne(bDTO);
//		if (resultDTO != null) {
//			System.out.println("판매량: " + resultDTO.getbQty());
//		} else {
//			System.out.println("검색 결과가 없습니다.");
//		}

		// 구매내역 추가
//		bDTO.setSearchCondition("구매내역추가");
//		bDTO.setMID("teemo"); // 회원 아이디
//		bDTO.setPID(1); // 상품 번호
//		bDTO.setCPID("CP001"); // 쿠폰 번호
//		bDTO.setOrderNum(12345); // 주문번호
//		bDTO.setbQty(123456); // 구매 수량
//		bDTO.setPaymentPrice(50000); // 결제 금액
//		bDTO.setbPostCode(12345); // 우편번호
//		bDTO.setbAddress("서울시 강남구"); // 도로명 주소
//		bDTO.setbDetailedAddress("123번지 456호"); // 상세 주소	
//		boolean result = bDAO.insert(bDTO);
//		if (result) {
//			System.out.println("구매 내역 추가 성공!");
//		} else {
//			System.out.println("구매 내역 추가 실패!");
//		}

	}
}
