package openpaas.model;

import io.fabric8.kubernetes.client.CustomResource;

public class IPRangeDefinition extends CustomResource {

    private static final long serialVersionUID = 7846164048705463444L;

    private Spec spec;
    private Status status;

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    

}