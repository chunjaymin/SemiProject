package action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;

public class Test2_infoAction implements CommandAction {//글 목록 처리
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");*/
		
		// 파라미터 값 저장
		int storeNo = Integer.parseInt(request.getParameter("store_no"));
		
		System.out.println("storeNo:::"+storeNo); // 값 넘어옴
		
		List articleList = null;
		BoardDBBean dbPro = BoardDBBean.getInstance();

		// 모든 검색에 사용하는 데이터를 searchList에 저장
		List searchList = new ArrayList();

		// 점포번호를 가지고 검색하는 메서드 실행
		articleList = dbPro.getInfo(storeNo);

		//해당 뷰에서 사용할 속성
		request.setAttribute("articleList", articleList);
		
		return "/test2_info.jsp";//해당 뷰
	}
}
