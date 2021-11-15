package co.seung.mybatis.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.command.HomeCommand;
import co.seung.mybatis.command.MemberJoin;
import co.seung.mybatis.command.MemberJoinForm;
import co.seung.mybatis.command.MemberLogin;
import co.seung.mybatis.command.MemberLoginForm;
import co.seung.mybatis.command.MemberLogout;
import co.seung.mybatis.command.MemberSelectList;
import co.seung.mybatis.command.MemberSelfInfo;
import co.seung.mybatis.command.NoticeDelete;
import co.seung.mybatis.command.NoticeDeleteSelected;
import co.seung.mybatis.command.NoticeEdit;
import co.seung.mybatis.command.NoticeForm;
import co.seung.mybatis.command.NoticeInsert;
import co.seung.mybatis.command.NoticeList;
import co.seung.mybatis.command.NoticeSearch;
import co.seung.mybatis.command.NoticeSelect;
import co.seung.mybatis.command.MemberList;
import co.seung.mybatis.command.MemberSelect;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    public FrontController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());
		//
		map.put("/memberList.do", new MemberList());
		map.put("/memberSelect.do", new MemberSelect());
		map.put("/memberSelectList.do", new MemberSelectList());	
		map.put("/memberLoginForm.do", new MemberLoginForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogout.do", new MemberLogout());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberSelfInfo.do", new MemberSelfInfo());
		//
		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeSelect.do", new NoticeSelect());
		map.put("/noticeForm.do", new NoticeForm());
		map.put("/noticeInsert.do",	new NoticeInsert());	
		map.put("/noticeDelete.do",	new NoticeDelete());
		map.put("/noticeDeleteSelected.do",	new NoticeDeleteSelected());
		map.put("/noticeEdit.do", new NoticeEdit());
		map.put("/noticeSearch.do", new NoticeSearch());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		if(viewPage != "noticeList.do") {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		}
		if(viewPage == "noticeList.do") {
			response.sendRedirect(viewPage);
		}
	}

}
