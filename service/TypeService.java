package com.cgj.service;

import com.cgj.dao.TypeDao;
import com.cgj.model.Type;

import java.sql.SQLException;
import java.util.List;

public class TypeService {
    private TypeDao tDao = new TypeDao();
    public List<Type> selectAll(){
        List<Type> list = null;
        try {
            list = tDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Type select(int id){
        Type t = null;
        try {
            t = tDao.select(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
     }

     public void insert(Type t){
         try {
             tDao.insert(t);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public void update(Type t){
         try {
             tDao.update(t);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public boolean delete(int id){
         try {
             tDao.delete(id);
             return true;
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }

    }
}
