package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Department;
import cn.wolfcode.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    // /deparment/list
    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("departments", departmentService.listAll());
        return "department/list"; // /WEB-INF/views/department/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id){
        if(id != null){
            departmentService.delete(id);
        }
        return "redirect:/department/list";
    }

    // 去新增页面
    @RequestMapping("/input")
    public String input(Long id, Model model){
        if(id != null){ // 想去修改
            model.addAttribute("department", departmentService.get(id));
        }
        return "department/input"; // /WEB-INF/views/department/input.jsp
    }

    // 新增保存
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department department){
        if(department.getId() != null){
            departmentService.update(department);
        }else{
            departmentService.save(department);
        }
        return "redirect:/department/list";
    }

}
