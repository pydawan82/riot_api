package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

public class InfoDto extends DtoBase {
    public long gameCreation;
    public long gameDuration;
    public long gameEndTimestamp;
    public long gameId;
    public String gameMode;
    public String gameName;
    public long gameStartTimestamp;
    public String gameType;
    public String gameVersion;
    public int mapId;
    @ListOf(ParticipantDto.class)
    public List<ParticipantDto> participants;
    public String platformId;
    public int queueId;
    @ListOf(TeamDto.class)
    public List<TeamDto> teams;
    public String tournamentCode;
}
