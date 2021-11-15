package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

public class TeamDto extends DtoBase {
    @ListOf(BanDto.class)
    public List<BanDto> bans;
    public ObjectivesDto objectives;
    public int teamId;
    public boolean win;

}
