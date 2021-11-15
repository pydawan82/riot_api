package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;

import org.json.JSONObject;

public class PlayerDto extends DtoBase {
    public String summonerId;
    public String teamId;
    public String position;
    public String role;
    
    public static PlayerDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, PlayerDto.class);
    }

    public static enum Position {
        UNSELECTED, FILL, TOP, JUNGLE, MID, BOTTOM, UTILITY
    }

    public static enum Role {
        CAPTAIN, MEMBER
    }
}
