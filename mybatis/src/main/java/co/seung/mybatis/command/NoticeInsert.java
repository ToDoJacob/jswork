package co.seung.mybatis.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.notice.service.NoticeService;
import co.seung.mybatis.notice.service.NoticeVO;
import co.seung.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(request.getParameter("id"));
		vo.setContents(request.getParameter("contents"));
		vo.setTitle(request.getParameter("title"));
		vo.setName(request.getParameter("name"));
//		vo.setWriteDate(Date.valueOf(request.getParameter("writeDate")));
		String viewPage = null;
		try {
			noticeDAO.noticeInsert(vo);
		} catch (Exception e) {
			System.out.println(e);
			viewPage = "home.do";
			return viewPage;
		}
		viewPage = "noticeList.do";
		return viewPage;
	}

}
