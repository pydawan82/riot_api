package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

import org.json.JSONObject;

public class PlatformDataDto extends DtoBase {
    public String id;
    public String name;
    @ListOf(String.class)
    public List<String> locales;
    @ListOf(StatusDto.class)
    public List<StatusDto> maintenances;
    @ListOf(StatusDto.class)
    public List<StatusDto> incidents;

    public static PlatformDataDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, PlatformDataDto.class);
    }
}
