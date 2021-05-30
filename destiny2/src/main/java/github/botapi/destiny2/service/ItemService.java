package github.botapi.destiny2.service;

import github.botapi.destiny2.dao.zh_chs.DestinyInventoryItemDefinitionDO;
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
public class ItemService {

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
}
