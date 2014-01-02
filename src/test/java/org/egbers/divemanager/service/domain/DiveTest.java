package org.egbers.divemanager.service.domain;

import static org.egbers.divemanager.service.domain.Approach.BACKWARD;
import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Approach.REVERSE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.PIKE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.egbers.divemanager.service.domain.Position.TUCK;
import static org.junit.Assert.assertEquals;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

public class DiveTest {
	@Test
	public void shouldReturnDescription() {
		Dive dive = new Dive();
		dive.setApproach(BACKWARD);
		dive.setSomersaults(1.5F);
		dive.setPosition(PIKE);

		assertEquals("Backward 1 1/2ss Pike", dive.getDescription());
	}

	@Test
	public void shouldReturnDescriptionWhenItIsADive() {
		Dive dive = new Dive();
		dive.setApproach(FORWARD);
		dive.setSomersaults(.5F);
		dive.setPosition(TUCK);

		assertEquals("Forward Dive Tuck", dive.getDescription());
	}

	@Test
	public void shouldReturnDescriptionWhenItIsADiveAndNoTwists() {
		Dive dive = new Dive();
		dive.setApproach(FORWARD);
		dive.setSomersaults(.5F);
		dive.setPosition(TUCK);
		dive.setTwists(0F);

		assertEquals("Forward Dive Tuck", dive.getDescription());
	}

	@Test
	public void shouldReturnDescriptionWhenItIsATwister() {
		Dive dive = new Dive();
		dive.setApproach(FORWARD);
		dive.setSomersaults(.5F);
		dive.setTwists(.5F);
		dive.setPosition(STRAIGHT);

		assertEquals("Forward Dive 1/2tw Straight", dive.getDescription());
	}

	@Test
	public void shouldReturnDescriptionWhenItIsEvenNumberOfSomersaultsAndTwists() {
		Dive dive = new Dive();
		dive.setApproach(FORWARD);
		dive.setSomersaults(2F);
		dive.setTwists(1F);
		dive.setPosition(TUCK);

		assertEquals("Forward 2ss 1tw Tuck", dive.getDescription());
	}

	@Test
	public void shouldReturnDescriptionWhenItIsATwisterWithMultipleTwistsAndSomersaults() {
		Dive dive = new Dive();
		dive.setApproach(REVERSE);
		dive.setSomersaults(2.5F);
		dive.setTwists(1.5F);
		dive.setPosition(FREE);

		assertEquals("Reverse 2 1/2ss 1 1/2tw Free", dive.getDescription());
	}

	@Test
	public void shouldReturnJSONRepresentation() throws Exception {
		Dive dive = new Dive();
		dive.setApproach(REVERSE);
		dive.setSomersaults(2.5F);
		dive.setTwists(1.5F);
		dive.setPosition(FREE);
		dive.setDegreeOfDifficulty(1.6F);
		dive.setHeight(ONE);
		dive.setNumber("5324D");

		JSONObject jsonDive = dive.toJSON();
		assertEquals("Reverse", jsonDive.optString("approach"));
		assertEquals("2.5", jsonDive.optString("somersaults"));
		assertEquals("1.5", jsonDive.optString("twists"));
		assertEquals("D", jsonDive.optString("position"));
		assertEquals("1.6", jsonDive.optString("degreeOfDifficulty"));
		assertEquals("1", jsonDive.optString("height"));
		assertEquals("5324D", jsonDive.optString("number"));
		assertEquals("Reverse 2 1/2ss 1 1/2tw Free", jsonDive.optString("description"));
	}
}
