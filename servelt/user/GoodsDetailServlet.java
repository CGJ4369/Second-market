package com.cgj.servelt.user;

import com.cgj.model.Goods;
import com.cgj.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        Goods g = gService.getById(id);
        req.setAttribute("g",g);
        req.getRequestDispatcher("/goods_detail.jsp").forward(req,resp);
    }
}
