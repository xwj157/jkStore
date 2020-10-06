package com.jk.service;

import com.jk.pojo.JK;
import com.jk.pojo.Page;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-13 14:00
 */
public interface JKService {

    public void addJK(JK jk);

    public void deleteJKById(Integer id);

    public void updateJK(JK jk);

    public JK queryJKById(Integer id);

    public List<JK> queryJKs();

    Page<JK> page(int pageNo, int pageSize);

    Page<JK> pageByPrice(int pageNo, int pageSize, int min, int max);
}
