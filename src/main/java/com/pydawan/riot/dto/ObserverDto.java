package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class ObserverDto extends DtoBase {
    public String encryptionKey;
    
    public static ObserverDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, ObserverDto.class);
    }
}
