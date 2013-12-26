package org.egbers.divemanager.integration;

import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Approach.INWARD;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.THREE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.junit.Assert.assertEquals;

import org.egbers.divemanager.service.domain.Dive;
import org.egbers.divemanager.service.exception.DiveManagerException;
import org.egbers.divemanager.service.exception.InvalidApproachException;
import org.egbers.divemanager.service.exception.InvalidPostionException;
import org.egbers.divemanager.service.service.DiveLookUpService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
public class DDServiceIntegrationTest {

	private DiveLookUpService service;

	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("testApplicationContext.xml");
		service = (DiveLookUpService) context.getBean("diveLookUpService");
	}

	@Test
	public void shouldReturnValidDive() throws DiveManagerException {
		Dive dive = service.findDiveByNumber("101A", 1);
		assertEquals(FORWARD, dive.getApproach());
		assertEquals(ONE, dive.getHeight());
		assertEquals(STRAIGHT, dive.getPosition());
		assertEquals(new Float(1.4), dive.getDegreeOfDifficulty());
		assertEquals("Forward Dive Straight", dive.getDescription());
	}

	@Test
	public void shouldReturnInward15ss3tw() throws DiveManagerException {
		Dive dive = service.findDiveByNumber("5436D", 3);
		assertEquals(INWARD, dive.getApproach());
		assertEquals(THREE, dive.getHeight());
		assertEquals(FREE, dive.getPosition());
		assertEquals(new Float(3.5), dive.getDegreeOfDifficulty());
		assertEquals("Inward 1 1/2ss 3tw Free", dive.getDescription());
	}

	@Test(expected = InvalidPostionException.class)
	public void shouldThrowAnExceptionWhenPositionIsInvalid() throws DiveManagerException {
		service.findDiveByNumber("101G", 1);
	}

	@Test(expected = InvalidApproachException.class)
	public void shouldThrowAnExceptionWhenApproachIsInvalid() throws DiveManagerException {
		service.findDiveByNumber("701G", 1);
	}
}
