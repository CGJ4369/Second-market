package com.cgj.servelt.user;

import com.cgj.model.Goods;
import com.cgj.model.Order;
import com.cgj.service.GoodsService;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
	private GoodsService gService = new GoodsService();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Map<String, String[]> map =request.getParameterMap();
//		for(String key : map.keySet()) {
//			System.out.println(key+":"+map.get(key));
//		}
		Order o = null;
		if(req.getSession().getAttribute("order") != null) {
			o = (Order) req.getSession().getAttribute("order");
		}else {
			o = new Order();
			req.getSession().setAttribute("order", o);
		}
		int goodsid = Integer.parseInt(req.getParameter("goodsid"));
		Goods goods = gService.getById(goodsid);
		if(goods.getStock()>0) {
			o.addGoods(goods);
			resp.getWriter().print("ok");
		}else {
			resp.getWriter().print("fail");
		}
	}
}
