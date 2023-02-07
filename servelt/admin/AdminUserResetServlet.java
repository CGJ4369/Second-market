package com.cgj.servelt.admin;

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

@WebServlet("/admin/user_reset")
public class AdminUserResetServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User u = new User();
        try {
            BeanUtils.copyProperties(u,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        uService.updatePwd(u);

        //如果转发servlet路径要在路径所对应的servlet添加对应的dopost或doget
        req.getRequestDispatcher("/admin/user_list").forward(req,resp);
    }
}
