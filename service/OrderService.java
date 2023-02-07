package com.cgj.service;

import com.cgj.dao.OrderDao;
import com.cgj.model.Order;
import com.cgj.model.OrderItem;
import com.cgj.model.Page;
import com.cgj.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class OrderService {
    private OrderDao oDao = new OrderDao();
    public void addOrder(Order order){
        Connection con =null;
        try {
             con = DBUtil.getConnection();
            con.setAutoCommit(false);

            oDao.insertOrder(con,order);
            int id = oDao.getLastInsertId(con);
            order.setId(id);
            for (OrderItem item:order.getItemMap().values()){
                oDao.insertOrderItem(con,item);
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if(con!=null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }
        }

    }
    public List<Order> selectAll(int userid){
        List<Order> list = null;
        try {
            list = oDao.selectAll(userid);
            for (Order o :list){
              List<OrderItem> l =oDao.selectAllItem(o.getId());
              o.setItemList(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Page getOrderPage(int status,int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 10;
        int totalCount = 0;
        try {
            totalCount= oDao.getOrderCount(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);
        List list = null;
        try {
            list = oDao.selectOrderList(status,pageNo,pageSize);
            for (Order o :(List<Order>)list){
                List<OrderItem> l =oDao.selectAllItem(o.getId());
                o.setItemList(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    public void updateStatus(int id,int status){
        try {
            oDao.updateStatus(id,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        Connection con=null;
        try {
            con=DBUtil.getDataSource().getConnection();
            con.setAutoCommit(false);
            oDao.deleteOrderItem(con,id);
            oDao.deleteOrder(con,id);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if(con!=null){
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
            }

        }
    }


}
