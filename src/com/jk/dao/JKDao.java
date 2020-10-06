package com.jk.dao;

import com.jk.pojo.JK;

import java.util.List;


/**
 * @author xwj157
 * @create 2020-08-13 13:29
 */
public interface JKDao {
    public int addJK(JK jk);

    public int deleteJKById(Integer id);

    public int updateJK(JK jk);

    public JK queryJKById(Integer id);

    public List<JK> queryJKs();

    Integer queryForPageTotalCount();

    List<JK> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<JK> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
