package com.jk.service;

import com.jk.pojo.JK;
import com.jk.pojo.Page;

import java.util.List;


public interface JKService {

    void addJK(JK jk);

    void deleteJKById(Integer id);

    void updateJK(JK jk);

    JK queryJKById(Integer id);

    List<JK> queryJKs();

    Page<JK> page(int pageNo, int pageSize);

    Page<JK> pageByPrice(int pageNo, int pageSize, int min, int max);
}
