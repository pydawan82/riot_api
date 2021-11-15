package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

import org.json.JSONObject;

public class PerksDto extends DtoBase {
    @ListOf(Long.class)
    public List<Long> perkIds;
    public Long perkStyle;
    public Long perkSubStyle;

    public static PerksDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, PerksDto.class);
    }
}
