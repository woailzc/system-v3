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
<title>维修管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 维修中心 <span class="c-gray en">&gt;</span> 维修管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	  <form action="<%=basePath%>a/reRepairOrder/list.do" method="post">
		 日期范围：<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="datemin" class="input-text Wdate" style="width:120px;" >
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="datemax" class="input-text Wdate" style="width:120px;" >
		<input type="text" class="input-text" style="width:250px" placeholder="输入部门名" id="name" name="name">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	   </form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><%-- <shiro:hasPermission name="re:reRepairOrder:del"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></shiro:hasPermission> --%> <shiro:hasPermission name="re:reRepairOrder:save"><a href="<%=basePath%>a/reRepairOrder/save.do?delFlag=1&&type=${type }" onclick="member_add('申请','<%=basePath%>a/reRepairOrder/save.do?delFlag=1&&type=${param.type }','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 申请</a></shiro:hasPermission></span><span class="r">共有数据：<strong>${fn:length(reRepairOrders)}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
<!-- 			    <th width="25"><input type="checkbox" name="" value=""></th>
 -->			<th width="100">种类</th>
                <th width="100">内容</th>
                 <th width="140">情况描述</th>
				<th width="100">申请维修时间</th>
				<th width="40">地点</th>
				<th width="40">申请人</th>
				<th width="40">申请人的联系电话</th>
				<th width="60">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		   <c:forEach items="${reRepairOrders }" var="reRepairOrder">
			<tr class="text-c">
<!-- 				<td><input type="checkbox" value="1" name=""></td>
 -->				<td>${reRepairOrder.repairOrderType.name}</td>
				<td>${reRepairOrder.contex}</td>
				<td>${reRepairOrder.reason}</td>
				<td><fmt:formatDate value="${reRepairOrder.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${reRepairOrder.repairAdress}</td>
				<td>${reRepairOrder.applyer.name}</td>
				<td>${reRepairOrder.applyer.phone}</td>
				<td class="td-status"><span class="label label-success radius">${reRepairOrder.status}</span></td>
				<td class="td-manage">
				   <a title="查看" href="javascript:;" onclick="member_show('查看','<%=basePath%>a/reRepairOrder/show.do?id=${reRepairOrder.id}','4','','510')" class="ml-5" style="text-decoration:none">查看</a>
				   <c:if test="${reRepairOrder.status=='待处理'}">
				     <shiro:hasPermission name="re:reRepairOrder:edit"><a title="编辑" href="javascript:;" onclick="member_edit('编辑','<%=basePath%>a/reRepairOrder/update.do?id=${reRepairOrder.id}&delFlag=1','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> </shiro:hasPermission>
				   </c:if>
					<shiro:hasPermission name="re:reRepairOrder:del"><a title="删除"  onClick="member_del(this,'${reRepairOrder.id }','${currentUser.id == reRepairOrder.applyer.id? '1':'0' }','${currentUser.id == reRepairOrder.receiver.id? '1':'0' }')" href="javascript:;"class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></shiro:hasPermission>
					<c:if test="${reRepairOrder.status=='待处理'}">
					 <shiro:hasPermission name="re:reRepairOrder:accept"><a style="text-decoration:none" onClick="accept(this,'${reRepairOrder.id}')" href="javascript:;" title="接受">接受</a></shiro:hasPermission>
					</c:if>
					<c:if test="${reRepairOrder.status=='已接受'}">
					 <shiro:hasPermission name="re:reRepairOrder:confirm"> <a style="text-decoration:none" onClick="confirm_finish(this,'${reRepairOrder.id}','${reRepairOrder.contex}','${type }' )" href="javascript:;" title="确认完成">确认完成</a></shiro:hasPermission>
					</c:if>
					<c:if test="${reRepairOrder.status=='已完成'&& reRepairOrder.applyer.id == currentUser.id}">
					 <shiro:hasPermission name="re:reRepairOrder:evaluate"> <a style="text-decoration:none" onClick="evaluate(this,'${reRepairOrder.id}')" href="javascript:;" title="评价">评价</a></shiro:hasPermission>
					</c:if>

			
				</td>
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
/*用户-完成*/
function confirm_finish(obj,id,context,type){
	layer.confirm('确认要完成吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{id:id,status:'已完成',contex:context,type:type},
			url: '<%=basePath%>a/reRepairOrder/acceptAndFinish.do',
			dataType: 'json',
			success: function(data){
				/* $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>'); */
		/* 		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已完成</span>');
				$(obj).remove(); */
				layer.msg('已完成!',{icon: 5,time:1000});
				location.reload();
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-接受*/
function accept(obj,id){
	layer.confirm('确认要接受吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{id:id,status:'已接受'},
			url: '<%=basePath%>a/reRepairOrder/acceptAndFinish.do',
			dataType: 'json',
			success: function(data){
				/* $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>'); */
			/* 	$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已接受</span>');
				$(obj).remove(); */
				layer.msg('已接受!',{icon: 6,time:1000});
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
function member_del(obj,id,applyerDelFlag,receiverDelFlag){

	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{applyerDelFlag:applyerDelFlag,receiverDelFlag:receiverDelFlag,id:id},
			url: '<%=basePath%>a/reRepairOrder/del.do',
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


</script> 
</body>
</html>