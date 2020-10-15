package com.jk.servlet;

import com.jk.pojo.JK;
import com.jk.pojo.Page;
import com.jk.service.JKService;
import com.jk.service.impl.JKServiceImpl;
import com.jk.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JKServlet extends BaseServlet {
    private JKService jkService = new JKServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
        JK jk = WebUtils.copyParamToBean(req.getParameterMap(), new JK());
        jkService.addJK(jk);
        resp.sendRedirect(req.getContextPath() + "/manager/jkServlet?action=page&pageNo=" + pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        jkService.deleteJKById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/jkServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JK jk = WebUtils.copyParamToBean(req.getParameterMap(), new JK());
        jkService.updateJK(jk);
        resp.sendRedirect(req.getContextPath() + "/manager/jkServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getJK(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        JK jk = jkService.queryJKById(id);
        req.setAttribute("jk", jk);
        req.getRequestDispatcher("/pages/manager/jk_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JK> jks = jkService.queryJKs();
        req.setAttribute("jks", jks);
        req.getRequestDispatcher("/pages/manager/jk_manager.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<JK> page = jkService.page(pageNo, pageSize);
        page.setUrl("manager/jkServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/jk_manager.jsp").forward(req, resp);
    }

}
