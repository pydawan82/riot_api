package com.pydawan.riot;

public record RiotContext(String apiKey, String region) {

    public String server() {
        return RiotConstants.serverOf(region);
    }

}
