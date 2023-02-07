package com.cgj.servelt.admin;

import com.cgj.model.Type;
import com.cgj.service.TypeService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {
    private TypeService typeService =new TypeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Type t =new Type();
        try {
            BeanUtils.copyProperties(t,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        typeService.update(t);
        req.getRequestDispatcher("/admin/type_list").forward(req,resp);
    }
}
