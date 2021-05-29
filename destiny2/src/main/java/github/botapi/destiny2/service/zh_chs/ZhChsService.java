package github.botapi.destiny2.service.zh_chs;

import github.botapi.destiny2.dao.zh_chs.DestinySeasonDefinitionDAO;
import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author straycamel
 * @date 2021/5/29
 */
import java.util.List;

@Service
@Repository
public class ZhChsService {

    private final DestinySeasonDefinitionDAO dao;

    @Autowired
    public ZhChsService(DestinySeasonDefinitionDAO dao) {

        this.dao = dao;
    }
    public List<DestinySeasonDefinitionDO> selectAll() {
        return dao.selectAll();
    }

}
