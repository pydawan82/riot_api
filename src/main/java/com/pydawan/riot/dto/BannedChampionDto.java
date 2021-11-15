package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class BannedChampionDto extends DtoBase {
    public int pickTurn;
    public long championId;
    public long teamId;

    public static BannedChampionDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, BannedChampionDto.class);
    }
}
