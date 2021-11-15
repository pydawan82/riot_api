package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class LeagueEntryDto extends DtoBase {
    public String leagueId;
    public String summonerId;
    public String summonerName;
    public String queueType;
    public String tier;
    public String rank;
    public int leaguePoints;
    public int wins;
    public int losses;
    public boolean hotStreak;
    public boolean veteran;
    public boolean freshBlood;
    public boolean inactive;
    public MiniSeriesDto miniSeries;

    public static LeagueEntryDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, LeagueEntryDto.class);
    }
}
