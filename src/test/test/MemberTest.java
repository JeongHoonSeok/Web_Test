package test.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import test.dao.MemberDAO;
import test.dto.MemberDTO;

public class MemberTest {

	public static void main(String[] args) {

		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		// 회원정보
//		memberDTO.setSearchCondition("회원정보");
//		memberDTO.setMID("teemo");
//		memberDTO = memberDAO.selectOne(memberDTO);
//		
//		if(memberDTO != null) {
//			System.out.println("회원이름 : "+memberDTO.getmName());
//			System.out.println("생년월일 : "+memberDTO.getDob());
//			System.out.println("전화번호 : "+memberDTO.getPhoneNumber());
//			System.out.println("메일주소 : "+memberDTO.getEmail());
//			System.out.println("우편번호 : "+memberDTO.getmPostCode());
//			System.out.println("일반주소 : "+memberDTO.getmAddress());
//			System.out.println("상세주소 : "+memberDTO.getmDetailedAddress());
//			System.out.println("건강상태 : "+memberDTO.getHealth());
//		} else {
//			System.out.println("없는 회원 또는 오류가 발생하였습니다");
//		}
		
		
		// 비밀번호 확인
//		memberDTO.setSearchCondition("비밀번호확인");
//		memberDTO.setMID("teemo");
//		memberDTO.setmPassword("1234");
//		memberDTO = memberDAO.selectOne(memberDTO);
//		if(memberDTO != null) {
//			System.out.println("회원ID : "+memberDTO.getMID());
//			System.out.println("회원이름 : "+memberDTO.getmName());
//		} else {
//			System.out.println("실패");
//		}
		
		
		// 비밀번호변경
//		memberDTO.setSearchCondition("비밀번호변경");
//		memberDTO.setMID("teemo");
//		memberDTO.setmPassword("1234");
//		boolean result = memberDAO.update(memberDTO);
//		if(result == true) {
//			System.out.println("비밀번호 변경 성공");
//		} else {
//			System.out.println("비밀번호 변경 실패");
//		}
		
		
		//회원 주문정보
//		memberDTO.setSearchCondition("주문정보");
//		memberDTO.setMID("teemo");
//		memberDTO = memberDAO.selectOne(memberDTO);
//		if(memberDTO != null) {
//			System.out.println("이름 : "+memberDTO.getmName());
//			System.out.println("전화번호 : "+memberDTO.getPhoneNumber());
//			System.out.println("주소 : "+memberDTO.getmPostCode()+" "+memberDTO.getmAddress()+" "+memberDTO.getmDetailedAddress());		
//			System.out.println("메일 : "+memberDTO.getEmail());
//			System.out.println("_______________________________________________________");
//		}

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
		Date dob = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse("2018-06-01");
            dob = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }		
        memberDTO.setSearchCondition("회원가입");
		memberDTO.setMID("Ari");
		memberDTO.setmName("아리");
		memberDTO.setmPassword("1234");
		memberDTO.setDob(dob);
		memberDTO.setGender("여");
		memberDTO.setPhoneNumber("010-2525-2525");
		memberDTO.setEmail("Ari@gmail.com");
		memberDTO.setmPostCode(99999);
		memberDTO.setmAddress("관악구 신림동");
		memberDTO.setmDetailedAddress("군숙소");
		memberDTO.setGrade("USER");
		memberDTO.setHealth("눈");
		memberDTO.setLoginType(null);
		memberDTO.setKakaoId(null);
		boolean flag = memberDAO.insert(memberDTO);
		System.out.println(flag);

		// 로그인
//		memberDTO.setSearchCondition("로그인");
//		memberDTO.setMID("teemo");
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
