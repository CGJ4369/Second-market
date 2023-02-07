package com.cgj.servelt.user;

import com.cgj.model.User;
import com.cgj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
    private UserService uService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ue=req.getParameter("ue");
        String password = req.getParameter("password");
        User user = uService.login(ue,password);
        if (user==null){
            req.setAttribute("fMessage","用户名、邮箱或者密码错误，请重新登录");//fMessage是失败的时候的信息
            req.getRequestDispatcher("/user_login.jsp").forward(req,resp);
        }else{
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/user_center.jsp").forward(req,resp);
        }
    }
}
