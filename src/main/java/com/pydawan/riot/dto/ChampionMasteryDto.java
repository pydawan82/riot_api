package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class ChampionMasteryDto extends DtoBase {
    public long championPointsUntilNextLevel;
    public boolean chestGranted;
    public long championId;
    public long lastPlayTime;
    public int championLevel;
    public String summonerId;
    public long championPointsSinceLastLevel;
    public int tokensEarned;
    
    public static ChampionMasteryDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, ChampionMasteryDto.class);
    }
}
