<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/Adminbackgroundshipment/layui/css/layui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/Adminbackgroundshipment/layui/css/sccl.css">
	
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/Adminbackgroundshipment/js/jquery-1.8.3.min.js" ></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单物流后台管理</title>
</head>
<body class="login-bg">
    <div class="login-box">
        <header>
            <h1>BB发货管理系统</h1>
        </header>
        <div class="login-main">
			<form action="/bsl_back.do" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden" value="">                
				<div class="layui-form-item">
					<label class="login-icon">
					</label>
					<input type="text" id="user" name="userName" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="login-icon">
					</label>
					<input type="password" id="pass" name="passWord" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				
					<div style="color: red;font-size: 16px;margin: -8px 0 14px 95px;">
						${msg}
					</div>
				
				<div class="layui-form-item">
					<div class="pull-left login-remember">

					</div>
					<div class="pull-right">

						<input type="submit" class="layui-btn layui-btn-primary" value="登陆">
					</div>
					<div class="clear"></div>
				</div>
			</form>        
		</div>
        <footer>
            <p>jie ©jiemo-one.top</p>
        </footer>
    </div>
    <script type="text/html" id="code-temp">
    </script>
    <script src="<%=request.getContextPath()%>/static/Adminbackgroundshipment/layui/layui.js"></script>

  </body>
</html>