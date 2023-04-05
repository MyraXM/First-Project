package cn.wolfcode.lww.controller;

import cn.wolfcode.lww.domain.User;
import cn.wolfcode.lww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession httpSession){
        //调用service 层
        User userResult = userService.queryUserByUserNameAndPwd(user);
        if(userResult!=null){ //查得到，index
            httpSession.setAttribute("user",userResult); //
            return "redirect:index";  //重定向
            //重定向：http://localhost:8080/login?username=13700000000&password=123456 隐藏?username=13700000000&password=123456

        }else{ //返回登录页
            model.addAttribute("errorMsg","用户名或密码错误");
            return "public/login";
        }
    }
    @RequestMapping("/loginView")
    public String loginView(User user){
        //System.out.println("ssss");
        userService.insert(user);
       // System.out.println("插入成功");
        return "public/login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index/index";
    }


   /* @RequestMapping("/loginOut")
    public String loginOut(){
        return "public/login";
    }*/

    @RequestMapping("/register")
    public String register(){
        //
        return "public/register";
    }


  /*  @RequestMapping("/loginView")
    public String loginView(User user){
        userService.insert(user);

        return "public/login";
    }*/
//DataIntegrityViolationException
}
