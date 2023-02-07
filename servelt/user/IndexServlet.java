package com.cgj.servelt.user;

import com.cgj.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private GoodsService gService=new GoodsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得条幅商品
        Map<String, Object> scrollGoods =gService.getScrollGoods();
        req.setAttribute("scroll",scrollGoods);
        //取得好物商品
        List<Map<String, Object>> goodlist = gService.getGoodGoodsList();
        req.setAttribute("goodList",goodlist);

        //取得实用商品
        List<Map<String, Object>> praticalList = gService.getpraticalGoodsList();
        req.setAttribute("praticalList",praticalList);

        //跳转index.jsp
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
