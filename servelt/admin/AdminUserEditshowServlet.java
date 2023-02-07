package com.cgj.servelt.admin;

import com.cgj.model.User;
import com.cgj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/user_editshow")
public class AdminUserEditshowServlet extends HttpServlet {
    private UserService uService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = uService.selectById(id);
        req.setAttribute("u",user);
        req.getRequestDispatcher("/admin/user_edit.jsp").forward(req,resp);
    }
}
