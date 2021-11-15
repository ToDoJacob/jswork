package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.member.service.MemberService;
import co.seung.mybatis.member.service.MemberVO;
import co.seung.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberSelfInfo implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(String.valueOf(session.getAttribute("id")));
		vo = memberDAO.memberSelect(vo);
		request.setAttribute("memberInfo", vo);
		return "member/memberSelfInfo";
	}

}
