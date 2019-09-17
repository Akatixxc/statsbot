package fi.kooditiimi.league;

//TODO: tee tästä builder helpottaisi varmasti objektien tekemistä
public class LeagueProfile {

    private String summonerID;
    private String accountID;
    private String summonerName;
    private String summonerServer;
    private int summonerLevel;
    private String summonerRank;
    private int summonerRankedWins;
    private int summonerRankedLosses;
    private int profileIconId;

    public LeagueProfile(String summonerID, String accountID, String summonerName, String summonerServer, int summonerLevel, String summonerRank, int summonerRankedWins, int summonerRankedLosses, int profileIconId) {
        this.summonerID = summonerID;
        this.accountID = accountID;
        this.summonerName = summonerName;
        this.summonerServer = summonerServer;
        this.summonerLevel = summonerLevel;
        this.summonerRank = summonerRank;
        this.summonerRankedWins = summonerRankedWins;
        this.summonerRankedLosses = summonerRankedLosses;
        this.profileIconId = profileIconId;
    }

    public String getSummonerID() {
        return summonerID;
    }

    public void setSummonerID(String summonerID) {
        this.summonerID = summonerID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID() {
        this.accountID = accountID;
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

    public int getSummonerRankedLoses() {
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
}
