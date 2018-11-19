package cn.wolfcode.service;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.query.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void query() {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setCurrentPage(1);
        qo.setKeyword("刘");
        PageResult<Employee> pageResult = employeeService.query(qo);
        System.out.println(pageResult.getTotalCount());
        System.out.println(pageResult.getData());
    }
}