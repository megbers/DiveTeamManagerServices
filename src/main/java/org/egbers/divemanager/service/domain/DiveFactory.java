package org.egbers.divemanager.service.domain;

import static org.egbers.divemanager.service.domain.Approach.BACKWARD;
import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Approach.INWARD;
import static org.egbers.divemanager.service.domain.Approach.REVERSE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.PIKE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.egbers.divemanager.service.domain.Position.TUCK;

import org.egbers.divemanager.service.service.DegreeOfDifficultyCalculator;

public class DiveFactory {

	private final DegreeOfDifficultyCalculator degreeOfDifficultyCalculator;

	public DiveFactory(final DegreeOfDifficultyCalculator degreeOfDifficultyCalculator) {
		this.degreeOfDifficultyCalculator = degreeOfDifficultyCalculator;
	}

	public Dive createDive(final String fullDiveNumber, final Board board) {
		Dive dive = new Dive();
		dive.setHeight(board);
		dive.setNumber(fullDiveNumber.substring(0, fullDiveNumber.length() - 1));

		int approach;
		float somersaults = 0, twists = 0;
		String position;
		if (fullDiveNumber.length() == 5) {
			// twister
			approach = Integer.valueOf(fullDiveNumber.substring(1, 2));
			somersaults = Float.valueOf(fullDiveNumber.substring(2, 3));
			twists = Float.valueOf(fullDiveNumber.substring(3, 4));
			position = fullDiveNumber.substring(4, 5);
		} else {
			// regular
			approach = Integer.valueOf(fullDiveNumber.substring(0, 1));
			somersaults = Float.valueOf(fullDiveNumber.substring(2, 3));
			position = fullDiveNumber.substring(3, 4);
		}

		dive.setApproach(getApproach(approach));
		dive.setPosition(getPosition(position));
		dive.setSomersaults(somersaults / 2);
		dive.setTwists(twists / 2);

		dive.setDegreeOfDifficulty(degreeOfDifficultyCalculator.calculate(dive));

		return dive;
	}

	private Position getPosition(final String p) {
		switch (p) {
		case "A":
			return STRAIGHT;
		case "B":
			return PIKE;
		case "C":
			return TUCK;
		case "D":
			return FREE;
		default:
			return null;
		}
	}

	private Approach getApproach(final int a) {
		switch (a) {
		case 1:
			return FORWARD;
		case 2:
			return BACKWARD;
		case 3:
			return REVERSE;
		case 4:
			return INWARD;
		default:
			return null;
		}

	}
}
