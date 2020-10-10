<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>jk管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:nth-child(2)").text() + "】？");
                // return false;
            });
        });

    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/rabbit.jpg">
    <span class="wel_word">jk管理</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>图片</td>
            <td>名字</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="jk">
            <tr>
                <td>
                    <img class="jk_manager_img" style="height:80px ;width:80px " alt="" src="static/img/${jk.imgPath}"/>
                </td>
                <td>${jk.name}</td>
                <td>${jk.price}</td>
                <td>${jk.author}</td>
                <td>${jk.sales}</td>
                <td>${jk.stock}</td>
                <td><a href="manager/jkServlet?action=getJK&id=${jk.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/jkServlet?action=delete&id=${jk.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>