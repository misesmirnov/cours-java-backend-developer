package homework3;

import homework3.type.TransportModel;

public abstract class AirTransport extends Transport {
    private final Integer maxFlightAltitude;

    public AirTransport(Integer maxSpeed, TransportModel model, Integer maxFlightAltitude) {
        super(maxSpeed, model);
        this.maxFlightAltitude = maxFlightAltitude;
    }

    public Integer getMaxFlightAltitude() {
        return maxFlightAltitude;
    }
}
