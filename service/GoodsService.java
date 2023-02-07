package com.cgj.service;

import com.cgj.dao.GoodsDao;
import com.cgj.model.Goods;
import com.cgj.model.Page;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsService {
    private GoodsDao gDao = new GoodsDao();
    public List<Map<String, Object>> getGoodGoodsList(){
        List<Map<String, Object>> list=null;
        try {
             list = gDao.getGoodsList(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String,Object>> getpraticalGoodsList(){
        List<Map<String, Object>> list=null;
        try {
            list = gDao.getGoodsList(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Object> getScrollGoods(){
        Map<String, Object> map=null;
        try {
            map = gDao.getScrollGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

//    public List<Goods> selectGoods(int typeId, int pageNo, int pageSize){
//        List<Goods> list = null;
//        try {
//            list = gDao.selectGoods(typeId,pageNo,pageSize);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }

    public Page getGoodsPage(int typeId, int pageNo){
        Page p = new Page();
        p.setPageNo(pageNo);
        int totalCount = 0;
        try {
            totalCount= gDao.getGoodsCount(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(8, totalCount);
        List list = null;
        try {
            list = gDao.selectGoods(typeId,pageNo,8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;

    }

    public Page getGoodsRecommendPage(int type, int pageNo){
        Page p = new Page();
        p.setPageNo(pageNo);
        int totalCount = 0;
        try {
            totalCount= gDao.selectGoodsRecommendCount(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(8, totalCount);
        List list = null;
        try {
            list = gDao.selectGoodsRecommend(type,pageNo,8);
            for (Goods g : (List<Goods>)list){
                g.setScroll(gDao.isScroll(g));
                g.setGood(gDao.isGood(g));
                g.setPratical(gDao.isPratical(g));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Goods getById(int id){
        Goods g = null;
        try {
            g = gDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    public Page getSearchGoodsPage(String keyword, int pageNo) {
        Page p = new Page();
        p.setPageNo(pageNo);
        int totalCount = 0;
        try {
            totalCount = gDao.getSearchCount(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(8, totalCount);
        List list = null;
        try {
            list = gDao.selectSearchGoods(keyword,pageNo,8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public void addRecommend(int id ,int type){
        try {
            gDao.addRecommend(id,type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeRecommend(int id ,int type){
        try {
            gDao.removeRecommend(id,type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Goods goods){
        try {
            gDao.insert(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Goods goods){
        try {
            gDao.update(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            gDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
