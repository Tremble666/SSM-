package cn.wolfcode.mapper;

import cn.wolfcode.domain.Department;

import java.util.List;

public interface DepartmentMapper {
    void save(Department department);
    void update(Department department);
    void delete(Long id);
    Department get(Long id);
    List<Department> listAll();
}
