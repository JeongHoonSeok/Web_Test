package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemberTest {

	public static void main(String[] args) {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		

		// 아이디 중복검사
		memberDTO.setMid("teemo");
		memberDTO.setSearchCondition("아이디중복검사");
		System.out.println(memberDAO.selectOne(memberDTO).toString());
		
        // 회원가입
//		Date dob = null;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date utilDate = sdf.parse("2018-06-01");
//            dob = new java.sql.Date(utilDate.getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }		
//		memberDTO.setMid("Ari");
//		memberDTO.setmName("아리");
//		memberDTO.setmPassword("1234");
//		memberDTO.setDob(dob);
//		memberDTO.setGender("여");
//		memberDTO.setPhoneNumber("010-2525-2525");
//		memberDTO.setEmail("Ari@gmail.com");
//		memberDTO.setPostCode(99999);
//		memberDTO.setAddress("관악구 신림동");
//		memberDTO.setDetailedAddress("군숙소");
//		memberDTO.setGrade("USER");
//		memberDTO.setHealth("눈");
//		memberDTO.setSearchCondition("회원가입");
//		boolean flag = memberDAO.insert(memberDTO);
//		System.out.println(flag);
		
		//로그인
//		memberDTO.setSearchCondition("로그인");
//		memberDTO.setMid("teemo"); // 실제 아이디로 변경해야 합니다.
//		memberDTO.setmPassword("1234"); // 실제 비밀번호로 변경해야 합니다.
//		System.out.println(memberDAO.selectOne(memberDTO));
	}

}
