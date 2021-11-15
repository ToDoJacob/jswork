package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.notice.service.NoticeService;
import co.seung.mybatis.notice.service.NoticeVO;
import co.seung.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEdit implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setTitle(request.getParameter("title"));
		vo.setNid(Integer.parseInt(request.getParameter("nid")));
		vo.setContents(request.getParameter("contents"));
		noticeDAO.noticeUpdate(vo);
		return "noticeList.do";
	}

}
