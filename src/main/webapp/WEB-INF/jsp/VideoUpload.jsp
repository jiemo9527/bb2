<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频投稿</title>
<script src="${pageContext.request.contextPath}/static/Homepage/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/static/Homepage/js/jquery-form.js"></script>

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/Homepage/mycssAndimg/css.css">
</head>
<style>
 
    </style>
<body style="background-image: url(<%=request.getContextPath()%>/static/Homepage/mycssAndimg/timg.jpg);">
    	<div id="none">
    		<!-- style="width: 100%;height: 60px;background-color: white;" -->
    	</div>
    	
        <div>
          	 
            <div>
            
                <form id="upload_form" >
                	
                    <div>
                        <div><label  style="color: wheat;">请选择投稿视频文件</label></div>
                        <div><input type="file" name="mp4" id="mp4" /></div>
                    </div>
                    <div>
                        <div><label  style="color: wheat;">请选择投稿封面壁纸</label></div>
                        <div><input type="file" name="img" id="img"  /></div>
                    </div>
                     <div>
                        <div><label  style="color: wheat;">请输入视频标题</label></div>
                        <div><input type="text" name="title"  id="title" /></div>
                    </div>
                    
                     <div>
                        <div><label  style="color: wheat;">请输入视频描述</label></div>
                        <div><textarea  rows="13" id="description" cols="70"></textarea></div>
                    </div>
                    
                    <div>
                        <div><label  style="color: wheat;">请选择投放区域</label></div>
                        <div>
                        <label><input name="Fruit" type="radio" value="1" checked />动画 </label>
						<label><input name="Fruit" type="radio" value="2" />MAD </label>
						<label><input name="Fruit" type="radio" value="3" />音乐 </label>
						<label><input name="Fruit" type="radio" value="4" />影视 </label>
						<label><input name="Fruit" type="radio" value="5" />原创 </label>
                        </div>
					</div>
					<div>
                        <input type="button" value="立即投稿" id="Submission"  />
                        <input type="button" id="toIndex" value="取消返回" />
                   	 </div>
                    <div id="msg" style="color: red;font-size: 16px;" >${msg}</div>
					 </form>
						<div style="display: none;" id="totalSize"><b style="color: red;">总大小不能超过1g</b></div>		
					
                   	 
                   
                  
                  
        </div>
        <script type="text/javascript">
        	$("#toIndex").click(function(){
        		location.href = "/index.do";
        	})
        	
        </script>
        
        <script>
        	$("#Submission").click(function() {
                //判断视频
                var mp4 = $("#mp4").val();
                if (mp4 == "") {
                    alert("请上传投稿的视频");
                    return false;
                } else {
                    if (!/\.(mp4)$/.test(mp4)) {
                        alert("视频格式必须为.MP4格式")
                        return false;
                    }
                    //判断图片
                    var img = $("#img").val();
                    if (img == "") {
                        alert("请选择图片");
                        return false;
                    } else {
                        if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(img)) {
                            alert("图片类型必须是.gif,jpeg,jpg,png中的一种")
                            return false;
                        }
                    }
                    //开始判断输入的内容
                    var title = $("#title").val();
                    var description = $("#description").val();
                    if (title == "" || description == "" || description == "null" || title == "null") {
                        alert("请正确输入标题和描述");
                        return false;
                    }
                    //判断文件总大小 不能超1g
                    //用户上传的视频
                    var addMp4 = $("#mp4").prop('files');
                    var mp4Size = 0;
                    for (var i = 0; i < addMp4.length; i++) {
                        mp4Size = $(addMp4)[i].size;
                        console.log(mp4Size)
                    }
                    //用户上传的图片
                    var addImg = $("#img").prop('files');
                    var imgSize = 0;
                    for (var i = 0; i < addImg.length; i++) {
                        imgSize = $(addImg)[i].size;
                        console.log(imgSize)
                    }
                    var mp4Url=$('#mp4').val();
                    var imgUrl=$('#img').val();
                    // var totalSize = mp4Size + imgSize;
                    var MaxSize = 1073741824;
                    if (totalSize > MaxSize) {
                        $("#totalSize").show();
                        alert("对不起 文件过大.无法上传");
                        return false;
                    }
                }
                //判断结束
                $("#Submission").attr('disabled', true); //将button变成不可点击
                function getPath(obj)
                {
                    if(obj)
                    {

                        if (window.navigator.userAgent.indexOf("MSIE")>=1)
                        {
                            obj.select();

                            return document.selection.createRange().text;
                        }

                        else if(window.navigator.userAgent.indexOf("Firefox")>=1)
                        {
                            if(obj.files)
                            {

                                return obj.files.item(0).getAsDataURL();
                            }
                            return obj.value;
                        }
                        return obj.value;
                    }
                }



                $.ajax(
                    {
                        url: "${pageContext.request.contextPath}/vp_back.do",
                        type: "POST",
                        dataType: "json",
                        data:{
                            mp4Url:mp4Url,
                            imgUrl:imgUrl,
                            mp4Size:mp4Size,
                            title:$("#title").val(),
                            description:$("#description").val(),
                            Fruit: $("input[type='radio']:checked").val()
                        },
                        success: function (result) {
                            alert(result);
                        }
                    });

            });

        	
        </script>
        </div>
    </body>


</html>