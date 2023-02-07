package com.cgj.servelt.admin;

import com.cgj.model.Goods;
import com.cgj.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods_editshow")
public class AdminGoodsEditshowServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Goods g =gService.getById(id);
        req.setAttribute("g",g);
        req.getRequestDispatcher("/admin/goods_edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
