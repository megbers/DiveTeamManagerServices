package org.egbers.divemanager.integration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.Assert;

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
public class FullDDTableTest {
	private Map<String, Float> ddTable;
	private DiveLookUpService service;

	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("testApplicationContext.xml");
		service = (DiveLookUpService) context.getBean("diveLookUpService");
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void runTestFor1Meter() throws InvalidPostionException, InvalidApproachException {
		ddTable = create1MeterDDTable();

		Iterator it = ddTable.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			Assert.assertEquals((String) pairs.getKey(), pairs.getValue(), service.findDiveByNumber((String) pairs.getKey(), 1).getDegreeOfDifficulty());
		}
	}

	private Map<String, Float> create1MeterDDTable() {
		Map<String, Float> ddTable = new HashMap<String, Float>();
		// Front Group
		ddTable.put("101A", 1.4F);
		ddTable.put("101B", 1.3F);
		ddTable.put("101C", 1.2F);

		ddTable.put("102A", 1.6F);
		ddTable.put("102B", 1.5F);
		ddTable.put("102C", 1.4F);

		ddTable.put("103A", 2.0F);
		ddTable.put("103B", 1.7F);
		ddTable.put("103C", 1.6F);

		ddTable.put("104A", 2.6F);
		ddTable.put("104B", 2.3F);
		ddTable.put("104C", 2.2F);

		ddTable.put("105B", 2.6F);
		ddTable.put("105C", 2.4F);

		ddTable.put("106B", 3.2F);
		ddTable.put("106C", 2.9F);

		ddTable.put("107B", 3.3F);
		ddTable.put("107C", 3.0F);

		ddTable.put("108C", 4.0F);

		ddTable.put("109C", 4.3F);

		// Back Group
		ddTable.put("201A", 1.7F);
		ddTable.put("201B", 1.6F);
		ddTable.put("201C", 1.5F);

		ddTable.put("202A", 1.7F);
		ddTable.put("202B", 1.6F);
		ddTable.put("202C", 1.5F);

		ddTable.put("203A", 2.5F);
		ddTable.put("203B", 2.3F);
		ddTable.put("203C", 2.0F);

		ddTable.put("204B", 2.5F);
		ddTable.put("204C", 2.2F);

		ddTable.put("205B", 3.2F);
		ddTable.put("205C", 3.0F);

		ddTable.put("206B", 3.2F);
		ddTable.put("206C", 2.9F);

		// Reverse
		ddTable.put("301A", 1.8F);
		ddTable.put("301B", 1.7F);
		ddTable.put("301C", 1.6F);

		ddTable.put("302A", 1.8F);
		ddTable.put("302B", 1.7F);
		ddTable.put("302C", 1.6F);

		ddTable.put("303A", 2.7F);
		ddTable.put("303B", 2.4F);
		ddTable.put("303C", 2.1F);

		ddTable.put("304A", 2.9F);
		ddTable.put("304B", 2.6F);
		ddTable.put("304C", 2.3F);

		ddTable.put("305B", 3.2F);
		ddTable.put("305C", 3.0F);

		ddTable.put("306B", 3.3F);
		ddTable.put("306C", 3.0F);

		// Inward
		ddTable.put("401A", 1.8F);
		ddTable.put("401B", 1.5F);
		ddTable.put("401C", 1.4F);

		ddTable.put("402A", 2.0F);
		ddTable.put("402B", 1.7F);
		ddTable.put("402C", 1.6F);

		ddTable.put("403B", 2.4F);
		ddTable.put("403C", 2.2F);

		ddTable.put("404B", 3.0F);
		ddTable.put("404C", 2.8F);

		ddTable.put("405B", 3.4F);
		ddTable.put("405C", 3.1F);

		// Forward Twisters
		ddTable.put("5111A", 1.8F);
		ddTable.put("5111B", 1.7F);
		ddTable.put("5111C", 1.6F);

		ddTable.put("5112A", 2.0F);
		ddTable.put("5112B", 1.9F);

		ddTable.put("5121D", 1.7F);

		ddTable.put("5122D", 1.9F);

		ddTable.put("5124D", 2.3F);

		ddTable.put("5126D", 2.8F);

		ddTable.put("5131D", 2.0F);
		return ddTable;
	}
}
