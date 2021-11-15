package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.notice.service.NoticeService;
import co.seung.mybatis.notice.service.NoticeVO;
import co.seung.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSearch implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String method = request.getParameter("method");
		String keyword = request.getParameter("keyword");
		
		
		if(method.equals("글번호")) {
			System.out.println(method);
			System.out.println(keyword);
			
			vo.setNid(Integer.parseInt(keyword));
			request.setAttribute("notices", noticeDAO.noticeSelectByNid(vo));
			
		} else if(method.equals("제목")) {
			System.out.println(method);
			System.out.println(keyword);
			
			vo.setTitle(keyword);
			request.setAttribute("notices", noticeDAO.noticeSelectByTitle(vo));
		}
		
		return "notice/noticeList";
	}

}
