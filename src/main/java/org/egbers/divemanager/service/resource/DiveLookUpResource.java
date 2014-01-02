package org.egbers.divemanager.service.resource;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONObject;
import org.egbers.divemanager.service.domain.Dive;
import org.egbers.divemanager.service.service.DiveLookUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("lookup")
public class DiveLookUpResource {
	@Autowired
	private DiveLookUpService diveLookUpService;

	@GET
	@Path("/{diveNumber}/{height}")
	@Produces(APPLICATION_JSON)
	public JSONObject findOne(@PathParam("diveNumber") final String diveNumber, @PathParam("height") final Integer height) throws Exception {
		Dive dive = diveLookUpService.findDiveByNumber(diveNumber, height);
		return dive.toJSON();
	}

	public void setDiveLookUpService(final DiveLookUpService diveLookUpService) {
		this.diveLookUpService = diveLookUpService;
	}
}
