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

@WebServlet("/user_changeaddress")
public class UserChangeAddressServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User)req.getSession().getAttribute("user");
        try {
            BeanUtils.copyProperties(loginUser,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        uService.updateUserAddress(loginUser);
        req.setAttribute("message","收件信息更新成功");
        req.getRequestDispatcher("/user_center.jsp").forward(req,resp);
    }
}
