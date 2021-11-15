package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class MatchDto extends DtoBase {
    public MetdataDto metadata;
    public InfoDto info;

    public static MatchDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, MatchDto.class);
    }
}
