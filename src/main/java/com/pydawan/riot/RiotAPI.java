package com.pydawan.riot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.pydawan.dto.DtoBase;
import com.pydawan.dto.Query;
import com.pydawan.riot.dto.AccountDto;
import com.pydawan.riot.dto.ChampionMasteryDto;
import com.pydawan.riot.dto.LeagueEntryDto;
import com.pydawan.riot.dto.LeagueListDto;
import com.pydawan.riot.dto.MatchDto;
import com.pydawan.riot.dto.PlatformDataDto;
import com.pydawan.riot.dto.SummonerDto;

import org.json.JSONArray;
import org.json.JSONObject;

public class RiotAPI {

    private static final String PROTOCOL = "https";
    private static final String TOKEN_HEADER = "X-Riot-Token";

    public static String query(String protocol, String server, String route, String apiKey) throws MalformedURLException, IOException {
        URL url = new URL(protocol, server, route);
        Map<String, String> headers = Map.of(TOKEN_HEADER, apiKey);

        return Query.fetch(url, headers);
    }

    public static String query(RiotContext context, String route) throws MalformedURLException, IOException {
        return query(PROTOCOL, context.server(), route, context.apiKey());
    }

    public static String queryMajor(RiotContext context, String route) throws MalformedURLException, IOException {
        return query(PROTOCOL, context.majorServer(), route, context.apiKey());
    }

    public static JSONObject queryObject(RiotContext context, String route) throws MalformedURLException, IOException {
        return new JSONObject(query(context, route));
    }

    public static JSONObject queryMajorObject(RiotContext context, String route) throws MalformedURLException, IOException {
        return new JSONObject(queryMajor(context, route));
    }

    public static JSONArray queryArray(RiotContext context, String route) throws MalformedURLException, IOException {
        return new JSONArray(query(context, route));
    }

    public static JSONArray queryMajorArray(RiotContext context, String route) throws MalformedURLException, IOException {
        return new JSONArray(queryMajor(context, route));
    }
    
    public static class Account {
        private static final String route = "/riot/account/v1/accounts";

        public static AccountDto byPuuid(RiotContext context, String puuid) throws MalformedURLException, IOException {
            String route = Account.route + "/by-puuid/" + puuid;
            return AccountDto.fromJson(queryMajorObject(context, route));
        }

        public static AccountDto byRiotId(RiotContext context, String gameName, String tagLine) throws MalformedURLException, IOException {
            String route = Account.route + "/by-riot-id/" + gameName + "/" +tagLine;
            return AccountDto.fromJson(queryMajorObject(context, route));
        }

        public static AccountDto byGame(RiotContext context, String game, String puuid) throws MalformedURLException, IOException {
            String route = Account.route + "/by-game/" + game + "/" + puuid;
            return AccountDto.fromJson(queryMajorObject(context, route));
        }

        public static AccountDto me(RiotContext context) throws MalformedURLException, IOException {
            String route = Account.route + "/me";
            return AccountDto.fromJson(queryMajorObject(context, route));
        }
    }

    public static class ChampionMastery {
        private static final String route = "/lol/champion-mastery/v4";

        public static final List<ChampionMasteryDto> bySummoner(RiotContext context, String summonerId) throws MalformedURLException, IOException {
            String route = ChampionMastery.route + "/champion-masteries/by-summoner/" + summonerId;
            return DtoBase.fromJsonArray(queryArray(context, route), ChampionMasteryDto.class);
        }

        public static final ChampionMasteryDto bySummonerAndChampion(RiotContext context, String summonerId, String championId) throws MalformedURLException, IOException {
            String route = ChampionMastery.route + "/champion-masteries/by-summoner/" + summonerId + "/by-champion/" + championId;
            return ChampionMasteryDto.fromJson(queryObject(context, route));
        }

        public static final int scores(RiotContext context, String summonerId, String championId) throws MalformedURLException, IOException {
            String route = ChampionMastery.route + "/scores/by-summoner/" + summonerId + "/by-champion/" + championId;
            return queryObject(context, route).getInt("championPoints");
        }
    }

    public static class Summoner {

        private static final String route = "/lol/summoner/v4/summoners";

        private Summoner() {
        }

        /**
         * Get a summoner by account ID.
         * 
         * @param context
         * @param encryptedAccountId
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto byAccount(RiotContext context, String encryptedAccountId)
                throws MalformedURLException, IOException {
            String route = Summoner.route + "/by-account/" + encryptedAccountId;
            return SummonerDto.fromJson(RiotAPI.queryObject(context, route));
        }

        /**
         * Get a summoner by summoner name.
         * 
         * @param context
         * @param summonerName
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto byName(RiotContext context, String summonerName)
                throws MalformedURLException, IOException {
            String route = Summoner.route + "/by-name/" + summonerName.replace(" ", "%20");
            return SummonerDto.fromJson(RiotAPI.queryObject(context, route));
        }

        /**
         * Get a summoner by PUUID.
         * 
         * @param context
         * @param encryptedPUUID
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto byPUUID(RiotContext context, String encryptedPUUID)
                throws MalformedURLException, IOException {
            String route = Summoner.route + "/by-puuid/" + encryptedPUUID;
            return SummonerDto.fromJson(RiotAPI.queryObject(context, route));
        }

        /**
         * Get a summoner by summoner ID.
         * 
         * @param context
         * @param summonerId
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto bySummonerId(RiotContext context, long summonerId)
                throws MalformedURLException, IOException {
            String route = Summoner.route + "/" + summonerId;
            return SummonerDto.fromJson(RiotAPI.queryObject(context, route));
        }

        /**
         * Get the summoner of the owner of the key.
         * 
         * @param context
         * @return
         * @throws MalformedURLException
         * @throws IOException
         */
        public static SummonerDto me(RiotContext context) throws MalformedURLException, IOException {
            String route = Summoner.route + "/me";
            return SummonerDto.fromJson(RiotAPI.queryObject(context, route));
        }
    }

    public static class League {
        private static final String route = "/lol/league/v4";

        public static LeagueListDto challeangerLeagues(RiotContext context, String queue)
                throws MalformedURLException, IOException {
            String route = League.route + "/challengerleagues/by-queue/" + queue;
            return LeagueListDto.fromJson(RiotAPI.queryObject(context, route));
        }

        public static List<LeagueEntryDto> entriesBySummoner(RiotContext context, String summonerId)
                throws MalformedURLException, IOException {
            String route = League.route + "/entries/by-summoner/" + summonerId;
            return DtoBase.fromJsonArray(RiotAPI.queryArray(context, route), LeagueEntryDto.class);
        }

        public static List<LeagueEntryDto> entriesByQueue(RiotContext context, String queue, String tier, String division)
                throws MalformedURLException, IOException {
            String route = League.route + "/entries/" + queue + "/" + tier + "/" + division;
            return DtoBase.fromJsonArray(RiotAPI.queryArray(context, route), LeagueEntryDto.class);
        }

        public static LeagueListDto grandmasterLeagues(RiotContext context, String queue)
                throws MalformedURLException, IOException {
            String route = League.route + "/grandmasterleagues/by-queue/" + queue;
            return LeagueListDto.fromJson(RiotAPI.queryObject(context, route));
        }

        public static LeagueListDto leagues(RiotContext context, String leagueId)
                throws MalformedURLException, IOException {
            String route = League.route + "/leagues/" + leagueId;
            return LeagueListDto.fromJson(RiotAPI.queryObject(context, route));
        }

        public static LeagueListDto masterLeagues(RiotContext context, String queue)
                throws MalformedURLException, IOException {
            String route = League.route + "/masterleagues/by-queue/" + queue;
            return LeagueListDto.fromJson(RiotAPI.queryObject(context, route));
        }
    }

    public static class LolStatus {
        private static final String route = "/lol/status/v4";

        public static PlatformDataDto platformData(RiotContext context) throws MalformedURLException, IOException {
            String route = LolStatus.route + "/platform-data";
            return PlatformDataDto.fromJson(RiotAPI.queryObject(context, route));
        }
    }

    public static class Match {
        public static final String route = "/lol/match/v5";

        public static MatchDto byId(RiotContext context, long matchId) throws MalformedURLException, IOException {
            String route = Match.route + "/matches/" + matchId;
            return MatchDto.fromJson(RiotAPI.queryObject(context, route));
        }

    }
}
