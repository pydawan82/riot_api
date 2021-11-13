package com.pydawan.riot.dto;

import com.pydawan.dto.Dto;

public class PlayerDto extends Dto {
    public String summonerId;
    public String teamId;
    public String position;
    public String role;

    public enum Position {
        UNSELECTED, FILL, TOP, JUNGLE, MID, BOTTOM, UTILITY
    }

    public enum Role {
        CAPTAIN, MEMBER
    }
}
