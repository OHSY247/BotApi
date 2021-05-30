package github.botapi.destiny2.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import github.botapi.destiny2.dao.zh_chs.DestinySeasonDefinitionDAO;
import github.botapi.destiny2.dto.SeasonDefinitionDTO;
import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class ZhChsService {

    private final DestinySeasonDefinitionDAO dao;

    @Autowired
    public ZhChsService(DestinySeasonDefinitionDAO dao) {

        this.dao = dao;
    }

    /**
     * 将数据对象返序列化
     * @return
     */
    public List<DestinySeasonDefinitionDO> selectAll() {
        List resDto = new ArrayList();
        for (DestinySeasonDefinitionDO item:dao.selectAll()) {
            JSONObject obj=null;
            Map<String, Object> map1 = null;
            try {
                String content = new String(item.getJson(), "UTF-8");
                JSONObject json = new JSONObject();
                json.put("content", content);
                //obj = (JSONObject) JSON.parse(json.toJSONString().getBytes("UTF-8"));
                map1 = JSON.parseObject(content, new TypeReference<Map<String, Object>>(){});
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            SeasonDefinitionDTO tmp = new SeasonDefinitionDTO(item.getId(), map1);
            resDto.add(tmp);
        }
        return resDto;
    }
}
