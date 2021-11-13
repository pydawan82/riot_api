package com.pydawan;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.pydawan.riot.RiotAPI;
import com.pydawan.riot.RiotConstants;
import com.pydawan.riot.RiotContext;
import com.pydawan.riot.dto.LeagueListDto;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public AppTest() {

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
        RiotContext context = new RiotContext(apiKey, RiotConstants.EUW1);
        LeagueListDto result = RiotAPI.League.challeangerLeagues(context, RiotConstants.SOLO);
        assertNotNull(result);
        System.out.println(result);
    }
}
