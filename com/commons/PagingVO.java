package com.commons;

public class PagingVO {
	int pagenum; // 현재 페이지
	int pagesize; // 페이징 단위
	int startpage; // 첫번째 페이지 번호
	int endpage; // 해당 그룹 마지막 페이지 번호
	int lastpage; // 전체레코드의 마지막 페이지
	int groupsize;
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getGroupsize() {
		return groupsize;
	}
	public void setGroupsize(int groupsize) {
		this.groupsize = groupsize;
	}
}
