package test;

public class ProductTest {

	public static void main(String[] args) {

		ProductDAO productDAO = new ProductDAO();
		ProductDTO productDTO = new ProductDTO();

		// 상품추가
		productDTO.setpName("테스트 페이지 새로운 제품");
		productDTO.setCostPrice(10000);
		productDTO.setRegularPrice(15000);
		productDTO.setSellingPrice(12000);
		productDTO.setpQty(50);
		productDTO.setIngredient("새로운 성분");
		productDTO.setCategory("새로운 카테고리");
		productDTO.setSellingState("판매중");
		productDTO.setImagePath("이미지 경로");
		productDTO.setSearchCondition("상품추가");

		boolean isSuccess = productDAO.insert(productDTO);
		if (isSuccess) {
			System.out.println("제품 추가 성공");
		} else {
			System.out.println("제품 추가 실패");
		}
	}

}
