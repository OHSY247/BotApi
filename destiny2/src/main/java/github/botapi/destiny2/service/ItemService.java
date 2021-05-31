package github.botapi.destiny2.service;

import github.botapi.destiny2.dao.zh_chs.DestinyInventoryItemDefinitionDO;
import github.botapi.destiny2.handler.LightGGBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author straycamel
 * @date 2021/5/30
 */
@Service
@Repository
public class ItemService extends LightGGBO {

    private final DestinyInventoryItemDefinitionDO dao;

    @Autowired
    public ItemService(DestinyInventoryItemDefinitionDO dao) {

        this.dao = dao;
    }

    /**
     * @return 物品id
     */
    public long selectIdByName(String name) {
        return dao.selectIdByName(name);
    }
    /**
     * 通过物品获取lightgg截图
     */
    public String screenshotLightGG(String name){
        long itemID = selectIdByName(name);

        return generateImgPathByUrl(itemID);
    }
    //public
}
