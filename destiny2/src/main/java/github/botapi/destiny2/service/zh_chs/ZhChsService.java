package github.botapi.destiny2.service.zh_chs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import github.botapi.destiny2.dao.zh_chs.DestinySeasonDefinitionDAO;
import github.botapi.destiny2.dto.SeasonDefinitionDTO;
import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
        List<DestinySeasonDefinitionDO> res = dao.selectAll();
        System.out.println(res.toString());
        // List<SeasonDefinitionDTO> ;
        List resDto = new ArrayList();
        for (DestinySeasonDefinitionDO item:res) {

            JSONObject obj=null;
            try {
                String content = new String(item.getJson(), "UTF-8");
                JSONObject json = new JSONObject();
                json.put("content", content);
                obj = (JSONObject) JSON.parse(json.toJSONString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            SeasonDefinitionDTO tmp = new SeasonDefinitionDTO(item.getId(), obj);
            resDto.add(tmp);
        }
        return resDto;
    }


}
