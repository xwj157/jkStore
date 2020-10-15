<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑jk信息</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/rabbit.jpg" >
			<span class="wel_word">编辑jk信息</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/jkServlet" method="get">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value="${empty param.id ? "add":"update"}">
				<input type="hidden" name="id" value="${ requestScope.jk.id }">
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
					<tr>
						<td>
						<img class="jk_manager_img" style="height:80px ;width:80px " alt="" src="static/img/${jk.imgPath}"/>
					    </td>
						<td>${requestScope.jk.name}</td>
						<td><input name="price" type="text" value="${requestScope.jk.price}"/></td>
						<td>${requestScope.jk.author}</td>
						<td><input name="sales" type="text" value="${requestScope.jk.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.jk.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>

		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>