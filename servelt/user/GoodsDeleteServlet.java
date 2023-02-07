package com.cgj.servelt.user;

import com.cgj.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods_delete")
public class GoodsDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order o = (Order) req.getSession().getAttribute("order");
        int goodsid = Integer.parseInt(req.getParameter("goodsid"));
        o.delete(goodsid);
        resp.getWriter().print("ok");

    }



}
