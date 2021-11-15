package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.ListOf;

public class MetdataDto {
    public String dataVersion;
    public String matchId;
    @ListOf(String.class)
    public List<String> participant;
}
