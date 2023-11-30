package github.botapi.destiny2.dto.botapi.base;

import lombok.Data;

/**
 * @author straycamel
 * @date 2021/6/15
 * 最小的实体，用于增加描述信息
 */
@Data
public class ItemVO {
    private Object value;
    private String des;
    public ItemVO(Object value){
        this.value=value;
    }
    public ItemVO(Object value, String des){
        this.des=des;
        this.value=value;
    }
}
