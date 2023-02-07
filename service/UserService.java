package com.cgj.service;

import com.cgj.dao.UserDao;
import com.cgj.model.Page;
import com.cgj.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao uDao = new UserDao();
    public boolean Register(User user){
        try {
            if(uDao.isUsernameExist(user.getUsername())){
                return false;
            }
            if (uDao.isEmailExist(user.getEmail())){
                return false;
            };
            uDao.addUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String ue,String password){
        User user = null;
        try {
            user = uDao.selectByUsernamePassword(ue,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user!=null){
            return user;
        }
        try {
            user = uDao.selectByEmailPassword(ue,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user!=null){
            return user;
        }
        return null;
    }
    public User selectById(int id){
        User u = null;
        try {
            u = uDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;

    }
    public void updateUserAddress(User user){
        try {
            uDao.updateUserAddress(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePwd(User user){
        try {
            uDao.updatePwd(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Page getUserPage(int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int pageSize = 7;
        int totalCount = 0;
        try {
            totalCount= uDao.selectUserCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize, totalCount);
        List list = null;
        try {
            list = uDao.selectUserList(pageNo,pageSize);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public boolean delete(int id){
        try {
            uDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
