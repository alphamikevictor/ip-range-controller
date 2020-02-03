package openpaas.model;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.client.CustomResourceDoneable;

/**
 * IPRangeDefinitionDoneable
 */
public class IPRangeDefinitionDoneable extends CustomResourceDoneable<IPRangeDefinition> {

    public IPRangeDefinitionDoneable(IPRangeDefinition resource,
            Function<IPRangeDefinition, IPRangeDefinition> function) {
        super(resource, function);
        // TODO Auto-generated constructor stub
    }

    
}