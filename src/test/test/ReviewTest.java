package test.test;

import java.util.ArrayList;

import test.dao.ReviewDAO;
import test.dto.ReviewDTO;

public class ReviewTest {
	
	public static void main(String[] args) {
		
		ReviewDTO reviewDTO = new ReviewDTO();
		ReviewDAO reviewDAO = new ReviewDAO();
		ArrayList<ReviewDTO> Reviews = new ArrayList<>();		

		//리뷰 삭제
//        reviewDTO.setSearchCondition("리뷰삭제");
//        reviewDTO.setRID(1);
//		boolean result = reviewDAO.delete(reviewDTO);
//        if (result) {
//            System.out.println("리뷰가 성공적으로 삭제되었습니다.");
//        } else {
//            System.out.println("리뷰 삭제에 실패하였습니다.");
//        }
		
		//리뷰작성
//		reviewDTO.setSearchCondition("리뷰작성");
//        reviewDTO.setMID("YUMI");
//        reviewDTO.setBID(1);
//        reviewDTO.setScore(5);
//        reviewDTO.setContents("좋아요!");
//        boolean result = reviewDAO.insert(reviewDTO);
//        if (result) {
//            System.out.println("리뷰가 성공적으로 추가되었습니다.");
//        } else {
//            System.out.println("리뷰 추가에 실패하였습니다.");
//        }
	
        // 리뷰상세
//        reviewDTO.setSearchCondition("리뷰상세");
//        reviewDTO.setRID(1);
//        
//        reviewDTO = reviewDAO.selectOne(reviewDTO);
//        if (reviewDTO != null) {
//            System.out.println("조회된 리뷰 정보:");
//            System.out.println("리뷰 ID: " + reviewDTO.getRID());
//            System.out.println("회원 ID: " + reviewDTO.getMID());
//            System.out.println("구매 번호: " + reviewDTO.getBID());
//            System.out.println("별점: " + reviewDTO.getScore());
//            System.out.println("리뷰 내용: " + reviewDTO.getContents());
//            System.out.println("작성 시간: " + reviewDTO.getCreateTime());
//            System.out.println("상품 ID: " + reviewDTO.getPID());
//            System.out.println("상품 이름: " + reviewDTO.getpNAME());
//            System.out.println("회원 이름: " + reviewDTO.getmName());
//        } else {
//            System.out.println("리뷰를 찾을 수 없습니다.");
//        }
		
		
		// 리뷰조회
//		reviewDTO.setSearchCondition("내리뷰");
//		reviewDTO.setMID("teemo");
//		reviewDTO.setSearchCondition("상품리뷰");
//		reviewDTO.setPID(1);
//		Reviews = reviewDAO.selectAll(reviewDTO);
//		if (Reviews != null) {
//			for (ReviewDTO review : Reviews) {
//				System.out.println("리뷰 ID: " + review.getRID());
//				System.out.println("작성자: " + review.getMID());
//				System.out.println("구매번호: " + review.getBID());
//				System.out.println("별점: " + review.getScore());
//				System.out.println("리뷰 내용: " + review.getContents());
//				System.out.println("작성일: " + review.getCreateTime());
//				System.out.println("상품 ID: " + review.getPID());
//				System.out.println("상품 이름 :"+review.getpNAME());
//				System.out.println("---------------------------");
//			}
//		} else {
//			System.out.println("리뷰가 없습니다.");
//		}				
	}
}
