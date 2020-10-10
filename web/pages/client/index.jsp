<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0" >
    <title>兔姬舍主页</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function (){
            $("button.addToCart").click(function (){
                var jkId = $(this).attr("jkId");
                location.href = "cartServlet?action=addItem&id=" + jkId;
            });
        });
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/rabbit.jpg">
    <span class="wel_word">兔姬舍</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临兔姬舍</span>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
            <a href="orderClientServlet?action=showAll">我的订单</a>
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="userServlet?action=authentication">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="jk">
        <div class="jk_cond">
            <form action="client/jkServlet" method="get">
                <input type="hidden"  name="action" value="pageByPrice">
                价格：<input id="min" style="width: 30px" type="text" name="min" value="${param.min}"> 元 —
                <input id="max" style="width: 30px" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <span>您的购物车中没有小裙裙噢</span>
                <div><br/></div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <span>您的购物车中有${sessionScope.cart.totalCount}件jk</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>

        <c:forEach items="${requestScope.page.items}" var="jk">
        <div class="b_list" >
            <div class="img_div">
                <img class="jk_img"  alt="" src="static/img/${jk.imgPath}"/>
            </div>
            <div class="jk_info">
                <div class="jk_name">
                    <span class="sp1">裙裙:</span>
                    <span class="sp2">${jk.name}</span>
                </div>
                <div class="jk_author">
                    <span class="sp1">作者:</span>
                    <span class="sp2">${jk.author}</span>
                </div>
                <div class="jk_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">${jk.price}</span>
                </div>
                <div class="jk_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">${jk.sales}</span>
                </div>
                <div class="jk_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">${jk.stock}</span>
                </div>
                <div class="jk_add">
                    <button jkId="${jk.id}" class="addToCart">加入购物车</button>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>