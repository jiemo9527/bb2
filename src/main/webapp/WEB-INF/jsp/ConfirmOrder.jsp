<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认订单</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/grids/gridsPay/css/tasp.css" />
<link href="<%=request.getContextPath()%>/static/grids/gridsPay/css/orderconfirm.css" rel="stylesheet" />
	<script
	src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>




</head>

<style>
#page{width:auto;}
#comm-header-inner,#content{width:950px;margin:auto;}
#logo{padding-top:26px;padding-bottom:12px;}
#header .wrap-box{margin-top:-67px;}
#logo .logo{position:relative;overflow:hidden;display:inline-block;width:140px;height:35px;font-size:35px;line-height:35px;color:#f40;}
#logo .logo .i{position:absolute;width:140px;height:35px;top:0;left:0;background:url(http://a.tbcdn.cn/tbsp/img/header/logo.png);}
</style>

<body>
<script type="text/javascript">
	//页面加载时
	$(document).ready(function() {
        //alert("页面加载时");
        var userName = "<%=request.getSession().getAttribute("userName")%>";
        if (userName == "null") {
            alert("请登录之后购买");
            location.href = "login.do";
        }
    });


</script>

	<div id="page">

 <div id="content" class="grid-c">

  <div id="address" class="address" style="margin-top: 20px;" data-spm="2">
<form name="addrForm" id="addrForm" action="#">
<h3>确认收货地址&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${userDetail.userAddress}</span>
 <span class="manage-address">

 <a href="/userAddress.do" target="_blank" title="管理我的收货地址"
 class="J_MakePoint" data-point-url="/userAddress.do">修改收货地址</a>
 </span>
</h3>


</div>
<form id="J_Form" name="J_Form" action="" method="post">
 
           <div>
 <h3 class="dib">确认订单信息</h3>
 <table cellspacing="0" cellpadding="0" class="order-table" id="J_OrderTable" summary="统一下单订单信息区域">
 <caption style="display: none">统一下单订单信息区域</caption>
 <thead>
 <tr>
 <th class="s-title">店铺宝贝<hr/></th>
 <th class="s-price">单价(元)<hr/></th>
 <th class="s-amount">数量<hr/></th>
 <th class="s-agio">优惠方式(元)<hr/></th>
 <th class="s-total">小计(元)<hr/></th>
 </tr>
 </thead>
     


<tbody data-spm="3" class="J_Shop" data-tbcbid="0" data-outorderid="47285539868"  data-isb2c="false" data-postMode="2" data-sellerid="1704508670">
<tr class="first"><td colspan="5"></td></tr>
<tr class="shop blue-line">
 <td colspan="3">
   店铺：<a class="J_ShopName J_MakePoint" data-point-url="http://log.mmstat.com/buy.1.6" href="http://store.taobao.com/shop/view_shop.htm?shop_id=104337282"
 target="_blank" title="bilibili">bilibili</a>
     <span class="seller">卖家：<a href="" target="_blank" class="J_MakePoint" data-point-url="">bilibili</a></span>
     <span class="J_WangWang"  data-nick="bilibili"   data-display="inline" ></span>
    
    </td>
 <td colspan="2" class="promo">
 <div>
   <ul class="scrolling-promo-hint J_ScrollingPromoHint">
       </ul>
   </div>
 </td>
</tr>
 <tr class="item" data-lineid="19614514619:31175333266:35612993875" data-pointRate="0">
 <td class="s-title">
   <a href="#" target="_blank" title="${commodity.commodityName}" class="J_MakePoint" data-point-url="http://log.mmstat.com/buy.1.5">
     <img src="${pageContext.request.contextPath}${commodity.commodityImg}" class="itempic"><span class="title J_MakePoint" data-point-url="http://log.mmstat.com/buy.1.5">${grids.girdsName }</span></a>

   <div class="props">
     <span> </span>
   <span> </span>
   <span> </span>
   <span> </span>
         </div>
 <a title="消费者保障服务，卖家承诺商品如实描述" href="#" target="_blank">
<img src="http://img03.taobaocdn.com/tps/i3/T1bnR4XEBhXXcQVo..-14-16.png"/>
</a>
    <div>
 <span style="color:gray;">卖家承诺72小时内发货</span>
 </div>
     </td>
 <td class="s-price">
   
  <span class='price '>
 <em class="style-normal-small-black J_ItemPrice"  >${commodity.commodityPrice}</em>
  </span>
<input type="hidden" name="costprice" value="630.00" class="J_CostPrice" />
</td>
 <td class="s-amount" id="Cname" Cname="${commodity.commodityName}" >
     <input type="hidden" class="J_Quantity" value="" name="19614514619_31175333266_35612993875_quantity"/>         <input type="hidden" class="J_Quantity" value="" name="19614514619_31175333266_35612993875_quantity"/>
    ${number}

 </td>
 <td class="s-agio">
       <div class="J_Promotion promotion" data-point-url="">无优惠</div>
   </td>
 <td class="s-total">
   
   <span class='price '>

 <em class="style-normal-bold-red J_ItemTotal "  >${commodity.commodityPrice*number}</em>
  </span>
    <input id="furniture_service_list_b_47285539868" type="hidden" name="furniture_service_list_b_47285539868"/>
 </td>
</tr>



<tr class="item-service">
 <td colspan="5" class="servicearea" style="display: none"></td>
</tr>

<tr class="blue-line" style="height: 2px;"><td colspan="5"></td></tr>
<tr class="other other-line">
 <td colspan="5">
 <ul class="dib-wrap">
 <li class="dib user-info">
 <ul class="wrap">
 <li>
  <div class="field gbook">
   <label class="label">给卖家留言：</label>
   <textarea style="width:350px;height:80px;" title="选填：对本次交易的补充说明（建议填写已经和卖家达成一致的说明）" name=""></textarea>
 </div>
</li>
   </ul>
 </li>
 <li class="dib extra-info">

 <div class="shoparea">
 <ul class="dib-wrap">
 <li class="dib title">店铺优惠：</li>
 <li class="dib sel"><div class="J_ShopPromo J_Promotion promotion clearfix" data-point-url="http://log.mmstat.com/buy.1.16"></div></li>
 <li class="dib fee">  <span class='price '>
 -<em class="style-normal-bold-black J_ShopPromo_Result"  >0.00</em>
  </span>
</li>
 </ul>
 </div>

 <div class="shoppointarea"></div>

   <div class="farearea">
 <ul class="dib-wrap J_farearea">
 <li class="dib title">运送方式：</li>
 <li class="dib sel" data-point-url="http://log.mmstat.com/jsclick?cache=*&tyxd=wlysfs">
 
   <select name="select" id="selectsf" class="J_Fare" onchange="xuanzhong()">
       <option data-fare="1500" value="15" data-codServiceType="2" data-level=""  selected="selected"  >
           选择邮寄方式
       </option>
     <option data-fare="1500" value="15" data-codServiceType="2" data-level=""    >
 快递 15.00元 
 </option>
       <option data-fare="2500" value="25" data-codServiceType="7" data-level=""  >
 EMS 25.00元 
 </option>
       <option data-fare="1500" value="5" data-codServiceType="1" data-level=""  >
 平邮 5.00元
 </option>
     </select>
     
     <script type="text/javascript">
			 
     </script>     
     
   <em tabindex="0" class="J_FareFree" style="display: none">免邮费</em>
     </li>
 <li class="dib fee">  <span class='price '>
<!--  <em class="style-normal-bold-red J_FareSum"  >30.00</em> -->
  </span>
</li>
 </ul>
 </div>
   <div class="extra-area">
 <ul class="dib-wrap">
 <li class="dib title">发货时间：</li>
 <li class="dib content">卖家承诺订单在买家付款后，72小时内发货</li>
 </ul>
 </div>
   
   <div class="servicearea" style="display: none"></div>
 </li>
 </ul>
 </td>
</tr>

<tr class="shop-total blue-line">
 <td colspan="5">店铺合计(<span class="J_Exclude" style="display: none">不</span>含运费<span class="J_ServiceText" style="display: none">，服务费</span>)：
   <span class='price g_price '>
 <span>&yen;</span><em class="style-middle-bold-red J_ShopTotal"  ></em>
  </span>


   </td>
</tr>
</tbody>
  <tfoot>
 <tr>
 <td colspan="5">

<div class="order-go" data-spm="4">
<div class="J_AddressConfirm address-confirm">
 <div class="kd-popup pop-back" style="margin-bottom: 40px;">
 <div class="box">
 <div class="bd">
 <div class="point-in">
   
   <em class="t">实付款：</em>  <span class='price g_price '>

 <span>&yen;</span>
     <em class="style-large-bold-red"  id="J_ActualFee" ></em>
  </span>
</div>
<script type="text/javascript">
function xuanzhong(){
	 //获取被选中的option标签
		var total = parseInt(${commodity.commodityPrice*number}) + parseInt($('select option:selected').val());
		$("#J_ActualFee").html(total);
}
</script>
  <ul id="down">
 
 </ul>
     </div>
 </div>



         <a href="/shoppingCar.do"
 class="back J_MakePoint" target="_top"
 data-point-url="">返回购物车</a>
     <a href="#" id="sub" class=" btn-go"  style="background-color: orange;" >提交订单</a>
     <b class="dpl-button"></b>

     <script>



             $("#sub").click(function () {
                 var Cprice=$("#J_ActualFee").html();
                 var Cname=$("#Cname").attr("Cname");
                 location.href="submitOrders2.do?Cname="+Cname+"&Cprice="+Cprice;

             })

     </script>

 </div>
 </div>

 <div class="J_confirmError confirm-error">
 <div class="msg J_shopPointError" style="display: none;"><p class="error">积分点数必须为大于0的整数</p></div>
 </div>


 <div class="msg" style="clear: both;">
 <p class="tips naked" style="float:right;padding-right: 0">若价格变动，请在提交订单后联系卖家改价，并查看已买到的宝贝</p>
 </div>
 </div>
 </td>
 </tr>
 </tfoot>
 </table>
</div>

</form>
</div>

		
		
</body>

</html>