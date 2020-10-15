<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>兔姬舍会员注册页面</title>
<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$(function (){
				$("#code_img").click(function (){
					this.src = "${basePath}kaptcha.jpg?d=" + new Date();
				});
			});

			$("#sub_btn").click(function (){
                var usernameText = $("#username").val();
                var usernamepatt = /^\w{5,12}$/;
                if(!usernamepatt.test(usernameText)){
                    $("span.errorMsg").text("用户不合法");
                    return false;
                }

                var passwordText = $("#password").val();
                var passwordpatt = /^\w{5,12}$/;
                if(!passwordpatt.test(passwordText)){
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }

                var repwdText = $("#repwd").val();
                if(repwdText != passwordText){
                    $("span.errorMsg").text("确认密码和密码不一致");
                    return false;
                }

                var emailText = $("#email").val();
                var emailpatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!emailpatt.test(emailText)){
                    $("span.errorMsg").text("邮箱格式不合法");
                    return false;
                }

                var codeText = $("#code").val();
                var codeText = $.trim(codeText);
                if(codeText == null || codeText == ""){
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }

                $("span.errorMsg").text("");
			});


		});


	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/rabbit.jpg" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册显微镜会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
									value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
									value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"
									value="${requestScope.email}"/>
									<br />
									<br />
									<label>&nbsp;验证码&nbsp;：</label>
									<input class="itxt" type="text" name="code" style="width: 90px;" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 45px; width: 105px; height: 40px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>