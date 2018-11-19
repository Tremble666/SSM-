package cn.wolfcode.mapper;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
    int queryForCount(EmployeeQueryObject qo);
    List<Employee> queryForList(EmployeeQueryObject qo);
    Employee queryByNameAndPassword(@Param("name") String name, @Param("password")String password);
}