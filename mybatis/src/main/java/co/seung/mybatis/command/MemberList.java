package co.seung.mybatis.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.member.service.MemberService;

import co.seung.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		
		request.setAttribute("members", memberDao.memberSelectList());
		
		return "member/memberList";
	}
}
