<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<title>食物管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 食物中心 <span class="c-gray en">&gt;</span> 食物管理列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	  <form action="<%=basePath%>a/ctnFood/list.do" method="post">
		 日期范围：<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="datemin" class="input-text Wdate" style="width:120px;" >
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="datemax" class="input-text Wdate" style="width:120px;" >
		<input type="text" class="input-text" style="width:250px" placeholder="输入名称" id="name" name="name">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	   </form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><shiro:hasPermission name="ctn:ctnFood:del"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> </shiro:hasPermission><shiro:hasPermission name="ctn:ctnFood:save"><a href="javascript:;" onclick="member_add('添加食物','<%=basePath%>a/ctnFood/save.do?delFlag=1','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加食物</a></shiro:hasPermission></span> <span class="r">共有数据：<strong>${fn:length(ctnFoods)}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
			    <th width="25"><input type="checkbox" name="" value=""></th>
				<th width="100">标题</th>
				<!-- <th width="100">创建时间</th>
				<th width="40">创建人</th -->
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		   <c:forEach items="${ctnFoods }" var="ctnFood">
			<tr class="text-c">
				<td><input type="checkbox" value="${ctnFood.id }" name="ids" id="ids"></td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${ctnFood.name}','<%=basePath%>a/ctnFood/show.do?id=${ctnFood.id}','10001','360','400')">${ctnFood.name}</u></td>
			<%-- 	<td><fmt:formatDate value="${ctnFood.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${ctnFood.createBy.name}</td> --%>
				<td class="td-status"><span class="label label-success radius">${ctnFood.status}</span></td>
<%-- 				<c:if test="${whWarehouse.status=='正常'}">
 --%>			<td class="td-manage">
					   <shiro:hasPermission name="ctn:ctnFood:outDate"><a style="text-decoration:none" onClick="${whWarehouse.status=='正常'?'member_start':'member_stop'}(this,'${ctnFood.id}')" href="javascript:;" title="${whWarehouse.status=='正常'?'恢复':'确认过期'}"><i class="Hui-iconfont">&#xe631;</i></a></shiro:hasPermission>
					   <shiro:hasPermission name="ctn:ctnFood:edit"><a title="编辑" href="javascript:;" onclick="member_edit('编辑','<%=basePath%>a/ctnFood/update.do?id=${ctnFood.id}&delFlag=1','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a></shiro:hasPermission>
					   <shiro:hasPermission name="ctn:ctnFood:del"><a title="删除"  onClick="member_del(this,'${ctnFood.id}')" href="javascript:;"class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></shiro:hasPermission>
			     </td>
<%-- 				</c:if>
 --%>				<%-- <c:if test="${whWarehouse.status=='过期'}">
				   <td class="td-manage">
					   <a style="text-decoration:none" onClick="member_start(this,'${ctnFood.id}')" href="javascript:;" title="恢复"><i class="Hui-iconfont">&#xe631;</i></a>
					   <a title="编辑" href="javascript:;" onclick="member_edit('编辑','<%=basePath%>a/ctnFood/update.do?id=${ctnFood.id}&delFlag=1','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					   <a title="删除"  onClick="member_del(this,'${ctnFood.id}')" href="javascript:;"class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				   </td>
				</c:if> --%>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>static/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,5,5]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-过期*/
function member_stop(obj,id){
	layer.confirm('确认要过期吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{id:id,status:'过期'},
			url: '<%=basePath%>a/ctnFood/dateOutAndRecovery.do',
			dataType: 'json',
			success: function(data){
				/* $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,'+data.id+')" href="javascript:;" title="恢复"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已过期</span>');
				$(obj).remove(); */
				layer.msg('已过期!',{icon: 5,time:1000});
				location.reload();
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-恢复*/
function member_start(obj,id){
	layer.confirm('确认要恢复吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '<%=basePath%>a/ctnFood/dateOutAndRecovery.do',
			data:{id:id,status:'过期'},
			dataType: 'json',
			success: function(data){
			/* 	$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,'+data.id+')" href="javascript:;" title="确认过期"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已恢复</span>');
				$(obj).remove(); */
				layer.msg('已恢复!',{icon: 6,time:1000});
				location.reload();
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
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{id:id},
			url: '<%=basePath%>a/ctnFood/del.do',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
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
			url: '<%=basePath%>a/ctnFood/dels.do',
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
</body>
</html>