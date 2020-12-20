<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html>
	<head>
	<meta charset="UTF-8">
	
		<title>注册</title>
		<%-- 静态包含 首页开头照片css样式、jQuery文件 --%>
		<%@ include file="/common/base.jsp"%>
		<link rel="stylesheet" href="css/animate.min.css">		
		<script>
		$(function(){

			// 给验证码的图片，绑定单击事件
			$("#code_img").click(function () {
			// 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
			// src属性表示验证码img标签的 图片路径。它可读，可写
			this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			});
			// 给注册绑定单击事件
			$("#sub_btn").click(function () {
			// 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
			//1 获取用户名输入框里的内容
			var usernameText = $("#username").val();
			//2 创建正则表达式对象
			var usernamePatt = /^\w{5,12}$/;
			//3 使用test方法验证
			if (!usernamePatt.test(usernameText)) {
				//4 提示用户结果
				$("span.errorMsg").text("用户名不合法！");

				return false;
			}
			// 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
			//1 获取用户名输入框里的内容
			var passwordText = $("#password").val();
			//2 创建正则表达式对象
			var passwordPatt = /^\w{5,12}$/;
			//3 使用test方法验证
			if (!passwordPatt.test(passwordText)) {
				//4 提示用户结果
				$("span.errorMsg").text("密码不合法！");

				return false;
			}

			// 验证确认密码：和密码相同
			//1 获取确认密码内容
			var repwdText = $("#repwd").val();
			//2 和密码相比较
			if (repwdText != passwordText) {
				//3 提示用户
				$("span.errorMsg").text("确认密码和密码不一致！");

				return false;
			}

			// 邮箱验证：xxxxx@xxx.com
			//1 获取邮箱里的内容
			var emailText = $("#email").val();
			//2 创建正则表达式对象
			var emailPatt = new RegExp("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");
				///^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			//3 使用test方法验证是否合法
			if (!emailPatt.test(emailText)) {
				//4 提示用户
				$("span.errorMsg").text("邮箱格式不合法！");

				return false;
			}

			// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
			var codeText = $("#code").val();

			//去掉验证码前后空格
			// alert("去空格前：["+codeText+"]")
			codeText = $.trim(codeText);
			// alert("去空格后：["+codeText+"]")

			if (codeText == null || codeText == "") {
				//4 提示用户
				$("span.errorMsg").text("验证码不能为空！");

				return false;
			}

			// 去掉错误信息
			$("span.errorMsg").text("");

			});

				});
		</script>	
		<style>		
			input{
				font-family: "宋体";
				font-size: large;
				width:170px;
				height:30px;
				border-radius:10px;
			}					
		</style>
	</head>
	<body>
		<header>
			<div class="logo">
				<img alt="" src="images/logo1.jpg" class="xwcms" onmouseover="this.src='images/logo1.jpg'" onmouseout="this.src='images/logo1.jpg'"/>
				<div class="logo-text"></div>
				<div class="logo-text">欢迎注册</div>
			</div>
			<div class="right-block">
				<div class="wow pulse bg-yellow" data-wow-delay="0.1s">人生，</div>
				<div class="wow rollIn bg-red" data-wow-iteration="1" data-wow-duration="0.5s">就像一盒巧克力，</div>
				<div class="wow bounceInRight bg-blue">你永远不知道下一块会是什么味道！</div>
				<div class="wow bounceInRight bg-blue">---《阿甘正传》</div>
			</div>
		</header>
		<div class="clear">
		</div>
		
		<!-- 表单 -->
		<section class="banner">
			<div class="youtiy_slider">
			  <div class="bd">
				<div >
		<form action="userServlet" method="post" ">
		<input type="hidden" name="action" value="regist">
		
		<span class="errorMsg">
			${ requestScope.msg }
		</span>
		<br>
		<label>用户名称：</label>
		<input class="regiest_input" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"/>
		<br />
		<br />
		<label>用户密码：</label>
		<input class="regiest_input" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
		<br />
		<br />
		<label>确认密码：</label>
		<input class="regiest_input" type="password" placeholder="请再次输入密码" autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
		<br />
		<br />
		<label>电子邮件：</label>
		<input class="regiest_input" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"/>
		<br />
		<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label>验证码：</label>
		<input class="itxt" type="text" name="code" style="width: 80px;" id="code" />
		<img id="code_img" alt="" src="kaptcha.jpg" style="float: center; margin-right: 40px; width: 80px; height: 25px;">
		<br />
		<br />
		<input type="submit" value="注册" id="sub_btn" />
		<a href="NewLogin.jsp" >返回登录</a>
	</form>		
	
				</div>
			</div>		
		</div>
		</section>
		<%--静态包含页脚内容--%>
		<%@include file="/common/footer.jsp"%>
		

		<script src="plugin/SuperSlide/js/jquery.min.js"></script>
		<!-- <script src="js/jquery-1.12.4.min.js"></script> -->
		<script src="plugin/SuperSlide/js/superslide.2.1.js"></script>
		<script type="text/javascript">
		jQuery(".youtiy_slider .bd li").first().before( jQuery(".youtiy_slider .bd li").last() );
		jQuery(".youtiy_slider").hover(function(){
			 jQuery(this).find(".arrow").stop(true,true).fadeIn(300) 
			 },function(){ 
				jQuery(this).find(".arrow").fadeOut(300) });				
			 jQuery(".youtiy_slider").slide(
				{ titCell:".hd ul", mainCell:".bd ul", effect:"leftLoop",autoPlay:true, vis:3,autoPage:true, trigger:"mouseover"}
			);
			
			
			 $(document).ready(function(e) {	
					var offset = 890;
					$(window).on('scroll', function(){
						if($(this).scrollTop() > offset ) {
							$('.recommend').css('position','fixed');
							$('.recommend').css('top','0px');
						} 
						else {
							$('.recommend').css('position','');
						}
					});
				});
		</script>
	</body>
</html>