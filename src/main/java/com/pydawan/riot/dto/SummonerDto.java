package com.pydawan.riot.dto;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.pydawan.dto.Dto;
import com.pydawan.dto.Query;

import org.json.JSONObject;

public class SummonerDto extends Dto {
    public String accountId;
    public int profileIconId;
    public long revisionDate;
    public String name;
    public String id;
    public String puuid;
    public long summonerLevel;

    public static SummonerDto fromJson(JSONObject json) {
        return fromJson(json, SummonerDto.class);
    }

    /**
     * Returns an instance of SummonerDto from the given url.
     * @param url
     * @return
     * @throws MalformedURLException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static SummonerDto from(String url) throws MalformedURLException, IOException, URISyntaxException {
        return fromJson(Query.getJSON(url));
    }
}
