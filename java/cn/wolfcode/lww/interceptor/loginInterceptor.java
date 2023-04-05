package cn.wolfcode.lww.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {
/*alt+insert  重写方法
* http://localhost:8080/cover/heading/1.jepg   硬盘虚拟映射
* */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(); //获取session
        Object user = session.getAttribute("user");  // 获取user
        if(user!=null){  //判断是否有这个值
            return true; //放行
        }else{  //没有这个值重定向/loginView，返回登录页面
            response.sendRedirect("/loginView");
            return false;
        }

    }
}
