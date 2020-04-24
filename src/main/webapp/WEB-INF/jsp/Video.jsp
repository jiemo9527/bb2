<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="${pageContext.request.contextPath}/static/Homepage/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/videolook/video.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/Homepage/videoPlay/css/fz-video.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/Homepage/videoPlay/font/iconfont.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/Homepage/video/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/Homepage/video/css/dashboard.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/Homepage/video/css/fz-video.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/Homepage/video/css/popuo-box.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/Homepage/video/css/style.css">
<link href="/static/videolook/video-js.min.css" rel="stylesheet">
<link href="/static/share/css/share.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="/static/comment/css/style.css">
	<link rel="stylesheet" href="/static/comment/css/comment.css">


<style type="text/css">
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";background:#121212;}

/* slider */
.wp{position:relative;width:100%;height:600px;overflow:hidden;margin:20px auto;border:1px solid #121212;background:#fff;}

.slider{position:absolute;width:760px;padding:0 20px;left:0;top:0;}
.fl{float:left}
.slider img{display:block;padding:2px;border:1px solid #ccc} 
.slider li{padding:20px 0;border-bottom:1px dashed #ccc;overflow:hidden;width:100%}
.slider p{font-size:12px;margin:0;padding-left:68px;color:#333;line-height:20px;}
.m {
	width: 960px;
	height: 400px;
	margin-left: 470px;
	margin-right: auto;
	margin-top: 15px;
}
.box-container {
	position: relative;
	transition: all 0.5s;
}
.box {
	position: absolute;
	background: #DB495B;
	color: #fff;
	width: 40px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	border-radius: 50%;
	transition: all 0.8s ease-in-out;
}
.layer {
	position: absolute;
	content: '';
	display: none;
	width: 100px;
	height: 100px;
	border-radius: 50%;
	background: rgba(255, 255, 255, 0.6);
	transition: all 1s;
	opacity: 0;
}
.name {
	transition: all 0.2s;
}
</style>


<style>
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code,
	form, fieldset, legend, input, button, textarea, p, blockquote, th, td
	{
	margin: 0;
	padding: 0;
}

body {
	background: #fff;
	color: #555;
	font-size: 14px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

td, th, caption {
	font-size: 14px;
}

h1, h2, h3, h4, h5, h6 {
	font-weight: normal;
	font-size: 100%;
}

address, caption, cite, code, dfn, em, strong, th, var {
	font-style: normal;
	font-weight: normal;
}

a {
	color: #555;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

img {
	border: none;
}

ol, ul, li {
	list-style: none;
}

input, textarea, select, button {
	font: 14px Verdana, Helvetica, Arial, sans-serif;
}

table {
	border-collapse: collapse;
}

html {
	overflow-y: scroll;
}

.clearfix:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
}

.clearfix {
	*zoom: 1;
}

/*body{ font-family: "微软雅黑"; background-color: #292929; 	}*/
#testBox {
	width: 80%;
	height: 537px;
	margin: 0 auto;
}
</style>
	<script src="/static/html5media.min.js"></script>

	<title>视频区</title>
</head>
<body>
<div style="width: 100%;height: 40px;" >
<div style="background-color: #6C89B2;">
	<div style="text-align:center;font-size: 18px;padding-top: 15px;">${video.title}</div>
		<div style="margin-left: 90%;">
	 
			<%
				if (request.getSession().getAttribute("userName") == null) {
			%>
			<button class="btn btn-primary ladda-button" data-style="expand-left" id="login">
				<span class="ladda-label"><a href="/login.do"
					style="font-size: 10px; color: white; text-decoration: none" >登录</a></span>
			</button>

			<button class="btn btn-primary ladda-button" data-style="expand-left" id="zhuce">
				<span class="ladda-label"><a href="/register.do"
					style="font-size: 10px; color: white; text-decoration: none" >注册</a></span>
			</button>
			<%
				} else {
			%>


			<button class="btn btn-primary ladda-button" data-style="expand-left" id="userxinxi" >
				<span class="ladda-label"><a href="/userInformation.do"
					style="font-size: 12px; color: white; text-decoration: none">
						欢迎你的登录: <span style="color: red"><%=request.getSession().getAttribute("userName")%></span>
				</a></span>
			</button>


	
			<%
				}
			%>
		</div>
		
		
	<script type="text/javascript">
		$(document).ready(function(){
			$("#userxinxi").click(function(){
				location.href="userInformation.do";
				
			});
			$("#login").click(function(){
				location.href="login.do";
			});
			$("#zhuce").click(function(){
				location.href="register.do";
			});
		});
	</script>
	</div>



</div>









	<div class="m">
		<video id="my-video" class="video-js" controls preload="auto" width="960" height="450"
			   poster="m.jpg" data-setup="{}">

			<source src="${video.m3u8}" type="application/x-mpegURL">
			<p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a> </p>
		</video>
		<script src="/static/videolook/video.min.js"></script>
		<script type="text/javascript">
			//设置中文
			videojs.addLanguage('zh-CN', {
				"Play": "播放",
				"Pause": "暂停",
				"Current Time": "当前时间",
				"Duration": "时长",
				"Remaining Time": "剩余时间",
				"Stream Type": "媒体流类型",
				"LIVE": "直播",
				"Loaded": "加载完毕",
				"Progress": "进度",
				"Fullscreen": "全屏",
				"Non-Fullscreen": "退出全屏",
				"Mute": "静音",
				"Unmute": "取消静音",
				"Playback Rate": "播放速度",
				"Subtitles": "字幕",
				"subtitles off": "关闭字幕",
				"Captions": "内嵌字幕",
				"captions off": "关闭内嵌字幕",
				"Chapters": "节目段落",
				"Close Modal Dialog": "关闭弹窗",
				"Descriptions": "描述",
				"descriptions off": "关闭描述",
				"Audio Track": "音轨",
				"You aborted the media playback": "视频播放被终止",
				"A network error caused the media download to fail part-way.": "网络错误导致视频下载中途失败。",
				"The media could not be loaded, either because the server or network failed or because the format is not supported.": "视频因格式不支持或者服务器或网络的问题无法加载。",
				"The media playback was aborted due to a corruption problem or because the media used features your browser did not support.": "由于视频文件损坏或是该视频使用了你的浏览器不支持的功能，播放终止。",
				"No compatible source was found for this media.": "无法找到此视频兼容的源。",
				"The media is encrypted and we do not have the keys to decrypt it.": "视频已加密，无法解密。",
				"Play Video": "播放视频",
				"Close": "关闭",
				"Modal Window": "弹窗",
				"This is a modal window": "这是一个弹窗",
				"This modal can be closed by pressing the Escape key or activating the close button.": "可以按ESC按键或启用关闭按钮来关闭此弹窗。",
				", opens captions settings dialog": ", 开启标题设置弹窗",
				", opens subtitles settings dialog": ", 开启字幕设置弹窗",
				", opens descriptions settings dialog": ", 开启描述设置弹窗",
				", selected": ", 选择",
				"captions settings": "字幕设定",
				"Audio Player": "音频播放器",
				"Video Player": "视频播放器",
				"Replay": "重播",
				"Progress Bar": "进度小节",
				"Volume Level": "音量",
				"subtitles settings": "字幕设定",
				"descriptions settings": "描述设定",
				"Text": "文字",
				"White": "白",
				"Black": "黑",
				"Red": "红",
				"Green": "绿",
				"Blue": "蓝",
				"Yellow": "黄",
				"Magenta": "紫红",
				"Cyan": "青",
				"Background": "背景",
				"Window": "视窗",
				"Transparent": "透明",
				"Semi-Transparent": "半透明",
				"Opaque": "不透明",
				"Font Size": "字体尺寸",
				"Text Edge Style": "字体边缘样式",
				"None": "无",
				"Raised": "浮雕",
				"Depressed": "压低",
				"Uniform": "均匀",
				"Dropshadow": "下阴影",
				"Font Family": "字体库",
				"Proportional Sans-Serif": "比例无细体",
				"Monospace Sans-Serif": "单间隔无细体",
				"Proportional Serif": "比例细体",
				"Monospace Serif": "单间隔细体",
				"Casual": "舒适",
				"Script": "手写体",
				"Small Caps": "小型大写字体",
				"Reset": "重启",
				"restore all settings to the default values": "恢复全部设定至预设值",
				"Done": "完成",
				"Caption Settings Dialog": "字幕设定视窗",
				"Beginning of dialog window. Escape will cancel and close the window.": "开始对话视窗。离开会取消及关闭视窗",
				"End of dialog window.": "结束对话视窗"
			});


			var myPlayer = videojs('my-video');
			videojs("my-video").ready(function(){
				var myPlayer = this;
				myPlayer.play();
			});

		</script>
<button onclick="test()">
<div class="box-container">

			<div class="box box2" ></div>
			<div class="layer"></div>
			<div class="box box1">
				<span class="name">收藏</span>

			</div>
		</div>
</button>

<script>
			function test() {
				$.ajax({
					type:"post",
					url:"favorite.do",
					data:{
						"username":"<%=request.getSession().getAttribute("userName")%>",
						"status":$(".name").text(),
						"videourl":"${video.url}",
						"title":"${video.title}",
						"img":"${video.img}",
						"click":"${video.click}",

					},
					dataType:"json",
					success: function(data){
						console.log(data);
					}
				});
			}
			const layer = document.querySelector('.layer');
			const box1 = document.querySelector('.box1');
			const box2 = document.querySelector('.box2');
			const boxContainer = document.querySelector('.box-container');
			const name = document.querySelector('.name');
			let flag = false;
			var innerText=null;
			box1.onclick = function (evt) {
				if (flag) return;
				flag = true;
				//   显示蒙层
				layer.style.display = 'block';
				setTimeout(() => {
					// 蒙层不透明
					layer.style.opacity = '1';
					// 缩小收藏按钮
					box1.style.transform = 'scale(0)'
				}, 200);
				setTimeout(() => {
					// 隐藏蒙层
					layer.style.display = 'none';
					layer.style.opacity = '0';
					// 显示文字
					innerText= name.innerHTML === '已收藏' ? '收藏' : '已收藏';
					name.innerHTML = innerText;
					// 隐藏
					box1.style.display = 'none';
					name.style.opacity = '0';
				}, 1000);
				setTimeout(() => {
					// 显示
					box1.style = '';
					if (name.innerHTML === '已收藏') {
						boxContainer.style.opacity = '0.75';
					} else {
						boxContainer.style = '';
					}
					flag = false;
				}, 1100);
				setTimeout(() => {
					name.style.opacity = '1';
				}, 1150);


			};

		</script>





<div class="share-dialog-cont" style="float: right;padding: 12px">

	<div class="share-platform">

		<div class="share-platform-r">
			<div class="bdsharebuttonbox"><div style="float: left;font-size: 16px;padding: 7px">分享：</div>
				<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
				<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
				<a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
				<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
			</div>

		</div>
	</div>
</div>


<%--		***--%>
	</div>



<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"分享到新浪微博","bdMini":"1","bdMiniList":["bdxc","tqf","douban","bdhome","sqq","thx","ibaidu","meilishuo","mogujie","diandian","huaban","duitang","hx","fx","youdao","sdo","qingbiji","people","xinhua","mail","isohu","yaolan","wealink","ty","iguba","fbook","twi","linkedin","h163","evernotecn","copy","print"],"bdPic":"","bdStyle":"1","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>

<script src="/static/share/jquery-1.11.1.min.js"></script>
<script src="/static/share/ZeroClipboard.js"></script>
<script>
	var g_url = window.location.href;
	$('.share-copy-c input').val(g_url);
	var clip = new ZeroClipboard( document.getElementById("btnCopy"));
</script>


<!-- 评论区 -->
<div class="commentAll">
	<!--评论区域 begin-->
	<div class="reviewArea clearfix">
		<textarea class="content comment-input" placeholder="评论一番吧&hellip;" onkeyup="keyUP(this)"></textarea>
		<a href="javascript:;" class="plBtn">评论</a>
	</div>
	<!--评论区域 end-->
	<!--回复区域 begin-->
	<div class="comment-show">
		<div class="comment-show-con clearfix">
			<div class="comment-show-con-img pull-left"><img src="images/header-img-comment_03.png" alt=""></div>
			<div class="comment-show-con-list pull-left clearfix">
				<div class="pl-text clearfix">
					<a href="#" class="comment-size-name">admin : </a>
					<span class="my-pl-con">&nbsp;来啊 造作啊!</span>
				</div>
				<div class="date-dz">
					<span class="date-dz-left pull-left comment-time">${time}</span>
					<div class="date-dz-right pull-right comment-pl-block">
						<a href="javascript:;" class="removeBlock">删除</a>
						<a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>
						<span class="pull-left date-dz-line">|</span>
						<a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">0</i>)</a>
					</div>
				</div>
				<div class="hf-list-con"></div>
			</div>
		</div>
	</div>
	<!--回复区域 end-->
</div>

<script type="text/javascript" src="/static/comment/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="/static/comment/js/jquery.flexText.js"></script>
<!--textarea高度自适应-->
<script type="text/javascript">
	$(function () {
		$('.content').flexText();
	});
</script>
<!--textarea限制字数-->
<script type="text/javascript">
	function keyUP(t){
		var len = $(t).val().length;
		if(len > 139){
			$(t).val($(t).val().substring(0,140));
		}
	}
</script>
<!--点击评论创建评论条-->
<script type="text/javascript">
	$('.commentAll').on('click','.plBtn',function(){
		var myDate = new Date();
		//获取当前年
		var year=myDate.getFullYear();
		//获取当前月
		var month=myDate.getMonth()+1;
		//获取当前日
		var date=myDate.getDate();
		var h=myDate.getHours();       //获取当前小时数(0-23)
		var m=myDate.getMinutes();     //获取当前分钟数(0-59)
		if(m<10) m = '0' + m;
		var s=myDate.getSeconds();
		if(s<10) s = '0' + s;
		var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
		//获取输入内容
		var oSize = $(this).siblings('.flex-text-wrap').find('.comment-input').val();
		console.log(oSize);
		//动态创建评论模块
		oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="images/header-img-comment_03.png" alt=""></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name"><%=request.getSession().getAttribute("userName")%> : </a> <span class="my-pl-con">&nbsp;'+ oSize +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
		if(oSize.replace(/(^\s*)|(\s*$)/g, "") != ''){
			$(this).parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
			$(this).siblings('.flex-text-wrap').find('.comment-input').prop('value','').siblings('pre').find('span').text('');
		}
	});
</script>
<!--点击回复动态创建回复块-->
<script type="text/javascript">
	$('.comment-show').on('click','.pl-hf',function(){
		//获取回复人的名字
		var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
		//回复@
		var fhN = '回复@'+fhName;
		//var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
		var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
		//显示回复
		if($(this).is('.hf-con-block')){
			$(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
			$(this).removeClass('hf-con-block');
			$('.content').flexText();
			$(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding','6px 15px');
			//console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
			//input框自动聚焦
			$(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
		}else {
			$(this).addClass('hf-con-block');
			$(this).parents('.date-dz-right').siblings('.hf-con').remove();
		}
	});
</script>
<!--评论回复块创建-->
<script type="text/javascript">
	$('.comment-show').on('click','.hf-pl',function(){
		var oThis = $(this);
		var myDate = new Date();
		//获取当前年
		var year=myDate.getFullYear();
		//获取当前月
		var month=myDate.getMonth()+1;
		//获取当前日
		var date=myDate.getDate();
		var h=myDate.getHours();       //获取当前小时数(0-23)
		var m=myDate.getMinutes();     //获取当前分钟数(0-59)
		if(m<10) m = '0' + m;
		var s=myDate.getSeconds();
		if(s<10) s = '0' + s;
		var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
		//获取输入内容
		var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();
		console.log(oHfVal)
		var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
		var oAllVal = '回复@'+oHfName;
		if(oHfVal.replace(/^ +| +$/g,'') == '' || oHfVal == oAllVal){

		}else {
			$.getJSON("json/pl.json",function(data){
				var oAt = '';
				var oHf = '';
				$.each(data,function(n,v){
					delete v.hfContent;
					delete v.atName;
					var arr;
					var ohfNameArr;
					if(oHfVal.indexOf("@") == -1){
						data['atName'] = '';
						data['hfContent'] = oHfVal;
					}else {
						arr = oHfVal.split(':');
						ohfNameArr = arr[0].split('@');
						data['hfContent'] = arr[1];
						data['atName'] = ohfNameArr[1];
					}

					if(data.atName == ''){
						oAt = data.hfContent;
					}else {
						oAt = '回复<a href="#" class="atName">@'+data.atName+'</a> : '+data.hfContent;
					}
					oHf = data.hfName;
				});

				var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">我的名字 : </a><span class="my-pl-con">'+oAt+'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">0</i>)</a> </div> </div></div>';
				oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display','block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
			});
		}
	});
</script>
<!--删除评论块-->
<script type="text/javascript">
	$('.commentAll').on('click','.removeBlock',function(){
		var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
		if(oT.siblings('.all-pl-con').length >= 1){
			oT.remove();
		}else {
			$(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display','none')
			oT.remove();
		}
		$(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();

	})
</script>
<!--点赞-->
<script type="text/javascript">
	$('.comment-show').on('click','.date-dz-z',function(){
		var zNum = $(this).find('.z-num').html();
		if($(this).is('.date-dz-z-click')){
			zNum--;
			$(this).removeClass('date-dz-z-click red');
			$(this).find('.z-num').html(zNum);
			$(this).find('.date-dz-z-click-red').removeClass('red');
		}else {
			zNum++;
			$(this).addClass('date-dz-z-click');
			$(this).find('.z-num').html(zNum);
			$(this).find('.date-dz-z-click-red').addClass('red');
		}
	})
</script>

</body>
</html>