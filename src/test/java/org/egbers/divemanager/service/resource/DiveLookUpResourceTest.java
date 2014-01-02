package org.egbers.divemanager.service.resource;

import static junit.framework.Assert.assertEquals;
import static org.egbers.divemanager.service.domain.Approach.REVERSE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.mockito.Mockito.when;

import org.codehaus.jettison.json.JSONObject;
import org.egbers.divemanager.service.domain.Dive;
import org.egbers.divemanager.service.service.DiveLookUpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiveLookUpResourceTest {
	@Mock
	private DiveLookUpService diveLookUpService;
	@InjectMocks
	private final DiveLookUpResource resource = new DiveLookUpResource();

	@Test
	public void shouldCallLookUpService() throws Exception {
		String diveNumber = "101A";
		int height = 1;
		Dive dive = new Dive();
		dive.setApproach(REVERSE);
		dive.setPosition(FREE);
		dive.setHeight(ONE);
		dive.setNumber(diveNumber);

		when(diveLookUpService.findDiveByNumber(diveNumber, height)).thenReturn(dive);

		JSONObject json = resource.findOne(diveNumber, height);

		assertEquals("101A", json.getString("number"));
	}
}
