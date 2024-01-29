package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemberTest {

	public static void main(String[] args) {

		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		// 비밀번호 확인
//		memberDTO.setSearchCondition("비밀번호확인");
//		memberDTO.setMID("teemo");
//		memberDTO.setmPassword("1234");
//		memberDTO = memberDAO.selectOne(memberDTO);
//		if(memberDTO != null) {
//			System.out.println("비빌번호 확인 성공 : "+memberDTO.getmPassword());
//		} else {
//			System.out.println("실패");
//		}
		
		
		//회원 주문정보
		memberDTO.setSearchCondition("주문정보");
		memberDTO.setMID("teemo");
		memberDTO = memberDAO.selectOne(memberDTO);
		if(memberDTO != null) {
			System.out.println("이름 : "+memberDTO.getmName());
			System.out.println("전화번호 : "+memberDTO.getPhoneNumber());
			System.out.println("주소 : "+memberDTO.getmPostCode()+" "+memberDTO.getmAddress()+" "+memberDTO.getmDetailedAddress());		
			System.out.println("메일 : "+memberDTO.getEmail());
			System.out.println("_______________________________________________________");
		}

		// 아이디 중복검사
//		memberDTO.setMid("teemo");
//		memberDTO.setSearchCondition("건강상태");
//		String health = memberDAO.selectOne(memberDTO).getHealth();
//		System.out.println("건강상태 : "+health);

		// 아이디 중복검사
//		memberDTO.setMid("teemo");
//		memberDTO.setSearchCondition("아이디중복검사");
//		System.out.println(memberDAO.selectOne(memberDTO).toString());

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

		// 로그인
//		memberDTO.setSearchCondition("로그인");
//		memberDTO.setMid("teemo");
//		memberDTO.setmPassword("1234");
//		System.out.println(memberDAO.selectOne(memberDTO));
		
		//회원정보
//		memberDTO.setSearchCondition("회원정보");
//		memberDTO.setMID("teemo");
//		memberDTO.setmPassword("1234");
//		System.out.println(memberDAO.selectOne(memberDTO));

		// 회원정보 변경
//		Date dob = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			java.util.Date utilDate = sdf.parse("2018-06-01");
//			dob = new java.sql.Date(utilDate.getTime());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		memberDTO.setSearchCondition("회원정보변경");
//		memberDTO.setmName("티모");
//		memberDTO.setDob(dob);
//		memberDTO.setGender("남");
//		memberDTO.setPhoneNumber("010-2525-2525");
//		memberDTO.setEmail("teemo@gamil.com");
//		memberDTO.setmPostCode(9999);
//		memberDTO.setmAddress("호암로24길 16 동남빌딩");
//		memberDTO.setmDetailedAddress("5022호");
//		memberDTO.setMid("teemo");
//		boolean flag = memberDAO.update(memberDTO);
//		if (flag == true) {
//			System.out.println("회원정보 변경완료");
//		} else {
//			System.out.println("회원정보 변경실패");
//		}
		
		
		
	}

}
