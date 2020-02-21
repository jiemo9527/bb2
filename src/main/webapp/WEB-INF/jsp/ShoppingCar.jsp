<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户购物车</title>
<%-- <script src="<%=request.getContextPath()%>/static/gouwuche/js/js.js"></script>--%>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/gouwuche/css/css.css" />
	<script
	src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>

</head>
<body>

<script type="text/javascript">

$(document).ready(function() {
		var userName="<%=request.getSession().getAttribute("userName")%>";
		if(userName==""||userName=="null"){
			location.href = "/index.do";
		}
});

</script>


<table id="cartTable" align="center" width="100%">
  <thead>
   <tr class="order_content">
    <th><input class="check_all check" type="checkbox"></input> 全选</th>
    <th>商品</th>
    <th>名称</th>
    <th>单价</th>
    <th>数量</th>
    <th>小计</th>
    <th>操作</th>
<!--     <th style="display: none">ID</th> -->
   </tr>
 
  </thead>
  <tbody>
   <c:forEach items="${goods}" var="goods">
   <tr class="order_content" style="text-align: center">
    <td class="check"><input class = "check_one check" name="box" type="checkbox" Cname="${goods.shoppingName}" Cprice="${goods.shoppingPrice}" CID="${goods.carID}"></td>
    
    <td class="goods"><img width="35px" height="35px" src="${pageContext.request.contextPath}${goods.shoppingImg}"><span>${user.shoopingName}</span></td>
    <td id="Cname">${goods.shoppingName}</td>
    <td class="price">${goods.shoppingPrice}</td>
    <td class="count">
     <span class="reduce">-</span>
     <input class="count_input" type="text" value="1">
     <span class="add">+</span>
    </td>
    <td class="subtotle">${goods.shoppingPrice}</td>
   <!--  <span class="delete">删除<span> -->
   <td class="operation"><a href="/delShoppingCar.do?cartID=${goods.carID}&shoppingID=${goods.shoppingID}">删除</a></td>

   </tr>
  </c:forEach>
  </tbody>
 
 </table>

 <div class="slected view">
   <div id="selectedViewList" class="clearfix">
    <!-- <div><img src="./imgs/applewatch.png"><span>取消选择</span></div> -->
   </div>
 
   <span class="arrow">.<span>.</span></span>

 </div>
 <div id = "footer" class="footer">  
  <label class="fl select_all" ><input class="check_all check" type="checkbox"> 全选</input></label>
  <a class="fl delete_all" id="deleteAll" href="">删除</a>
  <a href="#" class="fr closing" id="sub">结算</a>
  <div class="fr selected_totle">合计：￥ <span id="priceTotle">0.00</span> </div>
  <div class="fr selectAll" id="selected">已购商品
   <span id = "selectTotle">0</span>件
   <span class="arow up">+++</span>
   <span class="arow down">---</span>
  </div>
 
 </div>

</body>
<script>
 $(".add").click(function () {
  var count=$(".count_input").val();
  $(".count_input").val(parseInt(count)+1);
 });
 $(".reduce").click(function () {
  var count=$(".count_input").val();
  if (count>1){
   $(".count_input").val(parseInt(count)-1);
  }

 });

 $("#sub").click(function () {
  var Cname=$("input[name='box']:checked").attr("Cname");//自定义属性值
  var Cprice=$("input[name='box']:checked").attr("Cprice");
  var CID=$("input[name='box']:checked").attr("CID");
  location.href="submitOrders.do?Cname="+Cname+"&Cprice="+Cprice+"&CID="+CID;
 })
</script>
</html>