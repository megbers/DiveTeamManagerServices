package org.egbers.divemanager.service.service;

import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Board.FIVE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.SEVEN;
import static org.egbers.divemanager.service.domain.Board.THREE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.PIKE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.egbers.divemanager.service.domain.Position.TUCK;
import static org.junit.Assert.assertEquals;

import org.egbers.divemanager.service.domain.Approach;
import org.egbers.divemanager.service.domain.Board;
import org.egbers.divemanager.service.domain.Dive;
import org.egbers.divemanager.service.domain.Position;
import org.junit.Before;
import org.junit.Test;

public class DegreeOfDifficultyCalculatorTest {
	private DegreeOfDifficultyCalculator calculator;

	@Before
	public void setUp() {
		calculator = new DegreeOfDifficultyCalculator();
	}

	// --- Calculate A Tests ---
	@Test
	public void calculateAFor1MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, TUCK, ONE);
		assertEquals(new Float(.9F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, TUCK, FIVE);
		assertEquals(new Float(.9F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, TUCK, ONE);
		assertEquals(new Float(1.1F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, TUCK, FIVE);
		assertEquals(new Float(1.1F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1F, TUCK, FIVE);
		assertEquals(new Float(1.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, TUCK, ONE);
		assertEquals(new Float(1.6F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, TUCK, FIVE);
		assertEquals(new Float(1.6F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, TUCK, ONE);
		assertEquals(new Float(2.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, TUCK, FIVE);
		assertEquals(new Float(2.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, TUCK, ONE);
		assertEquals(new Float(2.4F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, TUCK, FIVE);
		assertEquals(new Float(2.4F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3F, TUCK, ONE);
		assertEquals(new Float(2.7F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3F, TUCK, FIVE);
		assertEquals(new Float(2.7F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, TUCK, ONE);
		assertEquals(new Float(3.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, TUCK, FIVE);
		assertEquals(new Float(3.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, TUCK, THREE);
		assertEquals(new Float(1.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, TUCK, SEVEN);
		assertEquals(new Float(1.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, TUCK, THREE);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, TUCK, SEVEN);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1.0F, TUCK, THREE);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1.0F, TUCK, SEVEN);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, TUCK, THREE);
		assertEquals(new Float(1.5F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, TUCK, SEVEN);
		assertEquals(new Float(1.5F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, TUCK, THREE);
		assertEquals(new Float(1.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, TUCK, SEVEN);
		assertEquals(new Float(1.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, TUCK, THREE);
		assertEquals(new Float(2.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, TUCK, SEVEN);
		assertEquals(new Float(2.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3.0F, TUCK, THREE);
		assertEquals(new Float(2.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3.0F, TUCK, SEVEN);
		assertEquals(new Float(2.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, TUCK, THREE);
		assertEquals(new Float(2.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, TUCK, SEVEN);
		assertEquals(new Float(2.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith4andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 4.5F, TUCK, THREE);
		assertEquals(new Float(3.5F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith4andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 4.5F, TUCK, SEVEN);
		assertEquals(new Float(3.5F), calculator.calculateA(dive));
	}

	// --- Calculate B Tests --- //

	@Test
	public void calculateBForward0SSTuck() {
		Dive dive = createTestDive(FORWARD, 0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward0SSPike() {
		Dive dive = createTestDive(FORWARD, 0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward0SSStraight() {
		Dive dive = createTestDive(FORWARD, 0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward0SSFree() {
		Dive dive = createTestDive(FORWARD, 0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDiveTuck() {
		Dive dive = createTestDive(FORWARD, .5F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDivePike() {
		Dive dive = createTestDive(FORWARD, .5F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDiveStraight() {
		Dive dive = createTestDive(FORWARD, .5F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDiveFree() {
		Dive dive = createTestDive(FORWARD, .5F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSTuck() {
		Dive dive = createTestDive(FORWARD, 1F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSPike() {
		Dive dive = createTestDive(FORWARD, 1F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSStraight() {
		Dive dive = createTestDive(FORWARD, 1F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSFree() {
		Dive dive = createTestDive(FORWARD, 1F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSTuck() {
		Dive dive = createTestDive(FORWARD, 1.5F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSPike() {
		Dive dive = createTestDive(FORWARD, 1.5F, PIKE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSStraight() {
		Dive dive = createTestDive(FORWARD, 1.5F, STRAIGHT, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSFree() {
		Dive dive = createTestDive(FORWARD, 1.5F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSTuck() {
		Dive dive = createTestDive(FORWARD, 2F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSPike() {
		Dive dive = createTestDive(FORWARD, 2F, PIKE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSStraight() {
		Dive dive = createTestDive(FORWARD, 2F, STRAIGHT, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSFree() {
		Dive dive = createTestDive(FORWARD, 2F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSTuck() {
		Dive dive = createTestDive(FORWARD, 2.5F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSPike() {
		Dive dive = createTestDive(FORWARD, 2.5F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSStraight() {
		Dive dive = createTestDive(FORWARD, 2.5F, STRAIGHT, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSFree() {
		Dive dive = createTestDive(FORWARD, 2.5F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward3SSTuck() {
		Dive dive = createTestDive(FORWARD, 3F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward3SSPike() {
		Dive dive = createTestDive(FORWARD, 3F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward3SSFree() {
		Dive dive = createTestDive(FORWARD, 3F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward35SSTuck() {
		Dive dive = createTestDive(FORWARD, 3.5F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward35SSPike() {
		Dive dive = createTestDive(FORWARD, 3.5F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward35SSFree() {
		Dive dive = createTestDive(FORWARD, 3.5F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward45SSTuck() {
		Dive dive = createTestDive(FORWARD, 4.5F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward45SSPike() {
		Dive dive = createTestDive(FORWARD, 4.5F, PIKE, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	private Dive createTestDive(final Approach approach, final Float ss, final Position position, final Board height) {
		Dive dive = new Dive();
		dive.setApproach(approach);
		dive.setSomersaults(ss);
		dive.setHeight(height);
		dive.setPosition(position);
		return dive;
	}
}
