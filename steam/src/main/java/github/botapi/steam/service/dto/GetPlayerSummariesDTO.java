package github.botapi.steam.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class GetPlayerSummariesDTO {

    private ResponseEntity response;

    @Data
    public static class ResponseEntity {
        private List<PlayerDTO> players;
    }

}
