package fi.kooditiimi.pubg;

public class PubgProfile {

    private String nickname;
    private String accountId;
    private int assists;
    private int dBNOs;
    private int dailyKills;
    private int dailyWins;
    private double damageDealt;
    private int headshotKills;
    private int kills;
    private double longestKill;
    private double longestTimeSurvived;
    private int losses;
    private int maxKillStreaks;
    private int mostSurvivalTime;
    private double rankPoints;
    private String rankPointsTitle;
    private int revives;
    private int roadKills;
    private int roundMostKills;
    private int roundsPlayed;
    private int suicides;
    private int teamKills;
    private double timeSurvived;
    private int top10s;
    private int vehicleDestroys;
    private int weeklyKills;
    private int weeklyWins;
    private int wins;
    private int winRate;
    private double kdRatio;
    private int hsRate;

    public PubgProfile(String nickname, String accountId, int assists, int dBNOs, int dailyKills, int dailyWins, double damageDealt, int headshotKills, int kills, double longestKill, double longestTimeSurvived, int losses, int maxKillStreaks, int mostSurvivalTime, double rankPoints, String rankPointsTitle, int revives, int roadKills, int roundMostKills, int roundsPlayed, int suicides, int teamKills, double timeSurvived, int top10s, int vehicleDestroys, int weeklyKills, int weeklyWins, int wins) {
        this.nickname = nickname;
        this.accountId = accountId;
        this.assists = assists;
        this.dBNOs = dBNOs;
        this.dailyKills = dailyKills;
        this.dailyWins = dailyWins;
        this.damageDealt = damageDealt;
        this.headshotKills = headshotKills;
        this.kills = kills;
        this.longestKill = longestKill;
        this.longestTimeSurvived = longestTimeSurvived;
        this.losses = losses;
        this.maxKillStreaks = maxKillStreaks;
        this.mostSurvivalTime = mostSurvivalTime;
        this.rankPoints = rankPoints;
        this.rankPointsTitle = rankPointsTitle;
        this.revives = revives;
        this.roadKills = roadKills;
        this.roundMostKills = roundMostKills;
        this.roundsPlayed = roundsPlayed;
        this.suicides = suicides;
        this.teamKills = teamKills - suicides;
        this.timeSurvived = timeSurvived;
        this.top10s = top10s;
        this.vehicleDestroys = vehicleDestroys;
        this.weeklyKills = weeklyKills;
        this.weeklyWins = weeklyWins;
        this.wins = wins;
        this.winRate = (wins + losses != 0) ? (wins * 10000) / (wins + losses) : 0; //jaa sadalla
        this.kdRatio = (losses != 0) ? ((double) (kills) / (double) (losses)) : 0;
        this.hsRate = (headshotKills + kills != 0) ? (headshotKills * 10000) / (headshotKills + kills) : 0; //jaa sadalla
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getdBNOs() {
        return dBNOs;
    }

    public void setdBNOs(int dBNOs) {
        this.dBNOs = dBNOs;
    }

    public int getDailyKills() {
        return dailyKills;
    }

    public void setDailyKills(int dailyKills) {
        this.dailyKills = dailyKills;
    }

    public int getDailyWins() {
        return dailyWins;
    }

    public void setDailyWins(int dailyWins) {
        this.dailyWins = dailyWins;
    }

    public double getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(double damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getHeadshotKills() {
        return headshotKills;
    }

    public void setHeadshotKills(int headshotKills) {
        this.headshotKills = headshotKills;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public double getLongestKill() {
        return longestKill;
    }

    public void setLongestKill(double longestKill) {
        this.longestKill = longestKill;
    }

    public double getLongestTimeSurvived() {
        return longestTimeSurvived;
    }

    public void setLongestTimeSurvived(double longestTimeSurvived) {
        this.longestTimeSurvived = longestTimeSurvived;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getMaxKillStreaks() {
        return maxKillStreaks;
    }

    public void setMaxKillStreaks(int maxKillStreaks) {
        this.maxKillStreaks = maxKillStreaks;
    }

    public int getMostSurvivalTime() {
        return mostSurvivalTime;
    }

    public void setMostSurvivalTime(int mostSurvivalTime) {
        this.mostSurvivalTime = mostSurvivalTime;
    }

    public double getRankPoints() {
        return rankPoints;
    }

    public void setRankPoints(double rankPoints) {
        this.rankPoints = rankPoints;
    }

    public String getRankPointsTitle() {
        return rankPointsTitle;
    }

    public void setRankPointsTitle(String rankPointsTitle) {
        this.rankPointsTitle = rankPointsTitle;
    }

    public int getRevives() {
        return revives;
    }

    public void setRevives(int revives) {
        this.revives = revives;
    }

    public int getRoadKills() {
        return roadKills;
    }

    public void setRoadKills(int roadKills) {
        this.roadKills = roadKills;
    }

    public int getRoundMostKills() {
        return roundMostKills;
    }

    public void setRoundMostKills(int roundMostKills) {
        this.roundMostKills = roundMostKills;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public int getSuicides() {
        return suicides;
    }

    public void setSuicides(int suicides) {
        this.suicides = suicides;
    }

    public int getTeamKills() {
        return teamKills;
    }

    public void setTeamKills(int teamKills) {
        this.teamKills = teamKills;
    }

    public double getTimeSurvived() {
        return timeSurvived;
    }

    public void setTimeSurvived(double timeSurvived) {
        this.timeSurvived = timeSurvived;
    }

    public int getTop10s() {
        return top10s;
    }

    public void setTop10s(int top10s) {
        this.top10s = top10s;
    }

    public int getVehicleDestroys() {
        return vehicleDestroys;
    }

    public void setVehicleDestroys(int vehicleDestroys) {
        this.vehicleDestroys = vehicleDestroys;
    }

    public int getWeeklyKills() {
        return weeklyKills;
    }

    public void setWeeklyKills(int weeklyKills) {
        this.weeklyKills = weeklyKills;
    }

    public int getWeeklyWins() {
        return weeklyWins;
    }

    public void setWeeklyWins(int weeklyWins) {
        this.weeklyWins = weeklyWins;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWinRate() {
        return winRate;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    public double getKdRatio() {
        return kdRatio;
    }

    public void setKdRatio(int kdRatio) {
        this.kdRatio = kdRatio;
    }

    public int getHsRate() {
        return hsRate;
    }

    public void setHsRate(int hsRate) {
        this.hsRate = hsRate;
    }
}
