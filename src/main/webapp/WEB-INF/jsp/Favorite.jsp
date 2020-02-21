<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>视频收藏</title>

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
                                 src="${uissDetail.picture}">

                        </div>

                    </div>
                    <div class="center_header">

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
            <li class="item item-home"><a href="index.jsp" class="link">视频收藏</a>
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

<div id="main">
    <div class="page-width">

        <!-- part1 -->
        <div class="mainCont clearfix" id="dance" js-move="true">
            <div class="pic-list fl" js-tab="true">
                <div class="pic-list__title">
                    <i class="icon icon-dance"></i>
                    <h2>视频收藏</h2>
                </div>
                <ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">
                    <!-- 这里开始遍历 -->
                    <c:forEach items="${videoFavoriteList}" var="videoFavoriteList">
                        <li class="item">
                            <a href="video.do?url=${videoFavoriteList.videourl}"
                               class="img-link"> <img
                                    src="${videoFavoriteList.img}">
                                <span class="mask"></span>
                            </a>
                            <div class="img-info">
                                <a href="video.do?url=${videoFavoriteList.videourl}">${videoFavoriteList.title}</a>
                                <div class="btm">
                                    <div class="user">
                                        <i></i>admin
                                    </div>
                                    <div class="online">
                                        <i></i>${videoFavoriteList.click}</div>
                                </div>
                            </div></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>



</div>





</body>
</html>