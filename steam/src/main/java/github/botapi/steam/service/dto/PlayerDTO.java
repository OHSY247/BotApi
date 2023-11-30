package github.botapi.steam.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author straycamel
 * @date 2021/6/15
 * {
 * "steamid": "76561198339360662",
 * "communityvisibilitystate": 3,
 * "profilestate": 1,
 * "personaname": "娃哈哈店长",
 * "commentpermission": 1,
 * "profileurl": "https://steamcommunity.com/id/Stray_Camel/",
 * "avatar": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/af/af66ba83b0273f13420062ff6f655c11ec8e946f.jpg",
 * "avatarmedium": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/af/af66ba83b0273f13420062ff6f655c11ec8e946f_medium.jpg",
 * "avatarfull": "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/af/af66ba83b0273f13420062ff6f655c11ec8e946f_full.jpg",
 * "avatarhash": "af66ba83b0273f13420062ff6f655c11ec8e946f",
 * "lastlogoff": 1623659200,
 * "personastate": 1,
 * "realname": "Stray_camel",
 * "primaryclanid": "103582791429521408",
 * "timecreated": 1476941089,
 * "personastateflags": 0,
 * "gameextrainfo": "Destiny 2",
 * "gameid": "1085660",
 * "lobbysteamid": "109775241100590632",
 * "loccountrycode": "CN",
 * "locstatecode": "12"
 * }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PlayerDTO {

    private String locstatecode;
    private String loccountrycode;
    private String lobbysteamid;
    private String gameid;
    private String gameextrainfo;
    private int personastateflags;
    private int timecreated;
    private String primaryclanid;
    private String realname;
    private int personastate;
    private int lastlogoff;
    private String avatarhash;
    private String avatarfull;
    private String avatarmedium;
    private String avatar;
    private String profileurl;
    private int commentpermission;
    private String personaname;
    private int profilestate;
    private int communityvisibilitystate;
    private String steamid;
}
