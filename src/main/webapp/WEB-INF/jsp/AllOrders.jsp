<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/Adminbackgroundshipment/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/Adminbackgroundshipment/css/main.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/Adminbackgroundshipment/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/Adminbackgroundshipment/js/jquery-1.8.3.min.js" ></script>
</head>
<body>

	
	<div style="width: 200px;height: 170px;background-color: white;position: fixed; z-index: 999;margin-left:85%;margin-top: 35%" id="xinxiaoxi">
			<a href="Adminbackgroundshipment"><img width="200px;" height="170px" alt="" src="<%=request.getContextPath()%>/static/Adminbackgroundshipment/images/gaoxiao.gif"></a>
	</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="javascript:return false;"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/allOrders.do"><i class="icon-font">&#xe008;</i>全部订单</a></li>
                        <li><a href="/noShipped.do"><i class="icon-font">&#xe005;</i>待发货</a></li>
                        <li><a href="/completedOrders.do"><i class="icon-font">&#xe006;</i>已完成</a></li>
                        <li><a href="/returnOrders.do"><i class="icon-font">&#xe008;</i>退货订单</a></li>
                        <li><a href="/findOrders.do"><i class="icon-font">&#xe006;</i>查询订单</a></li>
                        <li><a href="/userMM.do"><i class="icon-font">&#xe005;</i>注册用户管理</a></li>
                        <li><a href="/exitBS.do"  class="left03_c">安全退出</a></li>
                    </ul>
                </li>
              
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="javascript:return false;" color="#white">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单查询</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">

            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                   
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>订单时间</th>
                            <th>订单商品名字</th>
                            <th>购买者用户名</th>
                            <th>订单价格</th>
                            <th>状态</th>
                        </tr>
             <c:forEach items="${orders}" var="orders">
                        <tr>
                            <td>${orders.orderTime}</td>
                            <td><a target="_blank" href="">${orders.orderCName}</a>
                            </td>
                            <td>${orders.orderUserName}</td>
                            <td>${orders.orderPrice}</td>
                            <td style="color: red"><c:choose>
                          							    <c:when test="${orders.orderStat=='1'}">已下单</c:when>
														<c:when test="${orders.orderStat=='2'}">已发货</c:when>
														<c:when test="${orders.orderStat=='3'}">退货中</c:when>
														<c:when test="${orders.orderStat=='4'}">订单完成</c:when>
                            	<c:otherwise>退货完成</c:otherwise>
                            
                            </c:choose> </td> <!--订单时间-->
                        </tr>
			</c:forEach>
                    </table>
                   <!--  <div class="list-page"> 2 条 1/1 页</div> -->
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
    //xinxiaoxi
    $(document).ready(function(){	
    	$("#xinxiaoxi").hide();
    });
    function time(){ 
		//alert("我3秒出来一次.");
		//每过一段时间向后台请求查询 是否有新的订单
		//countordertable
		var html = "";
		$.post("countordertable",function(test) {
			var ht = eval("("+test+ ")");
			$.each(ht,function(index,m) {
							html+=m;
						
							});
			//alert(html);
			if(html=="无新订单"){
				//没有订单
			}else{
				$("#xinxiaoxi").show();
			}
			html = "";
			
		});
		
		}setInterval("time()",20000);
		
		function fuck(){
			$("#xinxiaoxi").hide();
		}setInterval("fuck()",10000);
    </script>
    <!--/main-->
</div>
	
</body>
</html>