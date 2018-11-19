package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/login")
    public String login(String name, String password, Model model, HttpSession session){
        Employee e = employeeService.login(name, password);
        if(e == null){
            model.addAttribute("error", "用户名或者密码错误");
            return "forward:/login.jsp";
        }
        session.setAttribute("EMP_IN_SESSION", e); // 存标识，代表登录
        return "redirect:/employee/list";
    }
}
