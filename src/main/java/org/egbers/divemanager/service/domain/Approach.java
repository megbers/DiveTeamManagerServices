package org.egbers.divemanager.service.domain;

public enum Approach {
	FORWARD(1, "Forward"),
	BACKWARD(2, "Backward"),
	REVERSE(3, "Reverse"),
	INWARD(4, "Inward");
	
	private int code;
	private String text;
	
	Approach(int code, String text) {
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
