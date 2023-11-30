package github.botapi.destiny2.service;

/**
 * @author straycamel
 * @date 2021/5/30
 */
public interface ItemService {
    /**
     * @return 物品id
     */
    long selectIdByName(String name);

    /**
     * 通过物品获取lightgg截图
     */
    String screenshotLightGG(String name);
}
