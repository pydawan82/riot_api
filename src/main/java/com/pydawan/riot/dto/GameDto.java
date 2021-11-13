package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.ListOf;

public class GameDto {
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
}
