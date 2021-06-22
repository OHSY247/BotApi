package github.botapi.destiny2.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author straycamel
 * @date 2021/6/15
 * 玩家游戏平台
 */
@AllArgsConstructor
public enum MembershipType {
    XboxLive(1L, "Xbox Live", new String[]{"xbox"}),
    PlayStationNetwork(2L, "PlayStation Network", new String[]{"ps"}),
    Steam(3L, "steam", new String[]{"steam"}),
    BattleNet(4L, "Battle.net", new String[]{"Battle.net"}),
    ALL(-1L, "全平台", new String[]{"all", "全平台"});

    @Getter
    private Long typeID;
    @Getter
    private String typeName;
    @Getter
    private String[] keys;

    /**
     * @author straycamel
     * @date 2021/6/15
     * 通过关键词模糊查询
     */
    public static MembershipType getMembershipType(String key) {
        if (key == null) {
            return MembershipType.ALL;
        }
        for (MembershipType e : MembershipType.values()) {
            System.out.println(e.toString());
        }
        return Arrays.stream(MembershipType.values())
                .filter(arkPageTypeEnum -> Arrays.stream(arkPageTypeEnum.getKeys()).findAny().equals(key))
                .findFirst().orElse(MembershipType.ALL);
    }

    /**
     * @author straycamel
     * @date 2021/6/15
     * 通过typeid查询平台枚举
     */
    public static MembershipType getMembershipType(Long pageTypeID) {
        if (pageTypeID == null) {
            return MembershipType.ALL;
        }
        return Arrays.stream(MembershipType.values())
                .filter(arkPageTypeEnum -> pageTypeID.equals(arkPageTypeEnum.getTypeID()))
                .findFirst().orElse(MembershipType.ALL);
    }
}
