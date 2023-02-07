package com.cgj.servelt.user;

import com.cgj.model.Page;
import com.cgj.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/goods_search")
public class GoodsSearchServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword1");
        System.out.println(keyword);
        int pageNo=1;
        if(req.getParameter("pageNo")!=null){
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }
       Page p = gService.getSearchGoodsPage(keyword,pageNo);
        req.setAttribute("p",p);
        req.setAttribute("keyword",URLEncoder.encode(keyword,"utf-8"));
        req.getRequestDispatcher("/goods_search.jsp").forward(req,resp);
    }
}
