package github.botapi.destiny2.dao.zh_chs;

/**
 * @author straycamel
 * @date 2021/5/29
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface DestinyInventoryItemDefinitionDO {
    // 查询物品id
    @Select("select distinct json_extract(DestinyInventoryItemDefinition.json,'$.hash')  from DestinyInventoryItemDefinition,json_each(DestinyInventoryItemDefinition.json) where json_extract(DestinyInventoryItemDefinition.json,'$.displayProperties.name') = #{name} limit 1")
    long selectIdByName(String name);

}