package github.botapi.destiny2.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author straycamel
 * @date 2021/5/30
 */
@Data
public class SeasonDefinitionDTO {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "json")
    private JSONObject json = null;

    public SeasonDefinitionDTO(Long id,JSONObject json){
        this.setId(id);
        this.setJson(json);
    }
}
