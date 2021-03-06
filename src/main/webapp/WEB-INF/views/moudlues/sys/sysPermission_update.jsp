<%@ page contentType="text/html;charset=UTF-8" %>
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

<title>添加部门 </title>
</head>
<body>
<article class="page-container">
	<form action="<%=basePath%>/a/sysPermission/update.do" method="post" class="form form-horizontal"  enctype="multipart/form-data">
	    <input type="hidden" value="${sysUser.id }" name="updateBy.id" id="updateBy.id">
	   <input type="hidden" value="${nowDate}" name="updateDate" id="updateDate">
	    <input type="hidden" value="${param.id }" name="id" id="id">
	   
	   <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>模块名称</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sysPermission.sysMenu.menuName }" placeholder="" id="" name= required="required" readonly="readonly">
				<input type="hidden" value="${sysPermission.sysMenu.id }" name="sysMenu.id">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sysPermission.name }" placeholder="" id="name" name="name" required="required">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sysPermission.remark }" placeholder="" id="remark" name="remark" required="required">
			</div>
		</div>
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
  /**获取一级菜单的子菜单**/
	$("#fatherMenu").change(function(){
		var id = $("#fatherMenu").val();
	/* 	alert(id);return false; */
			$.ajax({
				type: 'POST',
				data:{id:id},
				url: '<%=basePath%>a/sysPermission/getSonMenu.do',
				dataType: 'json',
				success: function(data){
/* 				  alert(data.sonMenu[0].menuName);return false;
 */					for (var i = 0; i < data.sonMenu.length; i++) {
						//创建一个option
						var opt=document.createElement("option");
						var select1=document.getElementById("sysMenu");
						//给option的value属性和具体内容赋值
						opt.value=data.sonMenu[i].id;
						opt.innerHTML=data.sonMenu[i].menuName;
						//将option添加到select中
						select1.append(opt);
					} 
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
	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
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