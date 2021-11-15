package co.seung.mybatis.member.service;

import java.util.List;

public interface MemberService { //dao (Model 에서사용)
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
