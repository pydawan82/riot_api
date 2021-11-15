package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class ContentDto extends DtoBase {
    public String locale;
    public String content;
    
    public static ContentDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, ContentDto.class);
    }
}
