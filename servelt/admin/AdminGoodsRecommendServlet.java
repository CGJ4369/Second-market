package com.cgj.servelt.admin;

import com.cgj.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods_recommend")
public class AdminGoodsRecommendServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String method = req.getParameter("method");
        int typeTarget = Integer.parseInt(req.getParameter("typeTarget"));
        if(method.equals("add")){
            gService.addRecommend(id,typeTarget);
        }else {
            gService.removeRecommend(id,typeTarget);
        }
        req.getRequestDispatcher("/admin/goods_list").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
