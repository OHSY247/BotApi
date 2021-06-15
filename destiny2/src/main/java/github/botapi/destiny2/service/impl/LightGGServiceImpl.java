package github.botapi.destiny2.service.impl;

import github.botapi.destiny2.service.LightGGService;
import org.springframework.stereotype.Service;

/**
 * @author straycamel
 * @date 2021/6/9
 * lightgg服务调用
 */
@Service
public class LightGGServiceImpl implements LightGGService {
    @Override
    public String generateImgPathByUrl(long itemID) {
        return "tmp/tmp.jpg";
    }
}
