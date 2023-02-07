package com.cgj.servelt.admin;

import com.cgj.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/type_delete")
public class AdminTypeDeleteServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = tService.delete(id);
        if(isSuccess){
            req.setAttribute("massage","删除成功");
        }else{
            req.setAttribute("fMassage","该类目包含商品，请先删除商品，再删除该类目");
        }
        req.getRequestDispatcher("/admin/type_list").forward(req,resp);
    }
//??????????????????????????????????????????????????????
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
