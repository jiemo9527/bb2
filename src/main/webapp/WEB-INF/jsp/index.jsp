<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bilibiliIndex/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bilibiliIndex/css/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bilibiliIndex/css/index.css">
<script
	src="${pageContext.request.contextPath}/static/Homepage/js/jquery.min.js"></script>
	<script src='https://libs.baidu.com/jquery/1.10.2/jquery.min.js'></script>
<script
	src="${pageContext.request.contextPath}/static/bilibiliIndex/js/script.js"></script>
	<link rel="stylesheet" href="/static/Homepage/search/css/font-awesome.min.css">
	<link rel="stylesheet" href="/static/Homepage/search/css/style.css">
</head>
<body>



	<header id="header">
	<div id="page_top">
		<div class="bg-wrap">
			<div class="bg"></div>
			<div class="mask"></div>
		</div>
		<div class="header-top">
			<div class="page-width clearfix">
				<div class="header-top__nav">
					<ul>
						<li class="item item-home"><a href="/index.do">主站</a></li>
						<li class="item"><a href="/surrounding.do">商品购买</a>
						<li class="item"><a href="/videoUpload.do">我要投稿</a>
						<li class="item"><a href="#">进入论坛</a></li>




					</ul>
				</div>

				<div class="header-top__user" >
					<div class="search d1"style="float: left" >
						<form id="searchform" method="post">
							<input id="search-input" type="text" placeholder="搜索从这里开始...">
							<button type="submit" onclick="submitsearch()">→</button>
						</form>
					</div>
					<script>

						function submitsearch() {
							value = $('#search-input').val().trim();
							document.getElementById("searchform").action="/search.do?key="+value;
						}

					</script>

					<%
						if (request.getSession().getAttribute("userName") == null) {
					%>
					<div class="login-box">
						<a   href="login.do">登录</a> <span></span>
						<a href="register.do">注册</a>
					</div>
					<% } else { %>

					<div style="height: 42px" onmouseover="project()">
						<div  style="color: white;height: 42px;margin-top: 15px;font-size: 12px;float: right">

							欢迎你的登录:&nbsp;<%=request.getSession().getAttribute("userName") %>
						</div>
						&nbsp;&nbsp;&nbsp;
					</div>
					<%} %>
				</div>
				<div class="header-top__user"
					style="position: fixed; z-index: 999; width: 300px; height: 170px; background-color: #FCF6EB; margin-left: 55%; margin-top: 3%"
					id="div2">
					<div id="kawayi" onmouseout="asjdh()">
						<div
							style="width: 130px; height: 160px; background-color: red; position: fixed; margin-left: 14%">
							<img id="imgtest" alt="" style="width: 130px; height: 160px;"
								onmouseover="project()" onmouseout="about()"
								src="${userDetail.picture}">

						</div>

					</div>
					<div class="center_header">
<%--						<div align="center" style="margin-left: 60%">--%>
<%--							<a href="#"><img width="20px" height="20px"--%>
<%--								src="<%=request.getContextPath()%><%=request.getSession().getAttribute("userHand")%>" /></a>--%>

<%--						</div>--%>
						<div align="center" style="margin-left: -100px">
							<span style="color: black;"> <b><h1 style="height:27px;font-size: 26px;margin-left: 12%;"><%=request.getSession().getAttribute("userName")%></h1></b>
							</span>
						</div>

						<div style="background-color: black">------------------------</div>
					</div>
					<div>
						<br> <a href="/userInformation.do" style="color: red">个人信息</a>&nbsp;&nbsp;<a
							href="/updatePasswd.do" style="color: red">修改密码</a>&nbsp;&nbsp;<a
							href="/userInformation.do" style="color: red">修改头像</a><br>
						<div style="background-color: black">------------------------</div>
						<br> <a href="/exit.do" style="margin-left: 33%">切换用户</a>
					</div>


				</div>

			</div>
			<script type="text/javascript">
            $(document).ready(function(){
            	$("#div2").hide();

            })
           		 function asjdh() {//移出
		          	//alert("1");
            		$("#div2").hide();
		      	  }
		        function project() {//移入
		        	//alert("2");
		        	$("#div2").show();
		      	  }
            </script>
		</div>
	</div>
	</div>
	</div>
	<div class="header-c">
		<div class="page-width">
			<a href="#" id="header_logo"></a>
			<p id="header_title"></p>

			<div class="header-title">哔哩哔哩 (゜-゜)つロ 干杯~</div>
		</div>
	</div>
	</header>

	<nav id="nav">
	<div class="page-width clearfix">
		<ul class="nav-list">
			<li class="item item-home"><a href="index.jsp" class="link">首页</a>
			</li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>887</i>
					</div> 动画
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>23</i>
					</div> 番剧
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>999+</i>
					</div> 音乐
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>152</i>
					</div> 舞蹈
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>999+</i>
					</div> 游戏
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>999+</i>
					</div> 科技
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>999+</i>
					</div> 生活
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>77</i>
					</div> 鬼畜
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>416</i>
					</div> 时尚
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>100</i>
					</div> 广告
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>999+</i>
					</div> 娱乐
			</a></li>
			<li class="item"><a href="#" class="link">
					<div class="num">
						<i>916</i>
					</div> 影视
			</a></li>
			<li class="item item-square"><a href="#" class="link">广场</a>
				<div class="nav-square__hover">
					<ul>

					</ul>
				</div></li>

			<li class="item item-room"><a href="#" class="link">小黑屋</a></li>
		</ul>

		<div class="nav-gif" id="qiulingyang">
			<img
				src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/nav_img.gif"
				alt="求领养">
		</div>
	</div>
	</nav>

	<div id="banner">
		<div class="page-width clearfix">
			<div class="slider fl">
				<div class="slider-img">
					<a href="#" slider-title=""><img
						src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img4.png"
						alt="#"></a> <a href="#" slider-title="pic2"><img
						src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img3.png"
						alt="#"></a> <a href="#" slider-title="pic3"><img
						src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img2.png"
						alt="#"></a> <a href="#" slider-title="pic4"><img
						src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img1.png"
						alt="#"></a>
				</div>
				<div class="slider-title">
					<p>pic1</p>
				</div>
				<div class="slider-btn">
					<span class="cur"></span> <span></span> <span></span> <span></span>
				</div>
				<a href="#" class="slider-more">More</a>
			</div>
<%--			rside--%>
			<div class="banner-list fr">
				<ul>
					<c:forEach items="${rSideVideos}" var="rSideVideos">
						<li>
							<a href="video.do?url=${rSideVideos.url}">
								<img src="${rSideVideos.img}">
								<div class="info">
									<p class="title">${rSideVideos.title}</p>
									<p class="author">播放次数：${rSideVideos.click}</p>
								</div>
						</a></li>
					</c:forEach>
				</ul>
				<a href="#" class="btn btn-prev">昨日</a> <a href="#"
					class="btn btn-next">一周</a>
			</div>
		</div>
	</div>

	<div id="main">
		<div class="page-width">

			<!-- part1 -->
			<div class="mainCont clearfix" id="dance" js-move="true">
				<div class="pic-list fl" js-tab="true">
					<div class="pic-list__title">
						<i class="icon icon-dance"></i>
						<h2>娱乐</h2>
						<div class="tab-title">
							<a href="#" class="cur">有新动态</a>

						</div>

						<div class="more-wrap">
							<a href="#" class="dynamic" id="shuaxin"><i></i>392条新动态</a>

						</div>
					</div>
					<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">
						<!-- 这里开始遍历 -->
						<c:forEach items="${ylVideos}" var="ylVideos">
							<li class="item">
								<a href="video.do?url=${ylVideos.url}"
								class="img-link"> <img
									src="${ylVideos.img}">
									<span class="mask"></span>
							</a>
								<div class="img-info">
									<a href="video.do?url=${ylVideos.url}">${ylVideos.title }</a>
									<div class="btm">
										<div class="user">
											<i></i>admin
										</div>
										<div class="online">
											<i></i>${ylVideos.click}</div>
									</div>
								</div></li>
						</c:forEach>
					</ul>
				</div>
					<div class="main-side fr" js-tab="true" >
						<div class="main-side__title">
							<div class="rank-t">
								<h3>排行</h3>
							</div>
							<div class="tab-title">
								<a href="#" class="cur">全部</a>
							</div>
							<!-- 						<div class="side-select">
                                <span>三日</span> <i></i>
                            </div> -->
						</div>
						<div class="main-side__cont">
							<div class="tab-cont">
								<ul class="tab-cont__item main-rank" id="did2">
									<c:forEach items="${rank1}" var="rank1">
										<li>
											<a href="video.do?url=${rank1.url}"><h3>${rank1.title}</h3></a><br><br>
										</li></c:forEach>
								</ul>

							</div>
							<button type="button" class="more" id="chakan">
								查看更多<i></i>
							</button>
						</div>
					</div>
			</div>

			<!-- part2 -->
			<div class="mainCont clearfix" id="game" js-move="true">
				<div class="pic-list fl" js-tab="true">
					<div class="pic-list__title">
						<i class="icon icon-game"></i>
						<h2>游戏</h2>
						<div class="tab-title">
							<a href="#" class="cur">有新动态</a>
						</div>
						<div class="more-wrap">
							<a href="#" class="dynamic" id="shuaxin1"><i></i>392条新动态</a>
						</div>
					</div>
					<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">

						<c:forEach items="${yxVideos}" var="yxVideos">
							<li class="item"><a
								href="video.do?url=${yxVideos.url}"
								class="img-link"> <img
									src="${yxVideos.img}" alt="#">
									<span class="mask"></span> <span class="time"></span>
							</a>
								<div class="img-info">
									<a
										href="video.do?url=${yxVideos.url}">${yxVideos.title }</a>
									<div class="btm">
										<div class="user">
											<i></i>admin
										</div>
										<div class="online">
											<i></i>${yxVideos.click}</div>
									</div>
								</div></li>
						</c:forEach>
					</ul>
				</div>
				<div class="main-side fr" js-tab="true">
					<div class="main-side__title">
						<div class="rank-t">
							<h3>排行</h3>
						</div>
						<div class="tab-title">
							<a href="#" class="cur">全部</a>
						</div>
						<!-- 						<div class="side-select">
							<span>三日</span> <i></i>
						</div> -->
					</div>
					<div class="main-side__cont">
						<div class="tab-cont">
							<ul class="tab-cont__item main-rank" id="did3">
								<c:forEach items="${rank2}" var="rank2">
									<li>
										<a href="video.do?url=${rank2.url}"><h3>${rank2.title}</h3></a><br><br>
									</li></c:forEach>
							</ul>

						</div>
						<button type="button" class="more" id="chakan3">
							查看更多<i></i>
						</button>
					</div>
				</div>
			</div>

			<!-- part3 -->
			<div class="mainCont clearfix" id="technology" js-move="true">
				<div class="pic-list fl" js-tab="true">
					<div class="pic-list__title">
						<i class="icon icon-technology"></i>
						<h2>动漫</h2>
						<div class="tab-title">
							<a href="#" class="cur">有新动态</a>
						</div>
						<div class="more-wrap">
							<a href="#" class="dynamic" id="shuaxin2"><i></i>392条新动态</a>
						</div>
					</div>
					<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">

						<c:forEach items="${dhVideos}" var="dhVideos">
							<li class="item"><a
									href="video.do?url=${dhVideos.url}"
									class="img-link"> <img
									src="${dhVideos.img}" alt="#">
								<span class="mask"></span> <span class="time"></span>
							</a>
								<div class="img-info">
									<a
											href="video.do?url=${dhVideos.url}">${dhVideos.title }</a>
									<div class="btm">
										<div class="user">
											<i></i>admin
										</div>
										<div class="online">
											<i></i>${dhVideos.click}</div>
									</div>
								</div></li>
						</c:forEach>
					</ul>
				</div>
				<div class="main-side fr" js-tab="true">
					<div class="main-side__title">
						<div class="rank-t">
							<h3>排行</h3>
						</div>
						<div class="tab-title">
							<a href="#" class="cur">全部</a>
						</div>
						<!-- 						<div class="side-select">
							<span>三日</span> <i></i>
						</div> -->
					</div>
					<div class="main-side__cont">
						<div class="tab-cont">
							<ul class="tab-cont__item main-rank" id="did1">
								<c:forEach items="${rank3}" var="rank3">
									<li>
										<a href="video.do?url=${rank3.url}"><h3>${rank3.title}</h3></a><br><br>
									</li></c:forEach>
							</ul>

						</div>
						<button type="button" class="more" id="chakan1">
							查看更多<i></i>
						</button>
					</div>
				</div>
			</div>




		</div>
	</div>


	<div id="sideBar">
		<div class="sideBar-list">

			<br> <a href="#">动漫</a> <a href="#">动画</a> <a href="#">番剧</a> <br>
			<a href="#"><i></i>排序</a>
		</div>


		<a href="#" class="sideBar-toTop" id="backTop"></a>
	</div>



</body>
</html>