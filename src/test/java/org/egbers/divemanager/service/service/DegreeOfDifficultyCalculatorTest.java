package org.egbers.divemanager.service.service;

import static org.egbers.divemanager.service.domain.Approach.BACKWARD;
import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Approach.INWARD;
import static org.egbers.divemanager.service.domain.Approach.REVERSE;
import static org.egbers.divemanager.service.domain.Board.FIVE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.SEVEN;
import static org.egbers.divemanager.service.domain.Board.TEN;
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

	@Test
	public void calculateFrontDiveTuck1Meter() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculate(dive));
	}

	@Test
	public void calculateFrontDiveTuck3Meter() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(1.4F), calculator.calculate(dive));
	}

	// --- Calculate A Tests ---
	@Test
	public void calculateAFor1MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(.9F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(.9F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(1.1F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(1.1F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1F, 0.0F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(1.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(1.6F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(1.6F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, TUCK, ONE);
		assertEquals(new Float(2.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(2.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(2.4F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(2.4F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3F, 0.0F, TUCK, ONE);
		assertEquals(new Float(2.7F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(2.7F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(3.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(3.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith4Somersaults() {
		Dive dive = createTestDive(FORWARD, 4F, 0.0F, TUCK, ONE);
		assertEquals(new Float(3.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith4Somersaults() {
		Dive dive = createTestDive(FORWARD, 4F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(3.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor1MeterWith4andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(3.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor5MeterWith4andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(3.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, THREE);
		assertEquals(new Float(1.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith0Somersaults() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(1.0F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWithHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1.0F, 0.0F, TUCK, THREE);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith1Somersaults() {
		Dive dive = createTestDive(FORWARD, 1.0F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(1.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(1.5F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith1andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(1.5F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, TUCK, THREE);
		assertEquals(new Float(1.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith2Somersaults() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(1.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(2.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith2andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(2.2F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3.0F, 0.0F, TUCK, THREE);
		assertEquals(new Float(2.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith3Somersaults() {
		Dive dive = createTestDive(FORWARD, 3.0F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(2.3F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(2.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith3andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(2.8F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor3MeterWith4andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(3.5F), calculator.calculateA(dive));
	}

	@Test
	public void calculateAFor7MeterWith4andHalfSomersaults() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(3.5F), calculator.calculateA(dive));
	}

	// --- Calculate B Tests --- //

	@Test
	public void calculateBForward0SSTuck() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward0SSPike() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward0SSStraight() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward0SSFree() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDiveTuck() {
		Dive dive = createTestDive(FORWARD, .5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDivePike() {
		Dive dive = createTestDive(FORWARD, .5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDiveStraight() {
		Dive dive = createTestDive(FORWARD, .5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForwardDiveFree() {
		Dive dive = createTestDive(FORWARD, .5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSTuck() {
		Dive dive = createTestDive(FORWARD, 1F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSPike() {
		Dive dive = createTestDive(FORWARD, 1F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSStraight() {
		Dive dive = createTestDive(FORWARD, 1F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward1SSFree() {
		Dive dive = createTestDive(FORWARD, 1F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSTuck() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSPike() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSStraight() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward15SSFree() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSTuck() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSPike() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSStraight() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward2SSFree() {
		Dive dive = createTestDive(FORWARD, 2F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSTuck() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSPike() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSStraight() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward25SSFree() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward3SSTuck() {
		Dive dive = createTestDive(FORWARD, 3F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward3SSPike() {
		Dive dive = createTestDive(FORWARD, 3F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward3SSFree() {
		Dive dive = createTestDive(FORWARD, 3F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward35SSTuck() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward35SSPike() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward35SSFree() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward4SSTuck() {
		Dive dive = createTestDive(FORWARD, 4.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward4SSPike() {
		Dive dive = createTestDive(FORWARD, 4.0F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward45SSTuck() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBForward45SSPike() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack0SSTuck() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack0SSPike() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack0SSStraight() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack0SSFree() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBackDiveSSTuck() {
		Dive dive = createTestDive(BACKWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBackDiveSSPike() {
		Dive dive = createTestDive(BACKWARD, 0.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBackDiveSSStraight() {
		Dive dive = createTestDive(BACKWARD, 0.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBackDiveSSFree() {
		Dive dive = createTestDive(BACKWARD, 0.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack1SSTuck() {
		Dive dive = createTestDive(BACKWARD, 1F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack1SSPike() {
		Dive dive = createTestDive(BACKWARD, 1F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack1SSStraight() {
		Dive dive = createTestDive(BACKWARD, 1F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack1SSFree() {
		Dive dive = createTestDive(BACKWARD, 1F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack15SSTuck() {
		Dive dive = createTestDive(BACKWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack15SSPike() {
		Dive dive = createTestDive(BACKWARD, 1.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack15SSStraight() {
		Dive dive = createTestDive(BACKWARD, 1.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.5F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack15SSFree() {
		Dive dive = createTestDive(BACKWARD, 1.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack2SSTuck() {
		Dive dive = createTestDive(BACKWARD, 2F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack2SSPike() {
		Dive dive = createTestDive(BACKWARD, 2F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack2SSStraight() {
		Dive dive = createTestDive(BACKWARD, 2F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.5F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack2SSFree() {
		Dive dive = createTestDive(BACKWARD, 2F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack25SSTuck() {
		Dive dive = createTestDive(BACKWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack25SSPike() {
		Dive dive = createTestDive(BACKWARD, 2.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack25SSStraight() {
		Dive dive = createTestDive(BACKWARD, 2.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.7F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack25SSFree() {
		Dive dive = createTestDive(BACKWARD, 2.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack3SSTuck() {
		Dive dive = createTestDive(BACKWARD, 3F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack3SSPike() {
		Dive dive = createTestDive(BACKWARD, 3F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack3SSFree() {
		Dive dive = createTestDive(BACKWARD, 3F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack35SSTuck() {
		Dive dive = createTestDive(BACKWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack35SSPike() {
		Dive dive = createTestDive(BACKWARD, 3.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBBack35SSFree() {
		Dive dive = createTestDive(BACKWARD, 3.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse0SSTuck() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse0SSPike() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse0SSStraight() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse0SSFree() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverseDiveSSTuck() {
		Dive dive = createTestDive(REVERSE, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverseDiveSSPike() {
		Dive dive = createTestDive(REVERSE, 0.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverseDiveSSStraight() {
		Dive dive = createTestDive(REVERSE, 0.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverseDiveSSFree() {
		Dive dive = createTestDive(REVERSE, 0.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse1SSTuck() {
		Dive dive = createTestDive(REVERSE, 1F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse1SSPike() {
		Dive dive = createTestDive(REVERSE, 1F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse1SSStraight() {
		Dive dive = createTestDive(REVERSE, 1F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse1SSFree() {
		Dive dive = createTestDive(REVERSE, 1F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse15SSTuck() {
		Dive dive = createTestDive(REVERSE, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse15SSPike() {
		Dive dive = createTestDive(REVERSE, 1.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse15SSStraight() {
		Dive dive = createTestDive(REVERSE, 1.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse15SSFree() {
		Dive dive = createTestDive(REVERSE, 1.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse2SSTuck() {
		Dive dive = createTestDive(REVERSE, 2F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse2SSPike() {
		Dive dive = createTestDive(REVERSE, 2F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse2SSStraight() {
		Dive dive = createTestDive(REVERSE, 2F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse2SSFree() {
		Dive dive = createTestDive(REVERSE, 2F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse25SSTuck() {
		Dive dive = createTestDive(REVERSE, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse25SSPike() {
		Dive dive = createTestDive(REVERSE, 2.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse25SSStraight() {
		Dive dive = createTestDive(REVERSE, 2.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse25SSFree() {
		Dive dive = createTestDive(REVERSE, 2.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse3SSTuck() {
		Dive dive = createTestDive(REVERSE, 3F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse3SSPike() {
		Dive dive = createTestDive(REVERSE, 3F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse3SSFree() {
		Dive dive = createTestDive(REVERSE, 3F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse35SSTuck() {
		Dive dive = createTestDive(REVERSE, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse35SSPike() {
		Dive dive = createTestDive(REVERSE, 3.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBReverse35SSFree() {
		Dive dive = createTestDive(REVERSE, 3.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward0SSTuck() {
		Dive dive = createTestDive(INWARD, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(-0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward0SSPike() {
		Dive dive = createTestDive(INWARD, 0F, 0.0F, PIKE, ONE);
		assertEquals(new Float(-0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward0SSStraight() {
		Dive dive = createTestDive(INWARD, 0F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward0SSFree() {
		Dive dive = createTestDive(INWARD, 0F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInwardDiveSSTuck() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(-0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInwardDiveSSPike() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(-0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInwardDiveSSStraight() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInwardDiveSSFree() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward1SSTuck() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, TUCK, ONE);
		assertEquals(new Float(-0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward1SSPike() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, PIKE, ONE);
		assertEquals(new Float(-0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward1SSStraight() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward1SSFree() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, FREE, ONE);
		assertEquals(new Float(-0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward15SSTuck() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward15SSPike() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward15SSStraight() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.8F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward15SSFree() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward2SSTuck() {
		Dive dive = createTestDive(INWARD, 2F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward2SSPike() {
		Dive dive = createTestDive(INWARD, 2F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward2SSStraight() {
		Dive dive = createTestDive(INWARD, 2F, 0.0F, STRAIGHT, ONE);
		assertEquals(new Float(0.8F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward2SSFree() {
		Dive dive = createTestDive(INWARD, 2F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward25SSTuck() {
		Dive dive = createTestDive(INWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward25SSPike() {
		Dive dive = createTestDive(INWARD, 2.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.5F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward25SSFree() {
		Dive dive = createTestDive(INWARD, 2.5F, 0.0F, FREE, ONE);
		assertEquals(new Float(0.4F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward3SSTuck() {
		Dive dive = createTestDive(INWARD, 3F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward3SSPike() {
		Dive dive = createTestDive(INWARD, 3F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward35SSTuck() {
		Dive dive = createTestDive(INWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.3F), calculator.calculateB(dive));
	}

	@Test
	public void calculateBInward35SSPike() {
		Dive dive = createTestDive(INWARD, 3.5F, 0.0F, PIKE, ONE);
		assertEquals(new Float(0.6F), calculator.calculateB(dive));
	}

	// --- Calculate C Tests --- //
	@Test
	public void calculateCForwardDiveHalfTwist() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward1ssHalfTwist() {
		Dive dive = createTestDive(FORWARD, 1.0F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackDiveHalfTwist() {
		Dive dive = createTestDive(BACKWARD, 0.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBack15ssHalfTwist() {
		Dive dive = createTestDive(BACKWARD, 1.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBack25ssHalfTwist() {
		Dive dive = createTestDive(BACKWARD, 2.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverseDiveHalfTwist() {
		Dive dive = createTestDive(REVERSE, 0.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse15ssHalfTwist() {
		Dive dive = createTestDive(REVERSE, 1.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse25ssHalfTwist() {
		Dive dive = createTestDive(REVERSE, 2.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInwardDiveHalfTwist() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward15ssHalfTwist() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward25ssHalfTwist() {
		Dive dive = createTestDive(INWARD, 2.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward35ssHalfTwist() {
		Dive dive = createTestDive(INWARD, 3.5F, 0.5F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward1tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 1.0F, TUCK, ONE);
		assertEquals(new Float(0.6F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward15tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 1.5F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward2tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 2.0F, TUCK, ONE);
		assertEquals(new Float(1.0F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward25tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 2.5F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward3tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 3.0F, TUCK, ONE);
		assertEquals(new Float(1.5F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward35tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 3.5F, TUCK, ONE);
		assertEquals(new Float(1.6F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward4tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 4.0F, TUCK, ONE);
		assertEquals(new Float(1.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCForward45tw() {
		Dive dive = createTestDive(FORWARD, 1.0F, 4.5F, TUCK, ONE);
		assertEquals(new Float(2.0F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward1tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 1.0F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward15tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 1.5F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward2tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 2.0F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward25tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 2.5F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward3tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 3.0F, TUCK, ONE);
		assertEquals(new Float(1.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward35tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 3.5F, TUCK, ONE);
		assertEquals(new Float(1.6F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward4tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 4.0F, TUCK, ONE);
		assertEquals(new Float(1.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCBackward45tw() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 4.5F, TUCK, ONE);
		assertEquals(new Float(2.0F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse1tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 1.0F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse15tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 1.5F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse2tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 2.0F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse25tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 2.5F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse3tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 3.0F, TUCK, ONE);
		assertEquals(new Float(1.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse35tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 3.5F, TUCK, ONE);
		assertEquals(new Float(1.6F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse4tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 4.0F, TUCK, ONE);
		assertEquals(new Float(1.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCReverse45tw() {
		Dive dive = createTestDive(REVERSE, 1.0F, 4.5F, TUCK, ONE);
		assertEquals(new Float(2.0F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward1tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 1.0F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward15tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 1.5F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward2tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 2.0F, TUCK, ONE);
		assertEquals(new Float(0.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward25tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 2.5F, TUCK, ONE);
		assertEquals(new Float(1.2F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward3tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 3.0F, TUCK, ONE);
		assertEquals(new Float(1.5F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward35tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 3.5F, TUCK, ONE);
		assertEquals(new Float(1.6F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward4tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 4.0F, TUCK, ONE);
		assertEquals(new Float(1.8F), calculator.calculateC(dive));
	}

	@Test
	public void calculateCInward45tw() {
		Dive dive = createTestDive(INWARD, 1.0F, 4.5F, TUCK, ONE);
		assertEquals(new Float(2.0F), calculator.calculateC(dive));
	}

	// --- Calculate D Tests --- //
	@Test
	public void calculateDForward1MeterLessThan4ss() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDForward1MeterGreaterThan4ss() {
		Dive dive = createTestDive(FORWARD, 4.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.5F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDForward5Meter() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(0.0F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDForward3Meter() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, THREE);
		assertEquals(new Float(0.0F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDForward7Meter() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(0.0F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDForward10Meter() {
		Dive dive = createTestDive(FORWARD, 0F, 0.0F, TUCK, TEN);
		assertEquals(new Float(0.0F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDBACKWARD1Meter() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDBACKWARD5Meter() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(0.2F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDBACKWARD3Meter() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, TUCK, THREE);
		assertEquals(new Float(0.2F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDBACKWARD7Meter() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(0.2F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDBACKWARD10Meter() {
		Dive dive = createTestDive(BACKWARD, 0F, 0.0F, TUCK, TEN);
		assertEquals(new Float(0.2F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDREVERSE1Meter() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDREVERSE5Meter() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDREVERSE3Meter() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, TUCK, THREE);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDREVERSE7Meter() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDREVERSE10Meter() {
		Dive dive = createTestDive(REVERSE, 0F, 0.0F, TUCK, TEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward1MeterDive() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.6F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward5MeterDive() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(0.6F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward3MeterDive() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward7MeterDive() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward10MeterDive() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, TEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward1Meter1ss() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.6F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward5Meter1ss() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(0.6F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward3Meter1ss() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, TUCK, THREE);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward7Meter1ss() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward10Meter1ss() {
		Dive dive = createTestDive(INWARD, 1F, 0.0F, TUCK, TEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward1MeterMoreThan1ss() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.5F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward5MeterMoreThan1ss() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, FIVE);
		assertEquals(new Float(0.5F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward3MeterMoreThan1ss() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, THREE);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward7MeterMoreThan1ss() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, SEVEN);
		assertEquals(new Float(0.3F), calculator.calculateD(dive));
	}

	@Test
	public void calculateDInward10MeterMoreThan1ss() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, TEN);
		assertEquals(new Float(0.2F), calculator.calculateD(dive));
	}

	// --- Calculate E --- //
	@Test
	public void calculateETwistingDive() {
		Dive dive = createTestDive(FORWARD, 1.5F, 1.0F, FREE, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForwardDive() {
		Dive dive = createTestDive(FORWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward1ss() {
		Dive dive = createTestDive(FORWARD, 1.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward15ss() {
		Dive dive = createTestDive(FORWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward2ss() {
		Dive dive = createTestDive(FORWARD, 2.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward25ss() {
		Dive dive = createTestDive(FORWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward3ss() {
		Dive dive = createTestDive(FORWARD, 3.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward35ss() {
		Dive dive = createTestDive(FORWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEForward4ss() {
		Dive dive = createTestDive(FORWARD, 4.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARDDive() {
		Dive dive = createTestDive(INWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARD1ss() {
		Dive dive = createTestDive(INWARD, 1.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARD15ss() {
		Dive dive = createTestDive(INWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARD2ss() {
		Dive dive = createTestDive(INWARD, 2.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARD25ss() {
		Dive dive = createTestDive(INWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARD3ss() {
		Dive dive = createTestDive(INWARD, 3.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEINWARD35ss() {
		Dive dive = createTestDive(INWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARDDive() {
		Dive dive = createTestDive(BACKWARD, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARD1ss() {
		Dive dive = createTestDive(BACKWARD, 1.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARD15ss() {
		Dive dive = createTestDive(BACKWARD, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARD2ss() {
		Dive dive = createTestDive(BACKWARD, 2.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARD25ss() {
		Dive dive = createTestDive(BACKWARD, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.3F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARD3ss() {
		Dive dive = createTestDive(BACKWARD, 3.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEBACKWARD35ss() {
		Dive dive = createTestDive(BACKWARD, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSEDive() {
		Dive dive = createTestDive(REVERSE, 0.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.1F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSE1ss() {
		Dive dive = createTestDive(REVERSE, 1.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSE15ss() {
		Dive dive = createTestDive(REVERSE, 1.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.2F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSE2ss() {
		Dive dive = createTestDive(REVERSE, 2.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSE25ss() {
		Dive dive = createTestDive(REVERSE, 2.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.3F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSE3ss() {
		Dive dive = createTestDive(REVERSE, 3.0F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.0F), calculator.calculateE(dive));
	}

	@Test
	public void calculateEREVERSE35ss() {
		Dive dive = createTestDive(REVERSE, 3.5F, 0.0F, TUCK, ONE);
		assertEquals(new Float(0.4F), calculator.calculateE(dive));
	}

	private Dive createTestDive(final Approach approach, final Float ss, final Float tw, final Position position, final Board height) {
		Dive dive = new Dive();
		dive.setApproach(approach);
		dive.setSomersaults(ss);
		dive.setTwists(tw);
		dive.setHeight(height);
		dive.setPosition(position);
		return dive;
	}
}
