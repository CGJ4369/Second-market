package com.cgj.servelt.admin;

import com.cgj.model.Page;
import com.cgj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/user_list")
public class AdminUserListServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=1;
        if(req.getParameter("pageNo")!=null){
            pageNo=Integer.parseInt(req.getParameter("pageNo"));
        }
        Page p = uService.getUserPage(pageNo);
        req.setAttribute("p",p);
        req.getRequestDispatcher("/admin/user_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
