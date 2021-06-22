package github.botapi.destiny2.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import github.botapi.destiny2.dao.zh_chs.DestinySeasonDefinitionDAO;
import github.botapi.destiny2.dto.d2api.playerInfo.SeasonDefinitionDTO;
import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import github.botapi.destiny2.service.ZhChsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author straycamel
 * @date 2021/6/9
 * 命运2 源数据库crud调用
 */
@Service
public class ZhChsServiceImpl implements ZhChsService {
    @Autowired
    private DestinySeasonDefinitionDAO destinySeasonDefinitionDAO;

    @Override
    public List<DestinySeasonDefinitionDO> selectAll() {
        List resDto = new ArrayList();
        for (DestinySeasonDefinitionDO item : destinySeasonDefinitionDAO.selectAll()) {
            JSONObject obj = null;
            Map<String, Object> map1 = null;
            try {
                String content = new String(item.getJson(), "UTF-8");
                JSONObject json = new JSONObject();
                json.put("content", content);
                map1 = JSON.parseObject(content, new TypeReference<Map<String, Object>>() {
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            SeasonDefinitionDTO tmp = new SeasonDefinitionDTO(item.getId(), map1);
            resDto.add(tmp);
        }
        return resDto;
    }
}
