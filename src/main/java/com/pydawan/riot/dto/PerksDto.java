package com.pydawan.riot.dto;

import java.util.List;

import com.pydawan.dto.Dto;
import com.pydawan.dto.ListOf;

public class PerksDto extends Dto {
    @ListOf(Long.class)
    public List<Long> perkIds;
    public Long perkStyle;
    public Long perkSubStyle;
}
