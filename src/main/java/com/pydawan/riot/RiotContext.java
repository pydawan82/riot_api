package com.pydawan.riot;

import static com.pydawan.riot.RiotConstants.majorRegionOf;
import static com.pydawan.riot.RiotConstants.serverOf;

public record RiotContext(String apiKey, String minorRegion) {

    public String server() {
        return serverOf(minorRegion);
    }

    public String majorServer() {
        return serverOf(majorRegionOf(minorRegion));
    }

}
