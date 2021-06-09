package github.botapi.destiny2.service.impl;

import github.botapi.destiny2.service.LightGGService;
import org.springframework.stereotype.Service;

/**
 * @author straycamel
 * @date 2021/6/9
 */
@Service
public class LightGGServiceImpl implements LightGGService {
    public String generateImgPathByUrl(long itemID){
        return "tmp/tmp.jpg";
    }
}
