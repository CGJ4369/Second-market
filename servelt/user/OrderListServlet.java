package com.cgj.servelt.user;

import com.cgj.model.Order;
import com.cgj.model.User;
import com.cgj.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u =(User) req.getSession().getAttribute("user");
        List<Order> list = oService.selectAll(u.getId());
        req.setAttribute("orderList",list);
        req.getRequestDispatcher("/order_list.jsp").forward(req,resp);
    }
}
