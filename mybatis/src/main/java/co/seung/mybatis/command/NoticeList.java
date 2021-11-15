package co.seung.mybatis.command;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seung.mybatis.comm.Command;
import co.seung.mybatis.notice.service.NoticeService;
import co.seung.mybatis.notice.service.NoticeVO;
import co.seung.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		List<NoticeVO> list = noticeDao.noticeSelectList();
		String today = String.valueOf(LocalDate.now()).substring(2);
		LocalTime now = LocalTime.now();
		String hourNow = String.valueOf(now.getHour());
		if(hourNow.length()<2) {
			hourNow = "0"+hourNow;
		}
		String minuteNow = String.valueOf(now.getMinute());
		if(minuteNow.length()<2) {
			minuteNow = "0"+minuteNow;
		}
		String secondNow = String.valueOf(now.getSecond()); 
		if(secondNow.length()<2) {
			secondNow = "0"+secondNow;
		}
		System.out.println("현재시간: "+hourNow+":"+minuteNow+":"+secondNow);
		
		for(int i = 0; i<list.size();i++) {
			String noticeDate = list.get(i).getWriteDate().substring(0,8);
//			System.out.println("noticeDate"+noticeDate);
			
			//날짜가 같으면
			if(noticeDate.equals(today)) {
				String noticeTime = list.get(i).getWriteDate().substring(9);
//				System.out.println("noticeTime:"+noticeTime);
				
				String noticeHour = noticeTime.substring(0, 2);
				System.out.println("noticeHour:"+noticeHour);
				if(!hourNow.equals(noticeHour)) {
					int finalHour = Integer.parseInt(hourNow)-Integer.parseInt(noticeHour);
					String fin = finalHour+"시간 전";
					list.get(i).setWriteDate(fin);
					continue;
					}
				
				String noticeMinute = noticeTime.substring(3, 5);
//				System.out.println("noticeMinute:"+noticeMinute);
				if(!minuteNow.equals(noticeMinute)) {
					int finalMinute = Integer.parseInt(minuteNow)-Integer.parseInt(noticeMinute);
					String fin = finalMinute+"분 전";
					list.get(i).setWriteDate(fin);
					continue;
					}
				
				String noticeSecond = noticeTime.substring(6);
//				System.out.println("noticeSecond:"+noticeSecond);
				if(!secondNow.equals(noticeSecond)) {
					int finalSecond = Integer.parseInt(secondNow)-Integer.parseInt(noticeSecond);
					String fin = finalSecond+"초 전";
					list.get(i).setWriteDate(fin);
					continue;
					}
				
			//날짜가 다르면
			}else {
				list.get(i).setWriteDate(noticeDate);
			}
		}
		request.setAttribute("notices", noticeDao.noticeSelectList());
		return "notice/noticeList";
	}

}
