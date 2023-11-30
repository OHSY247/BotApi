package github.botapi.util.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bobby
 * @date 2020/7/30 8:55 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDTO<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回message
     */
    private String message;

    /**
     * 返回状态
     */
    private String status;

    /**
     * response包含的data
     */
    private T data;

    public BaseResponseDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.status = "SUCCESS";
    }

    public BaseResponseDTO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.status = "SUCCESS";
        this.data = data;
    }
}
