package github.botapi.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@AllArgsConstructor
public enum NetworkEnum {

    /**
     * 请求成功
     */
    SUCCESS(200, "success");

    @Getter
    private Integer responseCode;
    @Getter
    private String msg;
}
