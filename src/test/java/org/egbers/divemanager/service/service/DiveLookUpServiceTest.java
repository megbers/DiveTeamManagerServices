package org.egbers.divemanager.service.service;

import static org.egbers.divemanager.service.domain.Board.FIVE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.SEVEN;
import static org.egbers.divemanager.service.domain.Board.TEN;
import static org.egbers.divemanager.service.domain.Board.THREE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.egbers.divemanager.service.domain.Dive;
import org.egbers.divemanager.service.domain.DiveFactory;
import org.egbers.divemanager.service.exception.DiveManagerException;
import org.junit.Before;
import org.junit.Test;

public class DiveLookUpServiceTest {
	private DiveLookUpService service;
	private DiveFactory mockFactory;

	@Before
	public void setUp() {
		mockFactory = mock(DiveFactory.class);
		service = new DiveLookUpService(mockFactory);
	}

	@Test
	public void findDiveByNumberShouldReturnADive() throws DiveManagerException {
		Dive expected = new Dive();
		String fullDiveNumber = "101A";
		when(mockFactory.createDive(fullDiveNumber, ONE)).thenReturn(expected);
		Dive actual = service.findDiveByNumber(fullDiveNumber, 1);

		assertEquals(expected, actual);
	}

	@Test
	public void convertToBoardShouldReturnTHREEWhenPassed3() {
		assertEquals(THREE, service.convertToBoard(3));
	}

	@Test
	public void convertToBoardShouldReturnFIVEWhenPassed5() {
		assertEquals(FIVE, service.convertToBoard(5));
	}

	@Test
	public void convertToBoardShouldReturnSEVENWhenPassed7() {
		assertEquals(SEVEN, service.convertToBoard(7));
	}

	@Test
	public void convertToBoardShouldReturnTENWhenPassed10() {
		assertEquals(TEN, service.convertToBoard(10));
	}
}
