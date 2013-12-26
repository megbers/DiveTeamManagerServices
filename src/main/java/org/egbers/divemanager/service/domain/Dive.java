package org.egbers.divemanager.service.domain;

public class Dive {
	private String number;
	private Approach approach;
	private Position position;
	private Float degreeOfDifficulty;
	private Float somersaults;
	private Float twists;
	private Board height;

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public Approach getApproach() {
		return approach;
	}

	public void setApproach(final Approach approach) {
		this.approach = approach;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(final Position position) {
		this.position = position;
	}

	public String getDescription() {
		return approach.getText() + " " + getSomersaultString() + getTwistString() + position.getText();
	}

	private String getTwistString() {
		if (twists == null) {
			return "";
		}
		if (.5F == twists) {
			return "1/2tw ";
		} else if (somersaults != Math.floor(twists)) {
			return (int) Math.floor(twists) + " 1/2tw ";
		} else {
			return somersaults + "tw ";
		}
	}

	private String getSomersaultString() {
		if (somersaults == null) {
			return "";
		}
		if (.5F == somersaults) {
			return "Dive ";
		} else if (somersaults != Math.floor(somersaults)) {
			return (int) Math.floor(somersaults) + " 1/2ss ";
		} else {
			return somersaults + "ss ";
		}
	}

	public Float getDegreeOfDifficulty() {
		return degreeOfDifficulty;
	}

	public void setDegreeOfDifficulty(final Float degreeOfDifficulty) {
		this.degreeOfDifficulty = degreeOfDifficulty;
	}

	public Float getSomersaults() {
		return somersaults;
	}

	public void setSomersaults(final Float somersaults) {
		this.somersaults = somersaults;
	}

	public Board getHeight() {
		return height;
	}

	public void setHeight(final Board height) {
		this.height = height;
	}

	public Float getTwists() {
		return twists;
	}

	public void setTwists(final Float twists) {
		this.twists = twists;
	}

}
