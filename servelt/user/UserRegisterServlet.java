package com.cgj.servelt.user;

import com.cgj.model.User;
import com.cgj.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();

        try {
            BeanUtils.copyProperties(user,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(uService.Register(user)){
//            System.out.println("注册成功");
            req.setAttribute("message","注册成功,可以登录了");
            req.getRequestDispatcher("user_login.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("message","用户名或邮箱重复，请重新填写");
            req.getRequestDispatcher("user_register.jsp").forward(req,resp);
        }

    }
}
