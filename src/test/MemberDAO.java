package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	/*
	 * 기능 1) 회원목록보기? 관리자가 회원목록을 보나? 2-1) 로그인 사용자가 입력한 id와 pw가 같은 행에 일치하는지 확인 2-2)
	 * 추천알고리즘 로그인한 회원의 mid와 일치하는 행의 건강상태 속성값을 가져와서 사용 2-3) 추천알고리즘 로그인한 회원의 mid와 일치하는
	 * 행의 건강상태 속성값을 가져와서 사용 2-4) 회원가입 시 아이디 중복확인 기능 3) 회원가입 회원가입 4) 회원정보 변경 5) 회원탈퇴
	 */

	// (관) 회원목록
	private static final String SELECTALL = "";

	// 로그인
	private static final String SELECTONE_LOGIN = "SELECT M_ID, M_NAME, DOB, GENDER, GRADE, HEALTH "
			+ "FROM MEMBER WHERE M_ID=? AND M_PASSWORD = ?";

	// 마이페이지(이름, 생년월일, 성별, 전화번호, 이메일, 주소)
	private static final String SELECTONE_MYPAGE = "SELECT M_NAME, DOB, GENDER, PHONE_NUMBER, EMAIL, M_POSTCODE, M_ADDRESS, M_DETAILED_ADDRESS "
			+ "FROM MEMBER WHERE M_ID=? AND M_PASSWORD = ?";

	// 아이디 중복검사
	private static final String SELECTONE_ID_CHECK = "SELECT M_ID FROM MEMBER WHERE M_ID=?";

	// 회원 건강상태
	private static final String SELECTONE_HEALTH = "SELECT HEALTH FROM MEMBER WHERE M_ID=?";
	
	// 회원 주문정보
	private static final String SELECTONE_BUYPAGE = "SELECT M_NAME, PHONE_NUMBER, M_POSTCODE, M_ADDRESS, M_DETAILED_ADDRESS, EMAIL FROM MEMBER WHERE M_ID=?";

	// 회원가입
	private static final String INSERT = "INSERT INTO "
			+ "MEMBER (M_ID, M_NAME, M_PASSWORD, DOB, GENDER, PHONE_NUMBER, EMAIL, M_POSTCODE, M_ADDRESS, M_DETAILED_ADDRESS, GRADE, HEALTH) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'USER', ?)";

	// 개인정보변경(이름, 생년월일, 성별, 전화번호, 이메일, 주소)
	private static final String UPDATE_INFO = "UPDATE MEMBER "
			+ "SET "
			+ "M_NAME=?, "
			+ "DOB=?, "
			+ "GENDER=?, "
			+ "PHONE_NUMBER=?, "
			+ "EMAIL=?, "
			+ "M_POSTCODE=?, "
			+ "M_ADDRESS=?, "
			+ "M_DETAILED_ADDRESS=? "
			+ "WHERE M_ID=?";

	// 비밀번호번경
	private static final String UPDATE_PW = "UPDATE MEMBER SET M_PASSWORD=? WHERE M_ID=?";

	// 회원탈퇴
	private static final String DELETE = "DELETE FROM MEMBER WHERE M_ID = ?";

	public MemberDTO selectOne(MemberDTO mDTO) {

		MemberDTO memberDTO = null;
		
		conn = JDBCUtil.connect();

		if (mDTO.getSearchCondition().equals("아이디중복검사")) {

			memberDTO = new MemberDTO();			

			try {
				pstmt = conn.prepareStatement(SELECTONE_ID_CHECK);
				pstmt.setString(1, mDTO.getMID());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					memberDTO.setMID(rs.getString("M_ID"));
				} else {
					memberDTO = null;
				}

				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[로그_아이디중복검사] 반환 NULL_예외처리");
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			if (memberDTO != null) {
				System.out.println("[로그_아이디중복검사] 성공");
				return memberDTO;
			}
		}

		else if (mDTO.getSearchCondition().equals("로그인")) {
			memberDTO = new MemberDTO();

			try {
				pstmt = conn.prepareStatement(SELECTONE_LOGIN);
				pstmt.setString(1, mDTO.getMID());
				pstmt.setString(2, mDTO.getmPassword());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					memberDTO.setMID(rs.getString("M_ID"));
					memberDTO.setmName(rs.getString("M_NAME"));
					memberDTO.setDob(rs.getDate("DOB"));
					memberDTO.setGender(rs.getString("GENDER"));
					memberDTO.setGrade(rs.getString("GRADE"));
					memberDTO.setHealth(rs.getString("HEALTH"));
				} else {
					memberDTO = null;
				}

				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[로그_로그인] 반환 NULL_예외처리");
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			if (memberDTO != null) {
				System.out.println("[로그_로그인] 성공");
				return memberDTO;
			}
		}
		else if (mDTO.getSearchCondition().equals("회원정보")) {
			memberDTO = new MemberDTO();

			try {
				pstmt = conn.prepareStatement(SELECTONE_MYPAGE);
				pstmt.setString(1, mDTO.getMID());
				pstmt.setString(2, mDTO.getmPassword());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					memberDTO.setmName(rs.getString("M_NAME"));
					memberDTO.setDob(rs.getDate("DOB"));
					memberDTO.setGender(rs.getString("GENDER"));
					memberDTO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					memberDTO.setEmail(rs.getString("EMAIL"));
					memberDTO.setmPostCode(rs.getInt("M_POSTCODE"));
					memberDTO.setmAddress(rs.getString("M_ADDRESS"));
					memberDTO.setmDetailedAddress(rs.getString("M_DETAILED_ADDRESS"));
				} else {
					memberDTO = null;
				}

				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[로그_회원정보] 반환 NULL_예외처리");
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			if (memberDTO != null) {
				System.out.println("[로그_회원정보] 성공");
				return memberDTO;
			}
		}

		else if (mDTO.getSearchCondition().equals("건강상태")) {
			memberDTO = new MemberDTO();

			try {
				pstmt = conn.prepareStatement(SELECTONE_HEALTH);
				pstmt.setString(1, mDTO.getMID());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					memberDTO.setHealth(rs.getString("HEALTH"));
					System.out.println("[로그_건강상태] rs.next성공");
				} else {
					memberDTO = null;
				}

				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[로그_건강상태] 반환 NULL_예외처리");
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			if (memberDTO != null) {
				System.out.println("[로그_건강상태] 성공");
				return memberDTO;
			}
		} else if(mDTO.getSearchCondition().equals("주문정보")) {
			
			memberDTO = new MemberDTO();
			
			try {
				pstmt = conn.prepareStatement(SELECTONE_BUYPAGE);
				pstmt.setString(1, mDTO.getMID());
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					memberDTO.setmName(rs.getString("M_NAME"));
					memberDTO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					memberDTO.setmPostCode(rs.getInt("M_POSTCODE"));
					memberDTO.setmAddress(rs.getString("M_ADDRESS"));
					memberDTO.setmDetailedAddress(rs.getString("M_DETAILED_ADDRESS"));
					memberDTO.setEmail(rs.getString("EMAIL"));
				} else {
					memberDTO = null;
				}
				
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[로그_주문정보] 반환 NULL_예외처리");
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			
			if(memberDTO != null) {
				System.out.println("[로그_주문정보] 성공");
				return memberDTO;
			}
			
		}
		System.out.println("[로그_SelectOne] 반환 NULL");
		return null;
	}

	public boolean insert(MemberDTO mDTO) {
		
		conn = JDBCUtil.connect();
		
		if (mDTO.getSearchCondition().equals("회원가입")) {
			
			try {
				pstmt = conn.prepareStatement(INSERT);
				pstmt.setString(1, mDTO.getMID());
				pstmt.setString(2, mDTO.getmName());
				pstmt.setString(3, mDTO.getmPassword());
				pstmt.setDate(4, mDTO.getDob());
				pstmt.setString(5, mDTO.getGender());
				pstmt.setString(6, mDTO.getPhoneNumber());
				pstmt.setString(7, mDTO.getEmail());
				pstmt.setInt(8, mDTO.getmPostCode());
				pstmt.setString(9, mDTO.getmAddress());
				pstmt.setString(10, mDTO.getmDetailedAddress());
				pstmt.setString(11, mDTO.getHealth());
				int result = pstmt.executeUpdate();
				
				if (result > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		return false;
	}

	// 회원정보 변경
	public boolean update(MemberDTO mDTO) {

		conn = JDBCUtil.connect();

		if (mDTO.getSearchCondition().equals("회원정보변경")) {
			System.out.println("[로그_회원정보변경] 진입");

			try {
				pstmt = conn.prepareStatement(UPDATE_INFO);
				pstmt.setString(1, mDTO.getmName());
				pstmt.setDate(2, mDTO.getDob());
				pstmt.setString(3, mDTO.getGender());
				pstmt.setString(4, mDTO.getPhoneNumber());
				pstmt.setString(5, mDTO.getEmail());
				pstmt.setInt(6, mDTO.getmPostCode());
				pstmt.setString(7, mDTO.getmAddress());
				pstmt.setString(8, mDTO.getmDetailedAddress());
				pstmt.setString(9, mDTO.getMID());

				int result = pstmt.executeUpdate();
				System.out.println("[로그_회원정보변경] execute완료");

				if (result > 0) {
					System.out.println("[로그_회원정보변경] 변경성공");
					return true;
				}

			} catch (SQLException e) {
				System.out.println("[로그_회원정보변경] 예외처리");
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}

		else if (mDTO.getSearchCondition().equals("비밀번호변경")) {
			System.out.println("[로그_비밀번호변경] 진입");

			try {
				// 이름, 생년월일, 성별, 전화번호, 이메일, 주소
				pstmt = conn.prepareStatement(UPDATE_PW);
				pstmt.setString(1, mDTO.getmPassword());
				pstmt.setString(2, mDTO.getMID());

				int result = pstmt.executeUpdate();

				System.out.println("[로그_비밀번호변경] execute완료");

				if (result > 0) {
					System.out.println("[로그_비밀번호변경] 변경성공");
					return false;
				}

			} catch (SQLException e) {
				System.out.println("[로그_비밀번호변경] 예외처리");
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		System.out.println("[로그_회원정보변경] 실패");
		return false;
	}

	// 회원탈퇴
	public boolean delete(MemberDTO mDTO) {

		conn = JDBCUtil.connect();

		if (mDTO.getSearchCondition().equals("회원탈퇴")) {

			try {
				pstmt = conn.prepareStatement(DELETE);
				pstmt.setString(1, mDTO.getMID());

				int result = pstmt.executeUpdate();

				if (result > 0) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}

		}
		return false;
	}
}