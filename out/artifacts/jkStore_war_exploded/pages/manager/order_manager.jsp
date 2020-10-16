<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/rabbit.jpg">
    <span class="wel_word">订单管理</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <c:if test="${empty orders }">
        <h1>还没有任何订单，<a href="index.jsp">返回主页</a></h1>
    </c:if>
    <c:if test="${!empty orders }">
        <table>
            <tr>
                <td>订单号</td>
                <td>日期</td>
                <td>金额</td>
                <td>详情</td>
                <td>发货</td>
            </tr>

            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderId }</td>
                    <td>${order.createTime }</td>
                    <td>${order.price }</td>
                    <td><a href="orderClientServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a></td>
                    <td>
                        <c:if test="${order.status==0 }">
                            <a href="orderManagerServlet?action=send&orderId=${order.orderId }">点击发货</a>
                        </c:if>
                        <c:if test="${order.status==1 }">
                            已发货
                        </c:if>
                        <c:if test="${order.status==2 }">
                            交易完成
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>