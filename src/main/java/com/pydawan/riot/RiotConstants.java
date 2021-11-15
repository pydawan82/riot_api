package com.pydawan.riot;

/**
 * The different regions that the API supports.
 */
public class RiotConstants {

    private RiotConstants() {}

    public static final String BR = "br1";
    public static final String EUNE = "eun1";
    public static final String EUW = "euw1";
    public static final String JP = "jp1";
    public static final String KR = "kr";
    public static final String LAN = "la1";
    public static final String LAS = "la2";
    public static final String NA = "na1";
    public static final String OCE = "oc1";
    public static final String RU = "ru";
    public static final String TR = "tr1";

    public static final String server = "%s.api.riotgames.com";
    public static final String serverOf(String region) {
        return server.formatted(region);
    }

    public static String majorRegionOf(String minor) {
        switch (minor) {
            case NA:
            case BR:
            case LAN:
            case LAS:
            case OCE:
                return "AMERICAS";
            case EUNE:
            case EUW:
            case TR:
            case RU:
                return "EUROPE";
            case KR:
            case JP:
                return "ASIA";
            default:
                return "NONE";
        }
    }

    public static final String SOLO = "RANKED_SOLO_5x5";
    public static final String FLEX = "RANKED_FLEX_5X5";
    public static final String FLEX_TFT = "RANKED_FLEX_TT";
}
