package fi.kooditiimi.league;

//TODO: tee tästä builder helpottaisi varmasti objektien tekemistä
public class LeagueProfile {

    private String summonerID;
    private String summonerName;
    private String summonerServer;
    private int summonerLevel;
    private String summonerRank;
    private int summonerLeaguePoints;
    private int summonerRankedWins;
    private int summonerRankedLoses;
    private int profilePictureId;

    public LeagueProfile(String summonerID, String summonerName, String summonerServer, int summonerLevel, String summonerRank, int summonerLeaguePoints, int summonerRankedWins, int summonerRankedLoses, int profilePictureId) {
        this.summonerID = summonerID;
        this.summonerName = summonerName;
        this.summonerServer = summonerServer;
        this.summonerLevel = summonerLevel;
        this.summonerRank = summonerRank;
        this.summonerLeaguePoints = summonerLeaguePoints;
        this.summonerRankedWins = summonerRankedWins;
        this.summonerRankedLoses = summonerRankedLoses;
        this.profilePictureId = profilePictureId;
    }

    public String getSummonerID() {
        return summonerID;
    }

    public void setSummonerID(String summonerID) {
        this.summonerID = summonerID;
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

    public int getSummonerLeaguePoints() {
        return summonerLeaguePoints;
    }

    public void setSummonerLeaguePoints(int summonerLeaguePoints) {
        this.summonerLeaguePoints = summonerLeaguePoints;
    }

    public int getSummonerRankedWins() {
        return summonerRankedWins;
    }

    public void setSummonerRankedWins(int summonerRankedWins) {
        this.summonerRankedWins = summonerRankedWins;
    }

    public int getSummonerRankedLoses() {
        return summonerRankedLoses;
    }

    public void setSummonerRankedLoses(int summonerRankedLoses) {
        this.summonerRankedLoses = summonerRankedLoses;
    }

    public int getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(int profilePictureId) {
        this.profilePictureId = profilePictureId;
    }
}
