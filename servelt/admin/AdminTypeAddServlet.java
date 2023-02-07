package com.cgj.servelt.admin;

import com.cgj.model.Type;
import com.cgj.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/type_add")
public class AdminTypeAddServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name = req.getParameter("name");
        tService.insert(new Type(name));
        req.getRequestDispatcher("/admin/type_list").forward(req,resp);
    }


}
