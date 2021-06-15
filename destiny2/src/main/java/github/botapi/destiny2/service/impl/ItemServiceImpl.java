package github.botapi.destiny2.service.impl;

import github.botapi.destiny2.dao.zh_chs.DestinyInventoryItemDefinitionDO;
import github.botapi.destiny2.service.ItemService;
import github.botapi.destiny2.service.LightGGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author straycamel
 * @date 2021/6/9
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private LightGGService lightGGService;
    @Autowired
    private DestinyInventoryItemDefinitionDO destinyInventoryItemDefinitionDO;

    /**
     * @return 物品id
     */
    @Override
    public long selectIdByName(String name) {
        return destinyInventoryItemDefinitionDO.selectIdByName(name);
    }

    /**
     * 通过物品获取lightgg截图
     */
    @Override
    public String screenshotLightGG(String name) {
        long itemID = selectIdByName(name);

        return lightGGService.generateImgPathByUrl(itemID);
    }
}
