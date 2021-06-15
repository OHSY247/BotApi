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
    XboxLive(1, "Xbox Live", new String[]{"xbox"}),
    PlayStationNetwork(2,"PlayStation Network",new String[]{"ps"}),
    Steam(3,"steam", new String[]{"steam"}),
    BattleNet(4,"Battle.net", new String[]{"Battle.net"}),
    ALL(-1, "全平台", new String[]{"all", "全平台"});

    @Getter private Integer typeID;
    @Getter private String typeName;
    @Getter private String[] keys;
    /**
     * @author straycamel
     * @date 2021/6/15
     * 通过关键词模糊查询
     */
    public static MembershipType getMembershipType(String key){
        if(key == null){
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
    public static MembershipType getMembershipType(Integer pageTypeID) {
        if(pageTypeID == null){
            return MembershipType.ALL;
        }
        return Arrays.stream(MembershipType.values())
            .filter(arkPageTypeEnum -> pageTypeID.equals(arkPageTypeEnum.getTypeID()))
            .findFirst().orElse(MembershipType.ALL);
    }
}
