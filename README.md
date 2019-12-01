# StatsBot

Discord bot which gives gaming related statistics of its user.

## About

StatsBot was started as a learning project with @Rassukka.

StatsBot requests data from game publishers API's as JSON files and parses all the important information into one place.

The bot isn't publicly in use yet.

## Usage

Currently StatsBot can give data from three games:
- League of Legends
- Faceit (CSGO)
- PlayerUnknown's Battlegrounds

## Commands

### League of Legends

For League of Legends we made commands profile, game and server.

Sadly RIOT API didn't give data of players champion stats, so we couldn't give any statistics on that.
We could had gathered the information ourselves. However we didn't have enough requests/min to do that.

#### Command: >lol profile [username]

Messages summoner level, rank, winrate in ranked and profile picture.

![](https://github.com/Akatixxc/statsbot/blob/master/images/lol_profile.JPG)

#### Command: >lol game [username]

Messages players ongoing match data.

![](https://github.com/Akatixxc/statsbot/blob/master/images/lol_game.JPG)

![](https://github.com/Akatixxc/statsbot/blob/master/images/lol_game2.JPG)

#### Command: >lol server [server]

Gives user ability to change between League of Legends servers.

![](https://github.com/Akatixxc/statsbot/blob/master/images/lol_server.JPG)

![](https://github.com/Akatixxc/statsbot/blob/master/images/lol_server_hint.JPG)

### Faceit

Faceit is made for Counter-Strike Global Offensive stats.
When we couldn't get data from steam, we decided to use Faceit to give some statistics.

#### Command: >faceit profile [username]

Brings up all important statistics of the player. As a added bonus we can show players ELO, which you can't see from Faceit.

![](https://github.com/Akatixxc/statsbot/blob/master/images/faceit_profile.JPG)

### PlayerUnknown's Battlegrounds

PUBG was just added to StatsBot and it only shows profile so far. We planned having a command, which shows players last game statistics.

#### Command: >pubg stats [gamemode] [username]

There is 6 different gamemodes in PUBG: solo, solo-fpp, duo, duo-fpp, squad and squad-fpp.

![](https://github.com/Akatixxc/statsbot/blob/master/images/pubg_stats.JPG)

![](https://github.com/Akatixxc/statsbot/blob/master/images/Hints.JPG)

### Help

Commands >help and >info are currently pretty useless. We are going to make them usefull at some point.

![](https://github.com/Akatixxc/statsbot/blob/master/images/help.JPG)

We also have made all commands respond to the user in case of typographical errors
