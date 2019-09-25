package fi.kooditiimi.faceit;

public class FaceitProfile {

    private String playerId;
    private String nickname;
    private String avatar;
    private String country;
    private int skillLevel;
    private int faceitElo;
    private String averageHS; // Headshot %
    private String averageKD; // Kill death ratio
    private String currentWS; // Winstreak
    private String longestWS; // Winstreak
    private String[] recentMatches; // 5 viimeisintä
    private String matches;
    private String wins;
    private String winRate;

    public FaceitProfile(String playerId, String nickname, String avatar, String country, int skillLevel, int faceitElo, String averageHS, String averageKD, String currentWS, String longestWS, String[] recentMatches, String matches, String wins, String winRate) {
        this.playerId = playerId;
        this.nickname = nickname;
        this.avatar = avatar;
        this.country = country;
        this.skillLevel = skillLevel;
        this.faceitElo = faceitElo;
        this.averageHS = averageHS;
        this.averageKD = averageKD;
        this.currentWS = currentWS;
        this.longestWS = longestWS;
        this.recentMatches = recentMatches;
        this.matches = matches;
        this.wins = wins;
        this.winRate = winRate;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getFaceitElo() {
        return faceitElo;
    }

    public void setFaceitElo(int faceitElo) {
        this.faceitElo = faceitElo;
    }

    public String getAverageHS() {
        return averageHS;
    }

    public void setAverageHS(String averageHS) {
        this.averageHS = averageHS;
    }

    public String getAverageKD() {
        return averageKD;
    }

    public void setAverageKD(String averageKD) {
        this.averageKD = averageKD;
    }

    public String getCurrentWS() {
        return currentWS;
    }

    public void setCurrentWS(String currentWS) {
        this.currentWS = currentWS;
    }

    public String getLongestWS() {
        return longestWS;
    }

    public void setLongestWS(String longestWS) {
        this.longestWS = longestWS;
    }

    public String[] getRecentMatches() {
        return recentMatches;
    }

    public void setRecentMatches(String[] recentMatches) {
        this.recentMatches = recentMatches;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getWinRate() {
        return winRate;
    }

    public void setWinRate(String winRate) {
        this.winRate = winRate;
    }
}