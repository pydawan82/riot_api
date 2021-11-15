package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

import org.json.JSONObject;

public class GameDto extends DtoBase {
    public long gameId;
    public String gameType;
    public long gameStartTime;
    public long mapId;
    public long gameLength;
    public String platformId;
    public String gameMode;
    @ListOf(BannedChampionDto.class)
    public List<BannedChampionDto> bannedChampions;
    public long gameQueueConfigId;
    public ObserverDto observer;
    @ListOf(ParticipantDto.class)
    List<ParticipantDto> participants;
    
    public static GameDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, GameDto.class);
    }
}
