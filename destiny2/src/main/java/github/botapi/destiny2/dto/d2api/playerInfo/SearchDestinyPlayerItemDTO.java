package github.botapi.destiny2.dto.d2api.playerInfo;

import lombok.Data;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
public class SearchDestinyPlayerItemDTO {
    private String displayName;
    private String membershipId;
    private Long membershipType;
    private boolean isPublic;
    private int crossSaveOverride;
    private String iconPath;
}


