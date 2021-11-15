package co.seung.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.member.service.MemberService;
import co.seung.mybatis.member.service.MemberVO;
import co.seung.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
//		vo.setId(String.valueOf(session.getAttribute("id")));	//세션이 좆ㄴ재할때
		vo.setPassword(request.getParameter("password"));
		vo = memberDAO.memberSelect(vo);
		request.setAttribute("member", vo);
		if(vo!=null) {
//			session.setAttribute("message", vo.getName()+"님 환영합니다;");
//			request.setAttribute("id", "AAAAAAAA");
//			request.setAttribute("author", vo.getAuthor());
//			request.setAttribute("name", vo.getName());
			
			request.setAttribute("message", vo.getName()+"님 하윙 ( ´ ▽ ` )ﾉ");
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
		}else {
			request.setAttribute("message", "( ˃̣̣̥᷄⌓˂̣̣̥᷅ ) <br><br> 아이디 또는 비밀번호가 틀렸습니다");
		}
		return "member/memberLogin";
	}

}
