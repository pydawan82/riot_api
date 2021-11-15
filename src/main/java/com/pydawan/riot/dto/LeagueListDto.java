package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

import org.json.JSONObject;

public class LeagueListDto extends DtoBase {
    public String leagueId;
    @ListOf(LeagueItemDto.class)
    public List<LeagueItemDto> entries;
    public String tier;
    public String queue;
    public String name;
    
    public static LeagueListDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, LeagueListDto.class);
    }
}
