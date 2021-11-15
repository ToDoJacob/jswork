package co.seung.mybatis.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	List<NoticeVO> noticeSelectByTitle(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeHitUpdate(NoticeVO vo);
	int noticeDeleteSelected(NoticeVO vo);
	List<NoticeVO> noticeSelectByNid(NoticeVO vo);
}
