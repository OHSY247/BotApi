package github.botapi.destiny2.dto.d2api.playerInfo;

import java.util.List;

/**
 * @author straycamel
 * @date 2021/6/15
 */
public abstract class LikedProfilesDTO {

    private MessagedataEntity messagedata;
    private String message;
    private String errorstatus;
    private int throttleseconds;
    private int errorcode;
    private ResponseEntity response;

    public static class MessagedataEntity {
    }

    public static class ResponseEntity {
        private List<String> profileswitherrors;
        private BnetmembershipEntity bnetmembership;
        private List<ProfilesEntity> profiles;
    }

    public static class BnetmembershipEntity {
        private String displayname;
        private String membershipid;
        private int membershiptype;
        private boolean ispublic;
        private int crosssaveoverride;
        private String iconpath;
        private String supplementaldisplayname;
    }

    public static class ProfilesEntity {
        private String displayname;
        private String membershipid;
        private int membershiptype;
        private boolean ispublic;
        private List<Integer> applicablemembershiptypes;
        private int crosssaveoverride;
        private boolean iscrosssaveprimary;
        private boolean isoverridden;
        private String datelastplayed;
    }
}
/**
{
    "Response": {
        "profiles": [
            {
                "dateLastPlayed": "2021-06-14T22:32:40Z",
                "isOverridden": false,
                "isCrossSavePrimary": false,
                "crossSaveOverride": 0,
                "applicableMembershipTypes": [
                    3
                ],
                "isPublic": false,
                "membershipType": 3,
                "membershipId": "4611686018490704250",
                "displayName": "娃哈哈店长"
            }
        ],
        "bnetMembership": {
            "supplementalDisplayName": "24114356",
            "iconPath": "/img/profile/avatars/default_avatar.gif",
            "crossSaveOverride": 0,
            "isPublic": false,
            "membershipType": 254,
            "membershipId": "24114356",
            "displayName": "Stray_Camel"
        },
        "profilesWithErrors": []
    },
    "ErrorCode": 1,
    "ThrottleSeconds": 0,
    "ErrorStatus": "Success",
    "Message": "Ok",
    "MessageData": {}
}
 */
