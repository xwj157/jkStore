package com.jk.dao.impl;


import com.jk.dao.JKDao;
import com.jk.pojo.JK;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-13 13:33
 */
public class JKDaoImpl extends BaseDAO implements JKDao {
    @Override
    public int addJK(JK jk) {
        String  sql = "insert into t_jk(`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath) values(?,?,?,?,?,?)";

        return update(sql,jk.getName(),jk.getAuthor(),jk.getPrice(),jk.getSales(),jk.getStock(),jk.getImgPath());
    }

    @Override
    public int deleteJKById(Integer id) {
        String sql = "delete from t_jk where id = ?";

        return update(sql,id);
    }

    @Override
    public int updateJK(JK jk) {
        String sql = "update t_jk set `price` = ?,`sales` = ?,`stock` = ? where id = ?";
        return update(sql,jk.getPrice(),jk.getSales(),jk.getStock(),jk.getId());
    }

    @Override
    public JK queryJKById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_jk where id = ?";
        return queryForOne(JK.class,sql,id);
    }

    @Override
    public List<JK> queryJKs() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_jk";
        return queryForList(JK.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_jk";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<JK> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_jk limit ?,?";
        return queryForList(JK.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_jk where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<JK> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_jk where price between ? and ? order by price limit ?,?";
        return queryForList(JK.class,sql,min,max,begin,pageSize);
    }
}
