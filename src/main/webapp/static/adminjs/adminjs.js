$(document).ready(
		function() {


			$("#qiulingyang").click(function() {
				alert("我是小电视");
			})
			$("#shuaxin").click(function() {
				alert("数据库视频不够...");
			})
			$("#shuaxin1").click(function() {
				alert("数据库视频不够...");
			})
			$("#shuaxin2").click(function() {
				alert("数据库视频不够...");
			})

		});

function asjdh() {//移出
  	//alert("1");
	$("#div2").hide();
	  }
function project() {//移入
	//alert("2");
	$("#div2").show();
	  }



		x = document.getElementById("chakan4");
		x.innerHTML = "正在刷新....";
		setTimeout(function() {
			x = document.getElementById("chakan4");
			x.innerHTML = "查看更多";
			document.getElementById('chakan4').disabled = false;
		}, 4000);

	}

		x = document.getElementById("chakan3");
		x.innerHTML = "正在刷新....";
		setTimeout(function() {
			x = document.getElementById("chakan3");
			x.innerHTML = "查看更多";
			document.getElementById('chakan3').disabled = false;
		}, 4000);

	}


		x = document.getElementById("chakan");
		x.innerHTML = "正在刷新....";
		setTimeout(function() {
			x = document.getElementById("chakan");
			x.innerHTML = "查看更多";
			document.getElementById('chakan').disabled = false;
		}, 4000);

	}

}
