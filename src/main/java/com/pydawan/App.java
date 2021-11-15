package com.pydawan;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import com.pydawan.riot.*;
import com.pydawan.riot.dto.*;

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
        String apiKey = new JSONObject(Files.readString(Path.of("config.json")))
                .getString("apiKey");
        RiotContext context = new RiotContext(apiKey, RiotConstants.EUW);
        String summonerName = "CAFE BABE";

        try {
            SummonerDto summoner = RiotAPI.Summoner.byName(context, summonerName);
            System.out.println(summoner);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
