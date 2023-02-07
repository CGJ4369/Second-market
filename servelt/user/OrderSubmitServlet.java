package com.cgj.servelt.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user")!=null){
            req.getRequestDispatcher("/order_submit.jsp").forward(req,resp);
        }else{
            req.setAttribute("failMsg","请登录后再提交订单");
            req.getRequestDispatcher("/user_login.jsp").forward(req,resp);
        }
    }
}
