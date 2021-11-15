package co.seung.mybatis.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.seung.mybatis.comm.DataSource;
import co.seung.mybatis.notice.service.NoticeMapper;
import co.seung.mybatis.notice.service.NoticeService;
import co.seung.mybatis.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService ,NoticeMapper{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeHitUpdate(NoticeVO vo) {
		return map.noticeHitUpdate(vo);
	}

	@Override
	public int noticeDeleteSelected(NoticeVO vo) {
		return map.noticeDeleteSelected(vo);
	}

	@Override
	public List<NoticeVO> noticeSelectByTitle(NoticeVO vo) {
		return map.noticeSelectByTitle(vo);
	}

	@Override
	public List<NoticeVO> noticeSelectByNid(NoticeVO vo) {
		return map.noticeSelectByNid(vo);
	}

}
