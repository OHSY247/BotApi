package github.botapi.destiny2.dto.d2api.playerInfo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@Data
class BasicVO {
     private Float value;
     private String displayValue;
}

@Data
class StatIdBasicVO {
     private String statId;
     private BasicVO basic;
}

@Data
class StatIdBasicPgaVO {
     private String statId;
     private BasicVO basic;
     private BasicVO pga;
}

@Data
class AllPvpVO {
     private JSONObject allTime;
}

@Data
class AllPveVO {
     private JSONObject allTime;
}

@Data
class ResultsVO {
     private AllPvpVO allPvP;
     private AllPveVO allPvE;
}

@Data
class MergedVO {
     private AllPvpVO allPvP;
     private AllPveVO allPvE;
}

@Data
class MergedItemVO{
     private ResultsVO results;
     private MergedVO merged;
}


@Data
class CharacterItemVO{
     private ResultsVO results;
     private MergedVO merged;
     private String characterId;
     private Boolean deleted;
}

@Data
class ResponseVO {
     private MergedItemVO mergedDeletedCharacters;
     private MergedItemVO mergedAllCharacters;
     private CharacterItemVO[] characters;
}

/**
 * @author straycamel
 * https://www.bungie.net/Platform/Destiny2/3/Account/4611686018490704250/Stats/ 解析json的实体构造
 */
public abstract class MergedDeletedCharactersDTO {
     private ResponseVO Response;
}
