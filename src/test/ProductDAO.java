package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	/*
	 * 기능 1) 제품목록 보기 2) 제품상세 보기 3) 제품추가 4) 제품 정보 변경 판매중단은 있고 삭제는 없음 5) X 제품 삭제
	 */

	// 제품선택(페이지)
	private static final String SELECTALL_PAGE = "SELECT P_ID, P_NAME, P_DETAIL, COST_PRICE, REGULAR_PRICE, SELLING_PRICE, P_QTY, INGREDIENT, CATEGORY, REG_TIME, SELLING_STATE, IMAGEPATH "
			+ "FROM ("
			+ "    SELECT P_ID, P_NAME, P_DETAIL, COST_PRICE, REGULAR_PRICE, SELLING_PRICE, P_QTY, INGREDIENT, CATEGORY, REG_TIME, SELLING_STATE, IMAGEPATH, ROWNUM AS RN "
			+ "    FROM PRODUCT " + "WHERE SELLING_STATE = '판매중'" + ") " + "WHERE RN BETWEEN ? AND ?";

	// 제품전체
	private static final String SELECTALL_ALL = "SELECT P_ID, P_NAME, P_DETAIL, COST_PRICE, REGULAR_PRICE, SELLING_PRICE, P_QTY, INGREDIENT, CATEGORY, REG_TIME, SELLING_STATE, IMAGEPATH "
			+ "FROM PRODUCT";

	private static final String SELECTONE = "";

	//성공한 Insert
	private static final String INSERT = "INSERT INTO PRODUCT "
			+ "(P_ID, P_NAME, P_DETAIL, COST_PRICE, REGULAR_PRICE, SELLING_PRICE, P_QTY, INGREDIENT, CATEGORY, REG_TIME, SELLING_STATE, IMAGEPATH) "
			+ "	VALUES ( "
			+ "	  NVL((SELECT MAX(P_ID) FROM PRODUCT), 0) + 1, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  ?, "
			+ "	  SYSTIMESTAMP, "
			+ "	  ?, "
			+ "	  ? "
			+ "	)";		
	
	private static final String UPDATE = "";

	private static final String DELETE = "";

	public ArrayList<ProductDTO> selectAll(ProductDTO pDTO) {

		ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();

		if (pDTO.getSearchCondition().equals("상품목록페이지")) {

			conn = JDBCUtil.connect();

			try {
				pstmt = conn.prepareStatement(SELECTALL_PAGE);
				pstmt.setInt(1, pDTO.getAncSelectMin());
				pstmt.setInt(2, pDTO.getAncSelectMax());

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					if (productList == null) {
						productList = new ArrayList<ProductDTO>(); // productList가 null인 경우에만 객체 생성
					}
					ProductDTO productTempDTO = new ProductDTO();
					productTempDTO.setPID(rs.getInt("P_ID"));
					productTempDTO.setpName(rs.getString("P_NAME"));
					productTempDTO.setCostPrice(rs.getInt("COST_PRICE"));
					productTempDTO.setRegularPrice(rs.getInt("REGULAR_PRICE"));
					productTempDTO.setSellingPrice(rs.getInt("SELLING_PRICE"));
					productTempDTO.setpQty(rs.getInt("P_QTY"));
					productTempDTO.setIngredient(rs.getString("INGREDIENT"));
					productTempDTO.setCategory(rs.getString("CATEGORY"));
					productTempDTO.setRegTime(rs.getTimestamp("REG_TIME"));
					productTempDTO.setSellingState(rs.getString("SELLING_STATE"));
					productTempDTO.setImagePath(rs.getString("IMAGEPATH"));
					productTempDTO.setpDetail(rs.getString("P_DETAIL"));
					productList.add(productTempDTO);
				}

				rs.close();

			} catch (SQLException e) {
				System.out.println("[로그_제품출력페이지] 오류발생");
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			if (productList != null) {
				System.out.println("[로그_제품출력페이지] 성공");
				return productList;
			}

		} else if (pDTO.getSearchCondition().equals("상품출력전체")) {

			conn = JDBCUtil.connect();

			try {
				pstmt = conn.prepareStatement(SELECTALL_ALL);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					if (productList == null) {
						productList = new ArrayList<ProductDTO>(); // productList가 null인 경우에만 객체 생성
					}
					ProductDTO productTempDTO = new ProductDTO();
					productTempDTO.setPID(rs.getInt("P_ID"));
					productTempDTO.setpName(rs.getString("P_NAME"));
					productTempDTO.setCostPrice(rs.getInt("COST_PRICE"));
					productTempDTO.setRegularPrice(rs.getInt("REGULAR_PRICE"));
					productTempDTO.setSellingPrice(rs.getInt("SELLING_PRICE"));
					productTempDTO.setpQty(rs.getInt("P_QTY"));
					productTempDTO.setIngredient(rs.getString("INGREDIENT"));
					productTempDTO.setCategory(rs.getString("CATEGORY"));
					productTempDTO.setRegTime(rs.getTimestamp("REG_TIME"));
					productTempDTO.setSellingState(rs.getString("SELLING_STATE"));
					productTempDTO.setImagePath(rs.getString("IMAGEPATH"));
					productTempDTO.setpDetail(rs.getString("P_DETAIL"));
					productList.add(productTempDTO);
				}

				rs.close();

			} catch (SQLException e) {
				System.out.println("[로그_제품출력페이지] 오류발생");
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			if (productList != null) {
				System.out.println("[로그_제품출력페이지] 성공");
				return productList;
			}

		}
		System.out.println("[로그_제품출력페이지] 실패");
		return null;
	}

	public ProductDTO selectOne(ProductDTO DTO) {
		return null;
	}

	public boolean insert(ProductDTO pDTO) {
		System.out.println("[로그] 추가 로직");

		conn = JDBCUtil.connect();
		
		if (pDTO.getSearchCondition().equals("상품추가")) {
			
			System.out.println("[로그] 제품추가 로직");
			
			try {
				System.out.println("[로그] 트라이 로직");
				pstmt = conn.prepareStatement(INSERT);
				pstmt.setString(1, pDTO.getpName());
				pstmt.setString(2, pDTO.getpDetail());
				pstmt.setInt(3, pDTO.getCostPrice());
				pstmt.setInt(4, pDTO.getRegularPrice());
				pstmt.setInt(5, pDTO.getSellingPrice());
				pstmt.setInt(6, pDTO.getpQty());
				pstmt.setString(7, pDTO.getIngredient());
				pstmt.setString(8, pDTO.getCategory());
				pstmt.setString(9, pDTO.getSellingState());
				pstmt.setString(10, pDTO.getImagePath());

				int result = pstmt.executeUpdate();
				
				System.out.println("[로그] 제품추가"+result);

				if (result <= 0) {
					return false;
				}

			} catch (SQLException e) {
				System.out.println("[로그] 예외처리");
				e.printStackTrace();
				return false;
			} finally {
				System.out.println("[로그] 연결종료");
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		System.out.println("[로그] 트루 반환");
		return true;
	}

	public boolean update(ProductDTO pDTO) {
		return false;
	}

	public boolean delete(ProductDTO pDTO) {
		return false;
	}
}