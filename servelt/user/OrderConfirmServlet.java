package com.cgj.servelt.user;

import com.cgj.model.Order;
import com.cgj.model.User;
import com.cgj.service.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet("/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order o =(Order) req.getSession().getAttribute("order");
        try {
            BeanUtils.copyProperties(o,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        o.setDatetime(new Date());
        o.setStatus(2);
        o.setUser((User)req.getSession().getAttribute("user"));
        System.out.println(o.getAddress());
        oService.addOrder(o);
        req.getSession().removeAttribute("order");

        req.setAttribute("msg","订单支付成功");
        req.getRequestDispatcher("/order_success.jsp").forward(req,resp);
    }
}
