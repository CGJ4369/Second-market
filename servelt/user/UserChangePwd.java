package com.cgj.servelt.user;

import com.cgj.model.User;
import com.cgj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_changepwd")
public class UserChangePwd extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String newPwd = req.getParameter("newPassword");
        User u =(User)req.getSession().getAttribute("user");
        if(password.equals(u.getPassword())){
            u.setPassword(newPwd);
            uService.updatePwd(u);
            req.setAttribute("message","密码修改成功！");
            req.getRequestDispatcher("/user_center.jsp").forward(req,resp);
        }else{
            req.setAttribute("fMessage","原密码不正确");
            req.getRequestDispatcher("/user_center.jsp").forward(req,resp);
        }
    }
}
