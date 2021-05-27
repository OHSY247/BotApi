package github.botapi.main.dao;

import github.botapi.main.model.MainTestDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MainTestDAO {

    // 插入 并查询id 赋给传入的对象
    @Insert("INSERT INTO tb_test(key, value) VALUES(#{key}, #{value})")
    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'tb_test')", before = false, keyProperty = "id", resultType = int.class)
    int insert(MainTestDO model);

    // 根据 ID 查询
    @Select("SELECT * FROM tb_test WHERE id=#{id}")
    MainTestDO select(int id);

    // 查询全部
    @Select("SELECT * FROM tb_test")
    List<MainTestDO> selectAll();

    // 更新 value
    @Update("UPDATE tb_test SET value=#{value} WHERE id=#{id}")
    int updateValue(MainTestDO model);

    // 根据 ID 删除
    @Delete("DELETE FROM tb_test WHERE id=#{id}")
    int delete(Integer id);

}