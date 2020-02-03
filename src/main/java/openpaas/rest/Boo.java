package openpaas.rest;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import openpaas.model.IPRangeDefinition;
import openpaas.model.IPRangeDefinitionDoneable;
import openpaas.model.IPRangeDefinitionList;
import openpaas.model.Status;

/**
 * Boo
 */
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Boo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Boo.class);

    @POST
    public Response boo(String newdata) {
        Status status = new Status();
        status.setCreatedAt(newdata);
        KubernetesClient oc = new DefaultKubernetesClient();
        Optional<CustomResourceDefinition> customResourceDefinition = oc.customResourceDefinitions().list().getItems()
                .stream().filter(crd -> crd.getMetadata().getName().equals("iprangedefinitions.openpaas.com"))
                .findFirst();
        CustomResourceDefinition crd = customResourceDefinition.get();
        MixedOperation<IPRangeDefinition, IPRangeDefinitionList, IPRangeDefinitionDoneable, Resource<IPRangeDefinition, IPRangeDefinitionDoneable>> client = oc
                .customResources(crd, IPRangeDefinition.class, IPRangeDefinitionList.class,
                        IPRangeDefinitionDoneable.class);
        IPRangeDefinition iprd = client.inNamespace("openpaas-ip-controller").withName("eleven").get();
        iprd.setStatus(status);
        client.updateStatus(iprd);
    
        return Response.ok(iprd.getStatus()).build();
    }
    
}