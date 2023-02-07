package com.cgj.servelt.user;

import com.cgj.model.Goods;
import com.cgj.model.Page;
import com.cgj.model.Type;
import com.cgj.service.GoodsService;
import com.cgj.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    private TypeService tService = new TypeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=0;
        if(req.getParameter("id")!=null){
            id=Integer.parseInt(req.getParameter("id"));
        }

        int pageNo=1;
        if(req.getParameter("pageNo")!=null){
            pageNo=Integer.parseInt(req.getParameter("pageNo"));
        }
//        List<Goods> list=gService.selectGoods(id,pageNo,8);
//        req.setAttribute("list",list);

        Page p = gService.getGoodsPage(id,pageNo);
        req.setAttribute("p",p);
        req.setAttribute("id",id);
        //System.out.println(p.getTotalCount());//控制台测试一下
        Type t =null;
        if(id!=0){
           t = tService.select(id);
        }
        req.setAttribute("t",t);

        req.getRequestDispatcher("/goods_list.jsp").forward(req,resp);
    }
}
