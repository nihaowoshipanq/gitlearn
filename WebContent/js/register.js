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