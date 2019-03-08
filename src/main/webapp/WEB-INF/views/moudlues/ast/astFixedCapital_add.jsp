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

<title>添加</title>
</head>
<body>
<article class="page-container">
	<form action="<%=basePath%>/a/astFixedCapital/save.do" method="post" class="form form-horizontal"  enctype="multipart/form-data" id="form-member-add">
	    <input type="hidden" value="${sysUser.id}" name="createBy.id" id="createBy.id" >
	     <input type="hidden" value="${nowDate}" name="createDate" id="createDate">
	   <input type="hidden" value="正常" name="status" id="status">
	    <input type="hidden" value="正常" name="repairStatus" id="repairStatus">
	   <input type="hidden" value="现有" name="source" id="source">
	    
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="name" name="name" >
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="" id="" placeholder="输入长度" value="" class="input-text" style=" width:25%">
				MM
				<input type="text" name="" id="" placeholder="输入宽度" value="" class="input-text" style=" width:25%">
				MM
				<input type="text" name="" id="" placeholder="输入高度" value="" class="input-text" style=" width:25%">
				MM </div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="Specifications" id="Specifications" placeholder="" value="" class="input-text">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">型号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="model" id="model" placeholder="" value="" class="input-text">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">供应商：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="supplier" id="supplier" placeholder="" value="" class="input-text">
			</div>
		</div> -->
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">单价：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="unitPrice" id="unitPrice" placeholder="" value="" class="input-text">
				<input type="text" name="computingUnit" id="computingUnit" placeholder="" value="" class="input-text" readonly="readonly">
			</div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="num" id="num" placeholder="" value="" class="input-text">
<!-- 				<input type="text" name="computingUnit" id="computingUnit" placeholder="" value="" class="input-text" readonly="readonly">
 -->			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">使用方向：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="useWay" id="useWay" placeholder="" value="" class="input-text">
			</div>
		</div> 
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">花费总价：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="spend" id="spend" placeholder="" value="" class="input-text" style="width:90%">
				元</div>
		</div> -->
	    <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">添加日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({ createDate:'#F{$dp.$D(\'createDate\')||\'%y-%M-%d\'}' })" id="createDate" name="createDate" class="input-text Wdate" style="width:120px;" >
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
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			name:{
				required:true,
				minlength:2,
				maxlength:16
			},
			useWay:{
				required:true,
				minlength:2,
				maxlength:16
			},
			Specifications:{
				required:true,
				minlength:1,
				maxlength:16
			},
			 model:{
				required:true,
				minlength:1,
				maxlength:16
			},
		
			createDate:{
				required:true,
			},
			num:{
				required:true,
				number:true
			},
			/*  unitPrice:{
				required:true,
				number:true
			},  */
			
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			form.submit();
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