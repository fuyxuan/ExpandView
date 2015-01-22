package com.example.expandview.model;

import java.util.ArrayList;
import java.util.List;

public class GroupInfo {
	
	private String title;
	private ArrayList<ChildInfo> childInfos;
	
	public GroupInfo(String title, ArrayList<ChildInfo> childInfos) {
		this.title = title;
		this.childInfos = childInfos;
	}
	
	public String getTitle() {
		return title;
	}
	
//	public void setTitle(String title) {
//		this.title = title;
//	}
	
	public List<ChildInfo> getChildInfos() {
		return childInfos;
	}
	
//	public void setChildInfos(List<ChildInfo> childInfos) {
//		this.childInfos = childInfos;
//	}
	
}
