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

<title>更新</title>
</head>
<body>
<article class="page-container">
	<form action="<%=basePath%>/a/clClean/update.do" method="post" class="form form-horizontal" id="form-member-add">
	   <input type="hidden" value="${sysUser.id }" name="updateBy.id" id="updateBy.id">
	   <input type="hidden" value="${nowDate}" name="updateDate" id="updateDate">
	    <input type="hidden" value="${param.id }" name="id" id="id">
	
		<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
			    <th width="100">班次</th>
				<th width="100">周一</th>
				<th width="100">周二</th>
				<th width="100">周三</th>
				<th width="100">周四</th>
				<th width="100">周五</th>
				<th width="100">周六</th>
				<th width="100">周日</th>
			</tr>
		</thead>
		<tbody>
			<tr class="text-c">
			    <td>早班</td>
				<%-- <td><u style="cursor:pointer" class="text-primary" onclick="member_show('${clClean.id}','<%=basePath%>a/clClean/show.do?id=${clClean.id}','10001','360','400')">${clClean.id}</u></td> --%>
				<%-- <td><fmt:formatDate value="${clClean.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
				<c:forEach items="${paiBans1}" var="paiBan1">
				<td>${paiBan1.id}</td>
				</c:forEach>
			</tr>
			<tr class="text-c">
			    <td>中班</td>
				<c:forEach items="${paiBans2}" var="paiBan2">
				<td>${paiBan1.id}</td>
				</c:forEach>
			</tr>
			<tr class="text-c">
			    <td>晚班</td>
				<c:forEach items="${paiBans3}" var="paiBan3">
				<td>paiBan1.id}</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
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
		
			cleanAdress:{
				required:true,
				minlength:2,
				maxlength:16
			},
			remark:{
				required:true,
				minlength:0,
				maxlength:100
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