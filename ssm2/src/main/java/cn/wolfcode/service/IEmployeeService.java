package cn.wolfcode.service;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.query.PageResult;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee);
    void update(Employee employee);
    void delete(Long id);
    Employee get(Long id);
    List<Employee> listAll();
    // 高级查询分页查询
    PageResult<Employee> query(EmployeeQueryObject qo);
    Employee login(String name, String password);
}