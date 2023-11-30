package github.botapi.destiny2.dao.zh_chs;

/**
 * @author straycamel
 * @date 2021/5/29
 */

import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DestinySeasonDefinitionDAO {
    // 查询全部
    @Select("SELECT * FROM DestinySeasonDefinition")
    List<DestinySeasonDefinitionDO> selectAll();

}