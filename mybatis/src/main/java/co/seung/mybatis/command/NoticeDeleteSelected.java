package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.notice.service.NoticeService;
import co.seung.mybatis.notice.service.NoticeVO;
import co.seung.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeDeleteSelected implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String nidString = request.getParameter("nid");
//		System.out.println(nidString);
//		vo.setNidString(nidString);
		
		String[] array = nidString.split(",");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		vo.setArray(array);
		noticeDAO.noticeDeleteSelected(vo);

		return "noticeList.do";
	}

}
