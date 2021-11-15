package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class CustomizationDto extends DtoBase {
    public String category;
    public String content;

    public static CustomizationDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, CustomizationDto.class);
    }
}
