package github.botapi.destiny2.service;

import github.botapi.destiny2.model.DestinySeasonDefinitionDO;

import java.util.List;

public interface ZhChsService {

    /**
     * 将数据对象返序列化
     *
     * @return
     */
    List<DestinySeasonDefinitionDO> selectAll();
}
