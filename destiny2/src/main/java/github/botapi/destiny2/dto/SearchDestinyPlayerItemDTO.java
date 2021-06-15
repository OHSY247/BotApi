package github.botapi.destiny2.dto;

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
    private int membershipType;
    private boolean isPublic;
    private int crossSaveOverride;
    private String iconPath;
}


