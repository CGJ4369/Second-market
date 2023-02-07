package com.cgj.servelt.user;

import com.cgj.model.Page;
import com.cgj.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsrecommend_list")
public class GoodsRecommendListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type=Integer.parseInt(req.getParameter("type"));;
        int pageNo=1;
        if(req.getParameter("pageNo")!=null){
            pageNo=Integer.parseInt(req.getParameter("pageNo"));
        }
        Page p =gService.getGoodsRecommendPage(type,pageNo);
        req.setAttribute("p",p);
        req.setAttribute("t",type);
        req.getRequestDispatcher("goodsrecommend_list.jsp").forward(req,resp);
    }
}
