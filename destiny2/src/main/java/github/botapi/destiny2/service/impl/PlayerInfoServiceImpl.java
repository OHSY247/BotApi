package github.botapi.destiny2.service.impl;

import github.botapi.destiny2.dto.SearchDestinyPlayerDTO;
import github.botapi.destiny2.dto.playerInfo.InfoDTO;
import github.botapi.destiny2.enums.MembershipType;
import github.botapi.destiny2.service.D2ApiService;
import github.botapi.destiny2.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {
    @Autowired
    private D2ApiService d2ApiService;

    public InfoDTO getPlayerInfo(String name) {
        if (name == null) {
            return null;
        }
        SearchDestinyPlayerDTO responseDto = d2ApiService.SearchDestinyPlayer(name);
        InfoDTO infoRes = new InfoDTO();
        String PlayerInfoName = responseDto.getResponse().get(0).getDisplayName();
        infoRes.setName(PlayerInfoName);
        infoRes.setPlatform(MembershipType.getMembershipType(responseDto.getResponse().get(0).getMembershipType()).getTypeName());
        infoRes.setSteamID(d2ApiService.getSteamIDByD2(PlayerInfoName));
        infoRes.setPve(null);
        infoRes.setPvp(null);
        return infoRes;
    }
}
