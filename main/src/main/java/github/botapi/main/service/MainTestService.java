package github.botapi.main.service;

import github.botapi.main.dao.MainTestDAO;
import github.botapi.main.model.MainTestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class MainTestService {

    private final MainTestDAO dao;

    @Autowired
    public MainTestService(MainTestDAO dao) {
        this.dao = dao;
    }

    public boolean insert(MainTestDO model) {
        return dao.insert(model) > 0;
    }

    public MainTestDO select(int id) {
        return dao.select(id);
    }

    public List<MainTestDO> selectAll() {
        return dao.selectAll();
    }

    public boolean updateValue(MainTestDO model) {
        return dao.updateValue(model) > 0;
    }

    public boolean delete(Integer id) {
        return dao.delete(id) > 0;
    }
}