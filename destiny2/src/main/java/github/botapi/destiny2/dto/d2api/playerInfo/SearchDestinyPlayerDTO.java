package github.botapi.destiny2.dto.d2api.playerInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@Data
@NoArgsConstructor
/*@AllArgsConstructor*/
public class SearchDestinyPlayerDTO {
    private List<SearchDestinyPlayerItemDTO> Response;
    private MessagedataDTO MessageData;
    private String message;
    private String ErrorStatus;
    private int ThrottleSeconds;
    private int ErrorCode;
}


