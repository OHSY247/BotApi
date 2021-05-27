package github.botapi.demo;

import github.botapi.demo.model.DemoDO;
import github.botapi.demo.service.DemoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private DemoService service;

    @Test
    void contextLoads() {
        DemoDO model = new DemoDO();
        model.setKey("测试key1");
        model.setValue("测试value1");

        // 记录数
        List<DemoDO> all = service.selectAll();
        int size = all.size();

        // insert
        boolean result = service.insert(model);
        Assert.assertTrue(result);

        // select
        DemoDO selectModel = service.select(model.getId());
        Assert.assertNotNull(selectModel);

        // selectAll
        all = service.selectAll();
        Assert.assertEquals(size + 1, all.size());

        // updateValue
        selectModel.setValue("测试更改value1");
        result = service.updateValue(selectModel);
        Assert.assertTrue(result);

        // delete
        result = service.delete(selectModel.getId());
        Assert.assertTrue(result);

    }

}
