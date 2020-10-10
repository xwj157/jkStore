<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$("a.deleteItem").click(function (){
				return confirm("确定要删除【" + $(this).parent().parent().find("td:nth-child(2)").text() + "】吗？亲");
			});
			$("#clearCart").click(function (){
				return confirm("确定要清空购物车吗？亲");
			});
			$(".updateCount").change(function (){
				if(confirm("确定要将【" + $(this).parent().parent().find("td:nth-child(2)").text() + "】数量修改为" + this.value + "吗？亲")){
					location.href = "cartServlet?action=updateCount&count=" + this.value + "&id=" + $(this).attr('jkId');
				}else{
					this.value = this.defaultValue;
				}
			});
		});

	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/rabbit.jpg" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>款式</td>
				<td>名字</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">亲&nbsp;&nbsp;当前购物车没有宝贝噢！<a href="index.jsp" ><font size="3">快去选购小裙子吧</font></a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>
							<img class="jk_manager_img" style="height:80px ;width:80px" alt="" src="static/img/${entry.value.id}.jpg"/>
						</td>
						<td>${entry.value.name}</td>
						<td>
							<input class="updateCount" style="width: 30px"
								   jkId="${entry.value.id}"
								   type="text" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>


		</table>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderClientServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>
	</div>
	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>