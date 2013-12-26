package org.egbers.divemanager.service.domain;

public enum Position {
	STRAIGHT("A", "Straight"),
	PIKE("B", "Pike"),
	TUCK("C", "Tuck"),
	FREE("D", "Free");
	
	private String code;
	private String text;
	Position(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getText() {
		return text;
	}
}
