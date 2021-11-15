package com.pydawan.riot.dto;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.Optional;

import org.json.JSONObject;

public class AccountDto extends DtoBase {
    public String puuid;
    @Optional
    public String gameName;
    @Optional
    public String tagLine;

    public static AccountDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, AccountDto.class);
    }
}
