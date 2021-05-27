package github.botapi.main.service;

import github.botapi.main.dao.DemoDAO;
import github.botapi.main.model.DemoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class DemoService {

    private final DemoDAO dao;

    @Autowired
    public DemoService(DemoDAO dao) {
        this.dao = dao;
    }

    public boolean insert(DemoDO model) {
        return dao.insert(model) > 0;
    }

    public DemoDO select(int id) {
        return dao.select(id);
    }

    public List<DemoDO> selectAll() {
        return dao.selectAll();
    }

    public boolean updateValue(DemoDO model) {
        return dao.updateValue(model) > 0;
    }

    public boolean delete(Integer id) {
        return dao.delete(id) > 0;
    }
}