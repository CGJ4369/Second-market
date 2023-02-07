package com.cgj.servelt.admin;

import com.cgj.model.Page;
import com.cgj.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status=0;
        if(req.getParameter("status")!=null){
            status=Integer.parseInt(req.getParameter("status"));
        }
        req.setAttribute("status",status);
        int pageNo=1;
        if(req.getParameter("pageNo")!=null){
            pageNo=Integer.parseInt(req.getParameter("pageNo"));
        }
        Page p = oService.getOrderPage(status,pageNo);
        req.setAttribute("p",p);
        req.getRequestDispatcher("/admin/order_list.jsp").forward(req,resp);
    }
}
