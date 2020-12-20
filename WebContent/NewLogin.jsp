<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html>
	<head>
		<title>登录</title>
		<%-- 静态包含 首页开头照片css样式、jQuery文件 --%>
		<%@ include file="/common/base.jsp"%>
		<link rel="stylesheet" href="css/animate.min.css">
		<script src="js/wow.min.js"></script>
		<script>
		if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
			new WOW().init();
		};
	
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
				<div class="logo-text">欢迎登录</div>
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
		<nav  id="nav" class="nav-wrap">
			<ul class="clearfix" align="right">
			  <li><a href="NewRegister.jsp">立刻注册</a></li>
			</ul>
		</nav>
		
		<section class="banner">
			<div class="youtiy_slider">
			  <div class="bd">
				<div >
					<form action="userServlet" method="post">
						<input type="hidden" name="action" value="login">
						<br><br><br><br>
						
						<label>用户名称：</label>
						<input class="login_input" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${cookie.username.value}"/>
						<br /><br /><br>
						<label>用户密码：</label>
						<input class="login_input" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
						<br /> <br /><br><br>
						<input type="submit" value="登录" id="sub_btn" />
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