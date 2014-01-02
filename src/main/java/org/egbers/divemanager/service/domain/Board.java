package org.egbers.divemanager.service.domain;

public enum Board {
	TEN(10, "Ten Meter"), 
	SEVEN(7, "Seven 1/2 Meter"), 
	FIVE(5, "Five Meter"), 
	THREE(3, "Three Meter"), 
	ONE(1, "One Meter");
	
	private int code;
	private String text;
	
	Board(int code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getText() {
		return text;
	}
}
