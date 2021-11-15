package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

import org.json.JSONObject;

public class ParticipantDto extends DtoBase {
    public long championId;
    public PerksDto perks;
    public long profileIconId;
    public boolean bot;
    public long teamId;
    public String summonerName;
    public long summonerId;
    public long spell1Id;
    public long spell2Id;
    @ListOf(CustomizationDto.class)
    public List<CustomizationDto> customizations;

    public static ParticipantDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, ParticipantDto.class);
    }
}
