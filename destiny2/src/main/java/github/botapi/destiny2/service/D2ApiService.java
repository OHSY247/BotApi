package github.botapi.destiny2.service;

import github.botapi.destiny2.dto.d2api.playerInfo.SearchDestinyPlayerDTO;

import java.util.Map;

/**
 * @author straycamel
 * @date 2021/6/15
 */
public interface D2ApiService {
    /**
     * @author straycamel
     * @date 2021/6/9
     * 构造请求头加入 HEADER_AUTH_KEY 参数
     * @return Map<String, String> setAPIKey();*/

    /**
     * @author straycamel
     * @date 2021/6/9
     * 获取manifest源数据
     */
    String getManifest();

    /**
     * 对manifest数据进行检查
     * - 若最新版本为当前版本，则不用更新；
     * - 若最新版本不为当前版本，则返回最新的sql文件url
     *
     * @return Map，key为language，value为sql文件url
     */
    Map<String, String> getLastManifestContent();

    /**
     * 数据批量下载并自动解压manifest所有数据
     *
     * @param url         下载的url
     * @param downloadDir 下载存放的路径
     * @param dataDir     解压后的文件路径
     */
    void downloadManifest(String url, String downloadDir, String dataDir);
    /**
     * @author straycamel
     * @date 2021/6/15
     * 通过用户名称查找steamid
     */
    Long getSteamIDByD2(String name);

    /**
     * @author straycamel
     * @date 2021/6/15
     * 解析html，解析出steamid
     */
    Long parseSteamID(Long membershipId);

    /**
     * @return
     * @author straycamel
     * @date 2021/6/15
     * 通过命运玩家的名字获取基本数据
     */
    SearchDestinyPlayerDTO SearchDestinyPlayer(String name);

    /**
     * @return
     * @author straycamel
     * @date 2021/6/15
     * 通过steamid
     */
    SearchDestinyPlayerDTO SearchDestinyPlayer(Long Id);

    /**
     * @author straycamel
     * @date 2021/6/15
     */
    // SearchDestinyPlayerDTO
}
