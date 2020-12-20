<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html>
	<head>
		<title>考研信息查询网</title>
		
		<%-- 静态包含 首页开头照片、css样式、jQuery文件 --%>
		<%@ include file="/common/base.jsp"%>
		<link rel="stylesheet" href="css/animate.min.css">
		<link rel="stylesheet" href="css/first.css">
		<script src="js/wow.min.js"></script>
		<script type="text/javascript" src="js/test.js"></script>
		
	</head>
	<body>
		<header>
			<div class="logo">
				<img src="images/logo1.jpg" class="xwcms" onmouseover="this.src='images/logo1.jpg'" onmouseout="this.src='images/logo1.jpg'"/>
				<div class="logo-text"></div>
				<div class="logo-text">考研信息查询</div>
			</div>
			<div class="right-block">
				<div class="wow pulse bg-yellow" data-wow-delay="0.1s">人生，</div>
				<div class="wow rollIn bg-red" data-wow-iteration="1" data-wow-duration="0.5s">就像一盒巧克力，</div>
				<div class="wow bounceInRight bg-blue">你永远不知道下一块会是什么味道！</div>
				<div class="wow bounceInRight bg-blue">---《阿甘正传》</div>
			</div>
		</header>
		<div class="clear"></div> 
		<div id="span">*学科类别为必选项</div>
		<nav id="nav" class="nav-wrap">
   		<table  class="clearfix" border="0" cellspacing="0" cellpadding="0" >
           	 <tbody> 
           	 <td>
              	<form id="form01">

  						
					 门类类别：
					<select name="mlname" id="mlname" onchange="setback()">
						<option value="">--请选择--</option>
					</select>
					*学科类别：
					<select name="xkname" id="xkname" onchange="zySetback()">
						<option value="">--请选择--</option>
					</select>

	           		  专业类别：
					<select name="zyname" id="zyname" >
						<option value="">--请选择--</option>
					</select>  
					省市：
                	<select name="province" id="province">
					   <option value="0">--请选择--</option>
					   <option value="广东省">广东省</option>
					   <option value="北京市">北京市</option>
					   <option value="湖北省">湖北省</option>
					   <option value="江西省">江西省</option>
					   <option value="浙江省">浙江省</option>
	  				</select> 
              </form>
          </td>
          <td class="td_width"></td>
              <%--查询按钮 --%>
              <td class="td_width"><input id="findbtn" value="查询" type="button"></td>
              <%--登录注册退出按钮 --%>
				<td>
				<ul align="right">
			 		<%--如果用户还没登录，显示 【登录|注册】 --%>
					<c:if test="${empty sessionScope.user }">
			             <li>
								<a href="NewLogin.jsp">登录|</a>
								<a href="NewRegister.jsp">注册</a>&nbsp;&nbsp;
						</li>
					 </c:if>
					 <%--如果用户已经登录，显示 用户登录后的信息 --%>
					 <c:if test="${not empty sessionScope.user }">
			           	<li>			
								<span>欢迎<span class="um_span">${sessionScope.user.username}
								
						</li>
						<li>
							<a href="userServlet?action=logout">退出</a>&nbsp;&nbsp;
						</li>
					 </c:if>			
				</ul>	
				</td>
			
			</tr>
		</tbody>
		</table>
		</nav>
		
		<section class="banner">
			<div class="youtiy_slider">
			  <div class="bd">
				<ul>
				  <li><a target="_blank"><img src="plugin/SuperSlide/images/1.jpg" /></a></li>
				  <li><a target="_blank"><img src="plugin/SuperSlide/images/2.jpg" /></a></li>
				  <li><a target="_blank"><img src="plugin/SuperSlide/images/3.jpg" /></a></li>
				</ul>
			  </div>
			  </div>
			</div>
		</section>
		
		<%--显示数据板块 --%>
		
			<div id="main">
		
				<table id="table_result">
						
						<tbody id="tbody_result">
						</tbody>
						
					
				</table>

			</div>

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