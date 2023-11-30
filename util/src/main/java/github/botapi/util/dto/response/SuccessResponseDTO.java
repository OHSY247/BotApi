package github.botapi.util.dto.response;

import github.botapi.util.enums.NetworkEnum;

/**
 * @author straycamel
 * @date 2021/6/15
 */
public class SuccessResponseDTO<T> extends BaseResponseDTO {
    public SuccessResponseDTO() {
        super(NetworkEnum.SUCCESS.getResponseCode(), NetworkEnum.SUCCESS.getMsg());
    }

    public SuccessResponseDTO(String message) {
        super(NetworkEnum.SUCCESS.getResponseCode(), message);
    }

    public SuccessResponseDTO(String message, T data) {
        super(NetworkEnum.SUCCESS.getResponseCode(), message, data);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
