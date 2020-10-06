package com.jk.service.impl;

import com.jk.dao.JKDao;
import com.jk.dao.impl.JKDaoImpl;
import com.jk.pojo.JK;
import com.jk.pojo.Page;
import com.jk.service.JKService;

import java.util.List;

/**
 * @author xwj157
 * @create 2020-08-13 14:02
 */
public class JKServiceImpl implements JKService {

    private JKDao jkDao = new JKDaoImpl();

    @Override
    public void addJK(JK jk) {
        jkDao.addJK(jk);
    }

    @Override
    public void deleteJKById(Integer id) {
        jkDao.deleteJKById(id);
    }

    @Override
    public void updateJK(JK jk) {
        jkDao.updateJK(jk);
    }

    @Override
    public JK queryJKById(Integer id) {
        return jkDao.queryJKById(id);
    }

    @Override
    public List<JK> queryJKs() {
        return jkDao.queryJKs();
    }

    @Override
    public Page<JK> page(int pageNo, int pageSize) {
        Page<JK> page = new Page<JK>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = jkDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        List<JK> items = jkDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<JK> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<JK> page = new Page<JK>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = jkDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        List<JK> items = jkDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);

        return page;
    }
}
