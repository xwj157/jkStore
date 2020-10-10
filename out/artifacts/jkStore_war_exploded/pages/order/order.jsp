<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/rabbit.jpg">
    <span class="wel_word">我的订单</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">
    <c:if test="${empty orders}">
        <h1>
            当前没有任何订单，<a href="index.jsp">去购买吧</a>
        </h1>
    </c:if>

    <c:if test="${!empty orders}">
        <table>
            <tr>
                <td>订单号</td>
                <td>日期</td>
                <td>金额</td>
                <td>状态</td>
                <td>详情</td>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderId }</td>
                    <td>${order.createTime}</td>
                    <td>${order.price }</td>
                    <td>
                        <c:if test="${order.status==0 }">
                            未发货
                        </c:if>
                        <c:if test="${order.status==1 }">
                            已发货
                            <br/>
                            <a href="orderClientServlet?action=receive&orderId=${order.orderId}">确认收货</a>
                        </c:if>
                        <c:if test="${order.status==2 }">
                            交易完成
                        </c:if>
                    </td>
                    <td><a href="orderClientServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>