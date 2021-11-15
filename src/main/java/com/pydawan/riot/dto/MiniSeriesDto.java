package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class MiniSeriesDto extends DtoBase {
    public String losses;
    public String progress;
    public String target;
    public String wins;

    public static MiniSeriesDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, MiniSeriesDto.class);
    }
}
