package test.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import test.dao.CouponDAO;
import test.dto.CouponDTO;

public class CouponTest {

	public static void main(String[] args) {

		CouponDTO couponDTO = new CouponDTO();
		CouponDAO couponDAO = new CouponDAO();

		// 쿠폰삭제
//		couponDTO.setSearchCondition("쿠폰삭제");
//		boolean result = couponDAO.delete(couponDTO);
//		if (result == true) {
//			System.out.println("삭제성공");
//		} else {
//			System.out.println("삭제실패");
//		}

		// 쿠폰사용
//		couponDTO.setSearchCondition("쿠폰사용");
//		couponDTO.setCPID("1");
//		boolean result = couponDAO.update(couponDTO);		
//		if(result==true) {
//			System.out.println("사용성공");
//		} else {
//			System.out.println("사용실패");
//		}

		// 쿠폰목록
		System.out.println("[테스트_쿠폰목록]");
		ArrayList<CouponDTO> coupons = new ArrayList<>();
		// 둘중 하나 주석 처리후 사용
		couponDTO.setSearchCondition("사용가능쿠폰");
//		couponDTO.setSearchCondition("쿠폰목록");
		couponDTO.setMID("teemo");
		coupons = couponDAO.selectAll(couponDTO);
		if (coupons != null) {
			for (CouponDTO coupon : coupons) {
				System.out.println("쿠폰 번호: " + coupon.getCPID());
				System.out.println("쿠폰 이름: " + coupon.getCpName());
				System.out.println("사용 기간: " + coupon.getPeriod());
				System.out.println("할인율: " + coupon.getDiscount() + "%");
				System.out.println("사용 여부: " + coupon.getUsed());
				System.out.println("적용 가능한 카테고리: " + coupon.getCategory());
				System.out.println("---------------");
			}
		} else {
			System.out.println("쿠폰이 없거나 조회 중 오류가 발생했습니다.");
		}

		// 쿠폰추가
//		couponDTO.setSearchCondition("쿠폰추가");
//		couponDTO.setMID("teemo");
//		couponDTO.setCpName("테스트 쿠폰");
//		couponDTO.setDiscount(30);
//		couponDTO.setCategory("간");
//		boolean flag = couponDAO.insert(couponDTO);
//		System.out.println(flag);

		// 아이디 중복검사
//		memberDTO.setMid("teemo");
//		memberDTO.setSearchCondition("아이디중복검사");
//		System.out.println(memberDAO.selectOne(memberDTO).toString());

		// 로그인
//		memberDTO.setSearchCondition("로그인");
//		memberDTO.setMid("teemo"); // 실제 아이디로 변경해야 합니다.
//		memberDTO.setmPassword("1234"); // 실제 비밀번호로 변경해야 합니다.
//		System.out.println(memberDAO.selectOne(memberDTO));
	}

}
