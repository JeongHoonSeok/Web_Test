package lastPJ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import test.JDBCUtil;
import test.dto.CouponDTO;

public class LastCouponDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	
	// 마이페이지에서 보유한 쿠폰을 보여주는 쿼리
	// 쿠폰 테이블에서 해당 회원의 쿠폰 전부를 선택
	private static final String SELECTALL_COUPON_MYPAGE = "SELECT CP_ID, M_ID, CP_NAME, PERIOD, DISCOUNT, CATEGORY, USED "
			+ "FROM COUPON "
			+ "WHERE M_ID = ? "
			+ "ORDER BY USED DESC, PERIOD ASC";

	// 상품 구매할 때 사용 가능한 쿠폰을 보여주는 쿼리
	// 해당 회원의 쿠폰 중 미사용한 쿠폰만 선택
	private static final String SELECTALL_USECP = "SELECT CP_ID, M_ID, CP_NAME, PERIOD, DISCOUNT, CATEGORY, USED "
			+ "FROM COUPON "
			+ "WHERE M_ID = ? AND USED = '미사용' "
			+ "ORDER BY PERIOD ASC";
	
	// 쿠폰 하나의 상세정보는 사용하지 않는다
	// private static final String SELECTONE = "";
	
	
	// (관) 사용자에게 쿠폰을 지급하는 관리자 기능
	// 유효기간을 지정해서 부여한다
	 private static final String INSERT = "INSERT INTO COUPON (CP_ID, M_ID, CP_NAME, PERIOD, DISCOUNT, CATEGORY) "	 
			+ "	VALUES ("
			+ "?, "
			+ "?, "
			+ "?, "
			+ "SYSTIMESTAMP + INTERVAL '30' DAY, "
			+ "?, "
			+ "?)";
	// --현재시간 +30일----SYSTIMESTAMP + INTERVAL '30' DAY--
	// --현재시간 +1시간----SYSTIMESTAMP + INTERVAL '1' HOUR--
	// --현재시간 +5분----SYSTIMESTAMP + INTERVAL '5' MINUTE--
	// --현재시간 +30초----SYSTIMESTAMP + INTERVAL '30' SECOND--

	// 회원이 쿠폰을 사용해서 결재를 했을 때 쿠폰의 사용여부를 변경하는 쿼리
	// 해당 쿠폰의 사용여부를 '사용'으로 변경한다
	private static final String UPDATE = "UPDATE COUPON SET USED = '사용' WHERE CP_ID = ?";

	// 미사용 쿠폰 중 유효기간이 지난 쿠폰을 삭제한다
	private static final String DELETE = "DELETE FROM COUPON WHERE USED = '미사용' AND PERIOD < SYSTIMESTAMP";

	public ArrayList<CouponDTO> selectAll(CouponDTO cpDTO) {

		// 회원에게 보여줄 쿠폰들을 저장해서 반환할 리스트 객체 정의
		ArrayList<CouponDTO> couponList = null;
		// 리스트에 저장할 쿠폰 객체 정의
		CouponDTO couponDTO = null;

		// DB 연결
		conn = JDBCUtil.connect();

		if (cpDTO.getSearchCondition().equals("쿠폰목록")) {
			
			System.out.println("[로그_쿠폰목록] 진입");
			
			couponList = new ArrayList<>();		

			try {
				pstmt = conn.prepareStatement(SELECTALL_COUPON_MYPAGE);
				pstmt.setString(1, cpDTO.getMID());

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					
					couponDTO = new CouponDTO();
					
					couponDTO.setPeriod(rs.getTimestamp("PERIOD"));

					SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

					String period = timeFormat.format(couponDTO.getPeriod());
					
					couponDTO.setCPID(rs.getString("CP_ID"));
					couponDTO.setMID(rs.getString("M_ID"));
					couponDTO.setCpName(rs.getString("CP_NAME"));
					couponDTO.setPeriod(rs.getTimestamp("PERIOD"));
					couponDTO.setAncPeriod(period);
					couponDTO.setDiscount(rs.getInt("DISCOUNT"));
					couponDTO.setCategory(rs.getString("CATEGORY"));
					couponDTO.setUsed(rs.getString("USED"));
					couponList.add(couponDTO);
				}
				System.out.println("[로그_쿠폰목록] "+couponList.size());
				if (couponList.size() > 0) {
					System.out.println("[로그_쿠폰목록] 성공");
					return couponList;
				}

					rs.close();

			} catch (SQLException e) {
				System.out.println("[로그_쿠폰목록] 예외처리");
				e.printStackTrace();
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		else if (cpDTO.getSearchCondition().equals("사용가능쿠폰")) {
			System.out.println("[로그_사용가능쿠폰] 진입");
			couponList = new ArrayList<>();

			try {
				pstmt = conn.prepareStatement(SELECTALL_USECP);
				pstmt.setString(1, cpDTO.getMID());

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					
					couponDTO = new CouponDTO();
					
					couponDTO.setPeriod(rs.getTimestamp("PERIOD"));

					SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

					String period = timeFormat.format(couponDTO.getPeriod());
					
					couponDTO.setCPID(rs.getString("CP_ID"));
					couponDTO.setMID(rs.getString("M_ID"));
					couponDTO.setCpName(rs.getString("CP_NAME"));
					couponDTO.setPeriod(rs.getTimestamp("PERIOD"));
					couponDTO.setAncPeriod(period);
					couponDTO.setDiscount(rs.getInt("DISCOUNT"));
					couponDTO.setCategory(rs.getString("CATEGORY"));
					couponDTO.setUsed(rs.getString("USED"));
					couponList.add(couponDTO);
				}
				System.out.println("[로그_사용가능쿠폰] "+couponList.size());
				if (couponList.size() > 0) {
					System.out.println("[로그_사용가능쿠폰] 성공");
					return couponList;
				}

					rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		System.out.println("[로그_쿠폰SelectAll] 실패");
		return null;
	}

	public CouponDTO selectOne(CouponDTO cpDTO) {
		return null;
	}

	public boolean insert(CouponDTO cpDTO) {

		conn = JDBCUtil.connect();

		if (cpDTO.getSearchCondition().equals("쿠폰추가")) {

			int couponLength = 10;

			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

			// 랜덤 쿠폰 번호 생성을 위한 StringBuilder 초기화
			StringBuilder couponCode = new StringBuilder(couponLength);

			Random rand = new Random();

			for (int i = 0; i < couponLength; i++) {

				int randomIndex = rand.nextInt(characters.length());

				char randomChar = characters.charAt(randomIndex);

				couponCode.append(randomChar);
			}

			System.out.println("[로그] 생성된 쿠폰번호 " + couponCode.toString());

			try {
				pstmt = conn.prepareStatement(INSERT);
				pstmt.setString(1, couponCode.toString());
				pstmt.setString(2, cpDTO.getMID());
				pstmt.setString(3, cpDTO.getCpName());
				pstmt.setInt(4, cpDTO.getDiscount());
				pstmt.setString(5, cpDTO.getCategory());
				System.out.println("[로그_쿠폰추가] pstmt 완료");

				int rs = pstmt.executeUpdate();

				System.out.println("[로그_쿠폰추가] SQL문 실행완료");

				if (rs <= 0) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		return true;
	}

	public boolean update(CouponDTO cpDTO) {
		
		conn = JDBCUtil.connect();
		
		if(cpDTO.getSearchCondition().equals("쿠폰사용")) {
			
			try {
				pstmt = conn.prepareStatement(UPDATE);
				pstmt.setString(1, cpDTO.getCPID());
				
				int result = pstmt.executeUpdate();
				
				if(result > 0) {
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

	public boolean delete(CouponDTO cpDTO) {
		
		conn = JDBCUtil.connect();
		
		if(cpDTO.getSearchCondition().equals("쿠폰삭제")) {
			
			try {
				pstmt = conn.prepareStatement(DELETE);
				
				int result = pstmt.executeUpdate();
				System.out.println("[로그_쿠폰삭제] "+result);
				if(result > 0) {
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
