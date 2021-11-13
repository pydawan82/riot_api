package com.pydawan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.pydawan.riot.*;
import com.pydawan.riot.dto.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Hello world!
 */
public final class App {

    public static final String getApiKey() throws JSONException, IOException {
        return new JSONObject(Files.readString(Path.of("config.json"))).getString("apiKey");
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     * @throws JSONException
     */
    public static void main(String[] args) throws Exception {
        RiotContext context = new RiotContext(getApiKey(), RiotConstants.EUW1);
        LeagueListDto result = RiotAPI.League.challeangerLeagues(context, RiotConstants.SOLO);
        System.out.println(result);
    }
}
