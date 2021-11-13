package com.pydawan.riot;

/**
 * The different regions that the API supports.
 */
public class RiotConstants {

    private RiotConstants() {}

    public static final String BR1 = "br1";
    public static final String EUN1 = "eun1";
    public static final String EUW1 = "euw1";
    public static final String JP1 = "jp1";
    public static final String KR = "kr";
    public static final String LA1 = "la1";
    public static final String LA2 = "la2";
    public static final String NA1 = "na1";
    public static final String OC1 = "oc1";
    public static final String RU = "ru";
    public static final String TR1 = "tr1";

    public static final String server = "%s.api.riotgames.com";
    public static final String serverOf(String region) {
        return server.formatted(region);
    }

    public static final String SOLO = "RANKED_SOLO_5x5";
    public static final String FLEX = "RANKED_FLEX_5X5";
    public static final String FLEX_TFT = "RANKED_FLEX_TT";
}
