package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seung.mybatis.comm.Command;

public class MemberLogout implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		String id1 = String.valueOf(request.getAttribute("id"));
		System.out.println(id1);
		request.setAttribute("id", null);
		
		HttpSession session = request.getSession();
		String id2 = String.valueOf(session.getAttribute("id"));
		System.out.println(id2);
		session.invalidate();
		return "home.do";
	}

}
