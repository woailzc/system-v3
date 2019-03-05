<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<% Date nowDate = new Date(); request.setAttribute("nowDate", nowDate); %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加用户 </title>
<body>
<article class="page-container">
	<form action="<%=basePath%>/a/sysUser/save.do" method="post" class="form form-horizontal"  enctype="multipart/form-data" id="form-add">
	    <input type="hidden" value="${sysUser.id}" name="createBy.id" id="createBy.id" >
	     <input type="hidden" value="${nowDate}" name="createDate" id="createDate">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="name" name="name" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>登陆名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="loginName" name="loginName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" value="" placeholder="" id="password" name="password">
			</div>
		</div>
	 <!--   <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>出生年月日：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="brithday" name="brithday" onfocus="WdatePicker({ brithday:'#F{$dp.$D(\'brithday\')}',brithday:'%y-%M-%d' })"class="input-text Wdate" style="width:120px;" >
			</div>
		</div>  -->
		
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="adress" name="adress">
			</div>
		</div> -->
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="sex" value="男" type="radio" id="sex" checked>
					<label for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex" name="sex" value="女">
					<label for="sex-2">女</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex" name="sex">
					<label for="sex-3">保密</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="phone" name="phone">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="@" name="email" id="email">
			</div>
		</div> -->
		 <!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">头像：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="Mphoto" id="Mphoto" readonly nullmsg="请添加图片！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览图片</a>
				<input type="file" multiple name="Mphoto" class="input-file" name="Mphoto" id="Mphoto">
				</span> </div>
		</div> -->
		 <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所属部门：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="sysDepartment.id" id="sysDepartment.id" required="required">
					<option value="" selected>请部门</option>
					<c:forEach items="${sysDepartments}" var="sysDepartment">
					<option value="${sysDepartment.id }">${sysDepartment.name }</option>
					</c:forEach>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="sysRole.id" id="sysRole.id" >
					<option value="" selected>请分配角色</option>
					<c:forEach items="${sysRoles }" var="sysRole">
					<option value="${sysRole.id }">${sysRole.name }</option>
					</c:forEach>
				</select>
				</span> 
				</div>
		</div>
		<!--
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="beizhu" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div> -->
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
 <input type="hidden" value="${msg }" name="msg" id="msg">
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="<%=basePath%>static/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	/**检查登录名**/
  $("#loginName").blur(function(){
	  var loginName = $("#loginName").val();
	  $.ajax({
			type: 'POST',
			data:{loginName:loginName},
			url: '<%=basePath%>a/sysUser/check.do',
			dataType: 'json',
			success: function(data){
			    if(data.check == 'true') return;
			    if(data.check == 'false') {layer.msg('登录名已存在！',{icon:1,time:1000}); var loginName = $("#loginName").val('');}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
});
</script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-add").validate({
		rules:{
			name:{
				required:true,
				minlength:2,
				maxlength:16
			},
			loginName:{
				required:true,
				minlength:2,
				maxlength:16
			},
			password:{
				required:true,
				minlength:2,
				maxlength:16
			},
			/* brithday:{
				required:true,
			}, */
			sex:{
				required:true,
			},
			adress:{
				required:true,
			},
			phone:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			Mphoto:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			 form.submit();
			/* $(form).ajaxSubmit();
			alert("成功");
		    var index = parent.layer.getFrameIndex(window.name);
  			parent.$('.btn-refresh').click();
			parent.layer.close(index); */
			

		}
	});
});
</script> 
<!-- 消息提示 -->
<script type="text/javascript">
window.onload=function(){
	var msg = document.getElementById('msg').value;
	if(msg != null && msg != '') {layer.msg(msg,{icon: 1,time:2000});}
	
} 
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>