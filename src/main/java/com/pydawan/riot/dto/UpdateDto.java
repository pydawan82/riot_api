package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

import org.json.JSONObject;

public class UpdateDto extends DtoBase {
    public int id;
    public String author;
    public boolean publish;
    @ListOf(String.class)
    public List<String> publicLocations;
    @ListOf(ContentDto.class)
    public List<ContentDto> translations;
    public String createdAt;
    public String updatedAt;

    public static UpdateDto fromJson(JSONObject json) {
        return DtoBase.fromJson(json, UpdateDto.class);
    }
}
