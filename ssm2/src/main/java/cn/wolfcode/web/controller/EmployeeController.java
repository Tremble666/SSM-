package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.query.EmployeeQueryObject;
import cn.wolfcode.service.IDepartmentService;
import cn.wolfcode.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.IdentityHashMap;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;

    // /deparment/list
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") EmployeeQueryObject qo){
        model.addAttribute("pageResult", employeeService.query(qo));
        model.addAttribute("depts",departmentService.listAll());
        return "employee/list"; // /WEB-INF/views/employee/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id){
        if(id != null){
            employeeService.delete(id);
        }
        return "redirect:/employee/list";
    }

    // 去新增或修改页面
    @RequestMapping("/input")
    public String input(Long id, Model model){
        // 把所有部门查询来在页面显示
        model.addAttribute("depts",departmentService.listAll());
        if(id != null){ // 想去修改
            model.addAttribute("employee", employeeService.get(id));
        }
        return "employee/input"; // /WEB-INF/views/employee/input.jsp
    }

    // 新增保存
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee employee){
        System.out.println(employee.getDept().getId());
        if(employee.getId() != null){
            employeeService.update(employee);
        }else{
            employeeService.save(employee);
        }
        return "redirect:/employee/list";
    }

}
