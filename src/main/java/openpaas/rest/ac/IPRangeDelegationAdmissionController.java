package openpaas.rest.ac;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.google.gson.Gson;

import io.fabric8.kubernetes.api.model.admission.AdmissionRequest;
import io.fabric8.kubernetes.api.model.admission.AdmissionResponse;

@Path("/IPRangeDeletation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IPRangeDelegationAdmissionController {

	@Inject
	Logger LOGGER;
	
	@POST
	@Path("/validate")
	public Response validateIPRangeDelegation(AdmissionRequest request) {
		Gson gson = new Gson();
		LOGGER.info("START");
		LOGGER.info(gson.toJson(request));
		LOGGER.info("END");
		AdmissionResponse response = new AdmissionResponse();
		response.setUid(request.getUid());
		response.setAllowed(true);
		return Response.ok(response).build();
	}
}
