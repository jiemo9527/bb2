<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" href="<%=request.getContextPath()%>/static/Houtai/css/style.css" type="text/css" />
	<script
	src="<%=request.getContextPath()%>/static/Homepage/js/sHover.min.js"></script>
	<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/jquery-1.8.3.min.js"></script>


<%--<script--%>
<%--src="<%=request.getContextPath()%>/static/adminjs/chaxunjs.js"></script>--%>


<title>用户管理</title>
</head>
<body>	
<script >
var $=function(id) {
   return document.getElementById(id);
}

function show_menu(num){
for(i=0;i<100;i++){
	if($('li0'+i)){
	$('li0'+i).style.display='none';
	$('f0'+i).className='';
	 }
}
	  $('li0'+num).style.display='block';//触发以后信息块
	  $('f0'+num).className='left02down01_xia_li';//触发以后TAG样式
}

function show_menuB(numB){
	for(j=0;j<100;j++){
		 if(j!=numB){
			if($('Bli0'+j)){
		  $('Bli0'+j).style.display='none';
		  $('Bf0'+j).style.background='url(<%=request.getContextPath()%>/static/Houtai/images/01.gif)';
		}
		 }
	}
	if($('Bli0'+numB)){
		if($('Bli0'+numB).style.display=='block'){
		  $('Bli0'+numB).style.display='none';
		 $('Bf0'+numB).style.background='url(<%=request.getContextPath()%>/static/Houtai/images/01.gif)';
		}else {
		  $('Bli0'+numB).style.display='block';
		  $('Bf0'+numB).style.background='url(<%=request.getContextPath()%>/static/Houtai/images/02.gif)';
		}
	}
}


var temp=0;
function show_menuC(){
		if (temp==0){
		 document.getElementById('LeftBox').style.display='none';
	  	 document.getElementById('RightBox').style.marginLeft='0';
		 document.getElementById('Mobile').style.background='url(<%=request.getContextPath()%>/static/Houtai/images/center.gif)';

		 temp=1;
		}else{
		document.getElementById('RightBox').style.marginLeft='222px';
	   	document.getElementById('LeftBox').style.display='block';
		document.getElementById('Mobile').style.background='url(<%=request.getContextPath()%>/static/Houtai/images/center0.gif)';

	   temp=0;
			}
	 }
</script>
</head>

</body>
<div class="header">
	<div class="header03"></div>
	<div class="header01"></div>
	<div class="header02">注册用户信息管理系统</div> 
	
</div>
<div class="left" id="LeftBox">
	<div class="left01">
		<div class="left01_right"></div>
		<div class="left01_left"></div>
		<div class="left01_c">超级管理员：admin</div>
	</div>
	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c">用户信息管理</div>
		</div>
	  <div class="left02down">
			<div class="left02down01"><a  onclick="show_menuB(80)" href="javascript:;"><div id="Bf080" class="left02down01_img"></div>用户信息查询</a></div>
			<div class="left02down01_xia noneBox" id="Bli080">
				<ul>
					<li onmousemove="show_menu(10)" id="f010"><a href="#">&middot;精确查询</a></li>
					<li onmousemove="show_menu(11)" id="f011"><a href="#">&middot;组合条件查询</a></li>
				</ul>
			</div>
		    <div class="left02down01"><a onclick="show_menuB(81)" href="javascript:;">
		      <div id="Bf081" class="left02down01_img"></div>
		      用户密码管理</a></div>
			<div class="left02down01_xia noneBox" id="Bli081">
				<ul>
					<li onmousemove="show_menu(12)" id="f012"><a href="#">&middot;找回密码</a></li>
					<li onmousemove="show_menu(13)" id="f013"><a href="#">&middot;更改密码</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="left02">
		<div class="left02top">
			<div class="left02top_right"></div>
			<div class="left02top_left"></div>
			<div class="left02top_c">系统管理</div>
		</div>
		<div class="left02down">
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>权限管理</a></div>
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>用户组管理</a></div>
			<div class="left02down01"><a href="#"><div class="left02down01_img"></div>操作日志</a></div>
		</div>
	</div>
	<div class="left01">
		<div class="left03_right"></div>
		<div class="left01_left"></div>
		<a href="/exitBS.do"  class="left03_c">安全退出</a>
	</div>
</div>
<div class="rrcc" id="RightBox">
	<div class="center" id="Mobile" onclick="show_menuC()"></div>
	<div class="right" id="li010">
		<div class="right01"><img src="<%=request.getContextPath()%>/static/Houtai/images/04.gif" /> 用户信息查询 &gt; <span>精确查询</span></div>
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">


  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
        <TR>
          <th align="center"><input type="checkbox" name="checkbox" id="checkbox"></th>
          <th align="center">用户账号</th>
          <th align="center">联系电话</th>
          <th align="center">地址</th>
          <th align="center">审核状态</th>
          <th width="160" align="center">操作</th>
          </TR>

        <TR>
          <TD align="center"><input type="checkbox" name="checkbox2" id="checkbox2"></TD>
          <TD align="center">${user.userName}</TD>
          <TD align="center">${user.userPhone}</TD>
          <TD align="center">${user.userAddress}</TD>
          <TD align="center">${user.userState}</TD>
         
          <TD width="160" align="center">
			<BUTTON style="height:21px; font-size:12px" onClick="javascript:if (confirm('通过审核？'))
			location.href='approvedUser.do?userName=${user.userName}';else return;">通过审核</BUTTON>
			<BUTTON style="height:21px; font-size:12px" onClick="javascript:if (confirm('通过审核？'))
					location.href='freezeUser.do?userName=${user.userName}';else return;">冻结账号</BUTTON></TD>
        </TR>

      </table>
    </div>
  </td>
  </tr>
</table>

	</div>
	
	<div class="right noneBox" id="li011">
		<div class="right01"><img src="<%=request.getContextPath()%>/static/Houtai/images/04.gif" /> 用户信息查询 &gt; <span>组合条件查询</span></div>


		<form action="/Cquery.do" method="post">
		请输入要查询的内容:<input type="text" name="usertext" placeholder="根据用户名查询" >
		<input type="submit" value="查询"></form>
		<br>
		<div id="chaxunqu"></div>

		<form action="/Cquery.do" method="post">
		请输入要查询的内容:<input type="text" name="usertext2" placeholder="根据手机查询" >
		<input type="submit" value="查询"></form>
		<br>

		<div id="chaxunqu2"></div>

		
	</div>
	<div class="right noneBox" id="li012">
		<div class="right01"><img src="<%=request.getContextPath()%>/static/Houtai/images/04.gif" /> 用户密码管理 &gt; <span>找回密码</span></div>
	</div>
	<div class="right noneBox" id="li013">
		<div class="right01"><img src="<%=request.getContextPath()%>/static/Houtai/images/04.gif" /> 用户密码管理 &gt; <span>更改密码</span></div>
	</div>
</div>


</body>

</html>