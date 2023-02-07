package com.cgj.servelt.admin;

import com.cgj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/user_delete")
public class AdminUserDeleteServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = uService.delete(id);
        if(isSuccess){
            req.setAttribute("message","客户删除成功");
        }else{
            req.setAttribute("fMessage","客户有订单，请先删除订单，再删除客户");
        }
        req.getRequestDispatcher("/admin/user_list").forward(req,resp);
    }
}
