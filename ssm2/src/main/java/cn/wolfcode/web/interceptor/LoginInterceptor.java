package cn.wolfcode.web.interceptor;

import cn.wolfcode.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    // return false 执行拦截，不会执行处理器方法
    // return true 放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 没有登录
        Object obj = request.getSession().getAttribute("EMP_IN_SESSION");
        if(obj == null){
            // 跳转登录页面
            response.sendRedirect("/login.jsp");
            return false; // 拦截
        }
        // 有登录
        return true;
    }
}
