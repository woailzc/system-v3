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

<title>查看</title>
</head>
<body>
<nav class="breadcrumb"><a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container">
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
			    <td>早班${beginTime1}--${endTime1}</td>
				<c:forEach items="${paiBans1}" var="paiBan1" varStatus="status">
				<td>
				   <c:forEach  items="${paiBan1.sysUsers}" var="sysUser">
				       ${sysUser.name}             
				       ,
				   </c:forEach>
				</td>
				</c:forEach>
			</tr>
			<tr class="text-c">
			    <td>中班${beginTime2}--${endTime2}</td>
				<c:forEach items="${paiBans2}" var="paiBan2">
				<td>
				    <c:forEach  items="${paiBan2.sysUsers}" var="sysUser">
				       ${sysUser.name}             
				       ,
				   </c:forEach>
				   <%--  ${paiBan1.id} --%>
				   </td>
				</c:forEach>
			</tr>
			<tr class="text-c">
			    <td>晚班${beginTime3}--${endTime3}</td>
				<c:forEach items="${paiBans3}" var="paiBan3">
				<td><c:forEach  items="${paiBan3.sysUsers}" var="sysUser">
				       ${sysUser.name},
				   </c:forEach>
				   <%--  ${paiBan1.id} --%>
				   </td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
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
<script type="text/javascript">
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
				$(obj).remove();
				layer.msg('已停用!',{icon: 5,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!',{icon: 6,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
/*用户-编辑*/
 function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-编辑*/
/* function member_edit(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
} */
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,paibanId,userId){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{paibanId:paibanId,userId:userId},
			url: '<%=basePath%>a/paiBan/del.do',
			dataType: 'json',
			success: function(data){
				layer.msg('已删除!',{icon:1,time:1000});
				location.reload();
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/*多条删除*/
function datadel(){
	var ids = [];
	 $("input[name='ids']:checked").each(function(i){//把所有被选中的复选框的值存入数组
		 ids[i] =$(this).val();
	 });
	/* alert(ids);
	return false; */
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{ids:ids},
			dataType: 'json',
			url: '<%=basePath%>a/clCleanArea/dels.do',
			success: function(data){
				/* $(obj).parents("tr").remove(); */
				layer.msg('已删除!',{icon:1,time:1000});
				location.reload();
			},
			
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
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