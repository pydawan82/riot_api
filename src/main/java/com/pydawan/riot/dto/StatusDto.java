package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.ListOf;

public class StatusDto extends DtoBase {
    public String id;
    public String maintenanceStatus;
    public String incidentSeverity;
    @ListOf(ContentDto.class)
    public List<ContentDto> titles;
    @ListOf(UpdateDto.class)
    public List<UpdateDto> updates;
    public String createdAt;
    public String archiveAt;
    public String updatedAt;
    @ListOf(String.class)
    public List<String> platforms;
}
