package com.pydawan;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import com.pydawan.dto.DtoBase;
import com.pydawan.riot.RiotAPI;
import com.pydawan.riot.RiotConstants;
import com.pydawan.riot.RiotContext;
import com.pydawan.riot.RiotAPI.ChampionMastery;
import com.pydawan.riot.dto.ChampionMasteryDto;
import com.pydawan.riot.dto.LeagueListDto;
import com.pydawan.riot.dto.SummonerDto;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public AppTest() {

    }

    public boolean isDefault(Object o) {
        if (o == null) {
            return true;
        }
        return switch (o) {
            case Number n -> n.doubleValue() == 0d;
            case default -> false;        
        };
    }

    public void assertNotDefault(DtoBase dto) {
        assertNotNull(dto);
        boolean ok = Stream.of(dto.getClass().getFields())
                .map(f -> {
                    try {
                        return f.get(dto);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        return null;
                    }
                })
                .anyMatch(o -> !isDefault(o));

        if(!ok) {
            throw new AssertionError("DTO is empty");
        }
    }

    @Test
    public void assertNotDefaultTest() {
        SummonerDto summoner = new SummonerDto();
        try {
            assertNotDefault(summoner);
            throw new RuntimeException("SummonerDto is not empty");
        } catch(AssertionError e) {
            
        }
    }

    @Test
    public void testSummoner() throws Exception {
        String apiKey = new JSONObject(Files.readString(Path.of("config.json")))
                .getString("apiKey");
        RiotContext context = new RiotContext(apiKey, RiotConstants.EUW);
        String summonerName = "CAFE BABE";

        SummonerDto summoner = RiotAPI.Summoner.byName(context, summonerName);
        assertNotDefault(summoner);
    }

    @Test
    public void testChampionMastery() throws Exception {
        String apiKey = new JSONObject(Files.readString(Path.of("config.json")))
                .getString("apiKey");
        RiotContext context = new RiotContext(apiKey, RiotConstants.EUW);
        String summonerId = "kk19PMVSHMvMvL6HDeum1mqGc4VE8dFqRWc_k6-_PB2kmKo";
        
        List<ChampionMasteryDto> masteries = RiotAPI.ChampionMastery.bySummoner(context, summonerId);
        masteries.forEach(this::assertNotDefault);
    }

    /**
     * Rigorous Test.
     * @throws JSONException
     * 
     * @throws IOException
     * @throws MalformedURLException
     */
    @Test
    public void testChallengerLeague() throws Exception {
        System.out.print("s");
        String apiKey = new JSONObject(Files.readString(Path.of("config.json"))).getString("apiKey");
        RiotContext context = new RiotContext(apiKey, RiotConstants.EUW);
        LeagueListDto result = RiotAPI.League.challeangerLeagues(context, RiotConstants.SOLO);
        assertNotDefault(result);
    }
}
