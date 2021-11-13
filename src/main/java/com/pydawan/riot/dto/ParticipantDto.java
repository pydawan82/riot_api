package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.Dto;
import com.pydawan.dto.ListOf;

public class ParticipantDto extends Dto {
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
}
