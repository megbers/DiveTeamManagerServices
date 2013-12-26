package org.egbers.divemanager.service.service;

import static org.egbers.divemanager.service.domain.Board.FIVE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.SEVEN;
import static org.egbers.divemanager.service.domain.Board.TEN;
import static org.egbers.divemanager.service.domain.Board.THREE;

import org.egbers.divemanager.service.domain.Board;
import org.egbers.divemanager.service.domain.Dive;
import org.egbers.divemanager.service.domain.DiveFactory;
import org.egbers.divemanager.service.exception.InvalidApproachException;
import org.egbers.divemanager.service.exception.InvalidPostionException;

public class DiveLookUpService {

	private final DiveFactory diveFactory;

	public DiveLookUpService(final DiveFactory diveFactory) {
		this.diveFactory = diveFactory;
	}

	public Dive findDiveByNumber(final String fullDiveNumber, final Integer height) throws InvalidPostionException, InvalidApproachException {
		Board board = convertToBoard(height);
		return diveFactory.createDive(fullDiveNumber, board);
	}

	// TODO Find a better place for this method
	Board convertToBoard(final Integer height) {
		if (height == 3) {
			return THREE;
		} else if (height == 5) {
			return FIVE;
		} else if (height == 7) {
			return SEVEN;
		} else if (height == 10) {
			return TEN;
		} else {
			return ONE;
		}
	}
}
