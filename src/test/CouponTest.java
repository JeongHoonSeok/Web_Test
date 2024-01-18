package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CouponTest {

	public static void main(String[] args) {
		
		CouponDTO couponDTO = new CouponDTO();
		CouponDAO couponDAO = new CouponDAO();
		

        // 쿠폰추가	
		couponDTO.setSearchCondition("쿠폰추가");
		couponDTO.setMID("teemo");
		couponDTO.setCpName("테스트 쿠폰");
		couponDTO.setDiscount(30);
		couponDTO.setCategory("간");

		boolean flag = couponDAO.insert(couponDTO);
		System.out.println(flag);
		
		
		// 아이디 중복검사
//		memberDTO.setMid("teemo");
//		memberDTO.setSearchCondition("아이디중복검사");
//		System.out.println(memberDAO.selectOne(memberDTO).toString());
		
		
		//로그인
//		memberDTO.setSearchCondition("로그인");
//		memberDTO.setMid("teemo"); // 실제 아이디로 변경해야 합니다.
//		memberDTO.setmPassword("1234"); // 실제 비밀번호로 변경해야 합니다.
//		System.out.println(memberDAO.selectOne(memberDTO));
	}

}
