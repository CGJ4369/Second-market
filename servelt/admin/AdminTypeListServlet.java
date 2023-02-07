package com.cgj.servelt.admin;

import com.cgj.model.Type;
import com.cgj.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/type_list")
public class AdminTypeListServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Type> list =tService.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/admin/type_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
