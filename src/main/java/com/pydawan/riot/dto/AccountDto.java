package com.pydawan.riot.dto;

import com.pydawan.dto.Dto;
import com.pydawan.dto.Optional;

public class AccountDto extends Dto {
    public String puuid;
    
    @Optional
    public String gameName;
    @Optional
    public String tagLine;
}
