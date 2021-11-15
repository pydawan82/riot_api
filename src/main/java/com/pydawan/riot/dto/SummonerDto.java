package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class SummonerDto extends DtoBase {
    public String accountId;
    public int profileIconId;
    public long revisionDate;
    public String name;
    public String id;
    public String puuid;
    public long summonerLevel;

    public static SummonerDto fromJson(JSONObject json) {
        return fromJson(json, SummonerDto.class);
    }
}
