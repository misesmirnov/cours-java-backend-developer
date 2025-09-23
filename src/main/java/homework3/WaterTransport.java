package homework3;

import homework3.type.TransportModel;

public abstract class WaterTransport extends Transport {
    protected final Integer draught;

    public WaterTransport(Integer maxSpeed, TransportModel model, Integer draught) {
        super(maxSpeed, model);
        this.draught = draught;
    }

    public Integer getDraught() {
        return draught;
    }
}
