package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.mapper.EmployeeMapper;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.query.PageResult;
import cn.wolfcode.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void save(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public PageResult<Employee> query(EmployeeQueryObject qo) {
        int count = employeeMapper.queryForCount(qo);
        return new PageResult(qo.getCurrentPage(), qo.getPageSize(),
                count == 0 ? Collections.emptyList() : employeeMapper.queryForList(qo), count);
    }

    @Override
    public Employee login(String name, String password) {
        return employeeMapper.queryByNameAndPassword(name, password);
    }
}
