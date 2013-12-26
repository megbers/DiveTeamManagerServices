package org.egbers.divemanager.service.domain;

import static junit.framework.Assert.assertEquals;
import static org.egbers.divemanager.service.domain.Approach.BACKWARD;
import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Approach.INWARD;
import static org.egbers.divemanager.service.domain.Approach.REVERSE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.PIKE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.egbers.divemanager.service.domain.Position.TUCK;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.egbers.divemanager.service.exception.DiveManagerException;
import org.egbers.divemanager.service.exception.InvalidApproachException;
import org.egbers.divemanager.service.exception.InvalidPostionException;
import org.egbers.divemanager.service.service.DegreeOfDifficultyCalculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DiveFactoryTest {
	private DiveFactory factory;
	private DegreeOfDifficultyCalculator mockCalculator;

	@Before
	public void setUp() {
		mockCalculator = Mockito.mock(DegreeOfDifficultyCalculator.class);
		factory = new DiveFactory(mockCalculator);
	}

	@Test
	public void shouldSetTheDD() throws DiveManagerException {
		when(mockCalculator.calculate(any(Dive.class))).thenReturn(1.4F);
		Dive dive = factory.createDive("101A", ONE);
		assertEquals(1.4F, dive.getDegreeOfDifficulty());
	}

	@Test
	public void shouldCreateAValidNonTwistingFrontDive() throws DiveManagerException {
		Dive dive = factory.createDive("101A", ONE);

		assertEquals(.5F, dive.getSomersaults());
		assertEquals(FORWARD, dive.getApproach());
		assertEquals(STRAIGHT, dive.getPosition());
		assertEquals("101", dive.getNumber());
	}

	@Test
	public void shouldCreateAValidNonTwistingBackDive() throws DiveManagerException {
		Dive dive = factory.createDive("201B", ONE);

		assertEquals(.5F, dive.getSomersaults());
		assertEquals(BACKWARD, dive.getApproach());
		assertEquals(PIKE, dive.getPosition());
		assertEquals("201", dive.getNumber());
	}

	@Test
	public void shouldCreateAValidNonTwistingReverseDive() throws DiveManagerException {
		Dive dive = factory.createDive("301C", ONE);

		assertEquals(.5F, dive.getSomersaults());
		assertEquals(REVERSE, dive.getApproach());
		assertEquals(TUCK, dive.getPosition());
		assertEquals("301", dive.getNumber());
	}

	@Test
	public void shouldCreateAValidNonTwistingInwardDive() throws DiveManagerException {
		Dive dive = factory.createDive("401D", ONE);

		assertEquals(.5F, dive.getSomersaults());
		assertEquals(INWARD, dive.getApproach());
		assertEquals(FREE, dive.getPosition());
		assertEquals("401", dive.getNumber());
	}

	@Test
	public void shouldCreateAValidTwistingDive() throws DiveManagerException {
		Dive dive = factory.createDive("5111A", ONE);

		assertEquals(.5F, dive.getSomersaults());
		assertEquals(.5F, dive.getTwists());
		assertEquals(FORWARD, dive.getApproach());
		assertEquals(STRAIGHT, dive.getPosition());
		assertEquals("5111", dive.getNumber());
	}

	@Test(expected = InvalidPostionException.class)
	public void shouldThrowInvalidPostionException() throws DiveManagerException {
		factory.createDive("101G", ONE);
	}

	@Test(expected = InvalidApproachException.class)
	public void shouldThrowInvalidApproachException() throws DiveManagerException {
		factory.createDive("701A", ONE);
	}
}
