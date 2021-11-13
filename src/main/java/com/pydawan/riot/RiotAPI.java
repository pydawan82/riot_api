package com.pydawan.riot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.pydawan.dto.Query;
import com.pydawan.riot.dto.LeagueListDto;
import com.pydawan.riot.dto.SummonerDto;

import org.json.JSONObject;

public class RiotAPI {
    
    public static final String PROTOCOL = "https";
    public static final String TOKEN_HEADER = "X-Riot-Token";

    public static JSONObject query(RiotContext context, String route) throws MalformedURLException, IOException {
        URL url = new URL(PROTOCOL, context.server(), route);
        Map<String, String> headers = Map.of(
            TOKEN_HEADER, context.apiKey()
        );

        return Query.getJSON(url, headers);
    }

    public static class Summoner {

        private static final String route = "/lol/summoner/v4/summoners";

        private Summoner() {}

        /**
         * Get a summoner by account ID.
         * @param context
         * @param encryptedAccountId
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto byAccount(RiotContext context, String encryptedAccountId) throws MalformedURLException, IOException {
            String route = Summoner.route + "/by-account/" + encryptedAccountId;
            return SummonerDto.fromJson(RiotAPI.query(context, route));
        }

        /**
         * Get a summoner by summoner name.
         * @param context
         * @param summonerName
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto byName(RiotContext context, String summonerName) throws MalformedURLException, IOException {
            String route = Summoner.route + "/by-name/" + summonerName.replace(" ", "%20");
            return SummonerDto.fromJson(RiotAPI.query(context, route));
        }

        /**
         * Get a summoner by PUUID.
         * @param context
         * @param encryptedPUUID
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto byPUUID(RiotContext context, String encryptedPUUID) throws MalformedURLException, IOException {
            String route = Summoner.route + "/by-puuid/" + encryptedPUUID;
            return SummonerDto.fromJson(RiotAPI.query(context, route));
        }

        /**
         * Get a summoner by summoner ID.
         * @param context
         * @param summonerId
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto bySummonerId(RiotContext context, long summonerId) throws MalformedURLException, IOException {
            String route = Summoner.route + "/" + summonerId;
            return SummonerDto.fromJson(RiotAPI.query(context, route));
        }

        /**
         * Get the summoner of the owner of the key.
         * @param context
         * @return 
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto me(RiotContext context) throws MalformedURLException, IOException {
            String route = Summoner.route + "/me";
            return SummonerDto.fromJson(RiotAPI.query(context, route));
        }
    }

    public static class League {
        private static final String route = "/lol/league/v4";

        public static LeagueListDto challeangerLeagues(RiotContext context, String queue) throws MalformedURLException, IOException {
            String route = League.route + "/challengerleagues/by-queue/" + queue;
            return LeagueListDto.fromJson(RiotAPI.query(context, route));
        }
    }
}
