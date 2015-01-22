package com.example.expandview.model;

public class ChildInfo {
	public String 
		itemTitle,
		message;
	public int img;
	
	public ChildInfo() {}
	
	public ChildInfo(String itemTitle, String message, int imgs) {
		this.itemTitle = itemTitle;
		this.message = message;
		this.img = imgs;
	}
	
	public String getItemTitle() {
		return itemTitle;
	}
	
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getImg() {
		return img;
	}
	
	public void setImg(int img) {
		this.img = img;
	}
}
