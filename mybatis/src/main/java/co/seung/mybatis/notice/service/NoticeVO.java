package co.seung.mybatis.notice.service;

import java.sql.Date;

public class NoticeVO {
	private int nid;
	private String[] array;
	private String id;
	private String name;
	private String writeDate;
//	private Date writeDate;
	private String title;
	private String contents;
	private int hit;
	
	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	

//	public Date getWriteDate() {
//		return writeDate;
//	}
//	public void setWriteDate(Date writeDate) {
//		this.writeDate = writeDate;
//	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}