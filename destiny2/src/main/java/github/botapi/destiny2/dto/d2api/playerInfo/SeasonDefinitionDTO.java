package github.botapi.destiny2.dto.d2api.playerInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Map;

/**
 * @author straycamel
 * @date 2021/5/30
 */
@Data
@NoArgsConstructor
// @AllArgsConstructor
public class SeasonDefinitionDTO {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "json")
    private Map<String, Object> json = null;

    public SeasonDefinitionDTO(Long id, Map<String, Object> json) {
        this.setId(id);
        this.setJson(json);
    }
}
