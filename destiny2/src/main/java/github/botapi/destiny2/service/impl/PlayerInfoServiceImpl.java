package github.botapi.destiny2.service.impl;

import github.botapi.destiny2.dto.d2api.playerInfo.SearchDestinyPlayerDTO;
import github.botapi.destiny2.dto.botapi.playerInfo.InfoDTO;
import github.botapi.destiny2.enums.MembershipType;
import github.botapi.destiny2.service.D2ApiService;
import github.botapi.destiny2.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import github.botapi.destiny2.dto.d2api.playerInfo.MergedDeletedCharactersDTO;
/**
 * @author straycamel
 * @date 2021/6/15
 * 玩家用户信息查询
 */
@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {
    @Autowired
    private D2ApiService d2ApiService;

    @Override
    public InfoDTO getPlayerInfo(String name) {
        if (name == null) {
            return null;
        }
        SearchDestinyPlayerDTO responseDto = d2ApiService.SearchDestinyPlayer(name);
        InfoDTO infoRes = new InfoDTO();

        Long membershipType = responseDto.getResponse().get(0).getMembershipType();
        Long membershipId = Long.valueOf(responseDto.getResponse().get(0).getMembershipId());

        String PlayerInfoName = responseDto.getResponse().get(0).getDisplayName();
        infoRes.setName(PlayerInfoName);
        infoRes.setPlatform(MembershipType.getMembershipType(membershipType).getTypeName());
        infoRes.setSteamID(d2ApiService.getSteamIDByD2(PlayerInfoName));
        infoRes.setMembershipId(d2ApiService.parseSteamID(membershipId));
        //MergedDeletedCharactersDTO mergedDeletedCharactersDTO = d2ApiService.getMergedDeletedCharacters(membershipType, membershipId);
        infoRes.setPve(null);
        infoRes.setPvp(null);
        return infoRes;
    }
}
