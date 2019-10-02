package fi.kooditiimi.league;

//TODO: tee tästä builder helpottaisi varmasti objektien tekemistä
public class LeagueProfile {

    private String summonerId;
    private String accountId;
    private String summonerName;
    private String summonerServer;
    private int summonerLevel;
    private String summonerRank;
    private int summonerRankedWins;
    private int summonerRankedLosses;
    private int profileIconId;

    public LeagueProfile(String summonerId, String accountId, String summonerName, String summonerServer, int summonerLevel, String summonerRank, int summonerRankedWins, int summonerRankedLosses, int profileIconId) {
        this.summonerId = summonerId;
        this.accountId = accountId;
        this.summonerName = summonerName;
        this.summonerServer = summonerServer;
        this.summonerLevel = summonerLevel;
        this.summonerRank = summonerRank;
        this.summonerRankedWins = summonerRankedWins;
        this.summonerRankedLosses = summonerRankedLosses;
        this.profileIconId = profileIconId;
    }

    public LeagueProfile(String summonerId, String summonerServer, String summonerRank, int summonerRankedWins, int summonerRankedLosses) {
        this.summonerId = summonerId;
        this.summonerServer = summonerServer;
        this.summonerRank = summonerRank;
        this.summonerRankedWins = summonerRankedWins;
        this.summonerRankedLosses = summonerRankedLosses;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId() {
        this.accountId = accountId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getSummonerServer() {
        return summonerServer;
    }

    public void setSummonerServer(String summonerServer) {
        this.summonerServer = summonerServer;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getSummonerRank() {
        return summonerRank;
    }

    public void setSummonerRank(String summonerRank) {
        this.summonerRank = summonerRank;
    }

    public int getSummonerRankedWins() {
        return summonerRankedWins;
    }

    public void setSummonerRankedWins(int summonerRankedWins) {
        this.summonerRankedWins = summonerRankedWins;
    }

    public int getSummonerRankedLosses() {
        return summonerRankedLosses;
    }

    public void setSummonerRankedLoses(int summonerRankedLoses) {
        this.summonerRankedLosses = summonerRankedLoses;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public int getSummonerRankedWinRate() {
        return this.getSummonerRankedWins() * 100 / (this.getSummonerRankedWins() + this.getSummonerRankedLosses());
    }

    public int getSummonerTotalRankedGames() {
        return this.summonerRankedWins + this.getSummonerRankedLosses();
    }
}
