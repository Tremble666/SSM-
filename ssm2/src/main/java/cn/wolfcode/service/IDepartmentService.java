package cn.wolfcode.service;

import cn.wolfcode.domain.Department;

import java.util.List;

public interface IDepartmentService {
    void save(Department department);
    void update(Department department);
    void delete(Long id);
    Department get(Long id);
    List<Department> listAll();
}
