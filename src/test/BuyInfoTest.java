package test;

public class BuyInfoTest {

	public static void main(String[] args) {

		BuyInfoDAO bDAO = new BuyInfoDAO();
		BuyInfoDTO bDTO = new BuyInfoDTO();

		// 판매량
		bDTO.setSearchCondition("판매량");
		bDTO.setPID(1);
		BuyInfoDTO resultDTO = bDAO.selectOne(bDTO);
		if (resultDTO != null) {
			System.out.println("판매량: " + resultDTO.getbQty());
		} else {
			System.out.println("검색 결과가 없습니다.");
		}

		// 구매내역 추가
//		bDTO.setSearchCondition("구매내역추가");
//		bDTO.setMID("teemo"); // 회원 아이디
//		bDTO.setPID(1); // 상품 번호
//		bDTO.setCPID("CP001"); // 쿠폰 번호
//		bDTO.setOrderNum(12345); // 주문번호
//		bDTO.setDeliState("결재 완료"); // 배송 상태
//		bDTO.setbQty(3); // 구매 수량
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
