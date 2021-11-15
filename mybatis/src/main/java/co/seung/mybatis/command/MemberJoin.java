package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.member.service.MemberService;
import co.seung.mybatis.member.service.MemberVO;
import co.seung.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		MemberVO verified = new MemberVO();
		
		verified.setId(request.getParameter("id"));
		verified.setAuthor("");
		verified=memberDAO.memberSelect(verified);
		
		if(verified.getAuthor().isEmpty()) {////////////////////////널비교어케하누ㅜㅜㅜㅜㅜㅜㅜㅜ
			//TODO 널비교
			
			vo.setId(request.getParameter("id"));
			vo.setAddress(request.getParameter("address"));
			vo.setAuthor(request.getParameter("author"));
			vo.setName(request.getParameter("name"));
			vo.setPassword(request.getParameter("password"));
			vo.setTel(request.getParameter("tel"));
			
			memberDAO.memberInsert(vo);
			request.setAttribute("message", vo.getName()+"님 어서오시고");
			return "member/memberLogin";
			

		} else {
			
			
			request.setAttribute("message", "까비요. 이미 등록된 아이디입니다.");
			return "member/memberLogin";
		}
	}

}
