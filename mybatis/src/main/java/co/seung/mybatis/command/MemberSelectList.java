package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.member.service.MemberService;
import co.seung.mybatis.member.service.MemberVO;
import co.seung.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberSelectList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDAO = new MemberServiceImpl();
 		request.setAttribute("members", memberDAO.memberSelectList());
		return "member/memberSelectList";
	}

}
