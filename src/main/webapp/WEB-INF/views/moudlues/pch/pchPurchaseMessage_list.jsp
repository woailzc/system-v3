<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
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
<title>采购申请列表</title>
<link rel="stylesheet" href="<%=basePath%>static/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body class="pos-r">
<div class="pos-a" style="width:200px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5; overflow:auto;">
	<ul id="treeDemo" class="ztree"></ul>
</div>
<div style="margin-left:200px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c"> 
		<form action="<%=basePath%>a/pchPurchaseMessage/list.do" method="post">
		日期范围：
			<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="datemin" class="input-text Wdate" style="width:120px;" >
		-
			<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="datemax" class="input-text Wdate" style="width:120px;" >
			<input type="text" class="input-text" style="width:250px" placeholder="产品名称" id="name" name="name">
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜名字</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><shiro:hasPermission name="pch:pchPurchaseMessage:del"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></shiro:hasPermission>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<%-- 		<shiro:hasPermission name="pch:pchPurchaseMessage:save"> <a class="btn btn-primary radius" onclick="product_add('添加产品','<%=basePath%>a/pchPurchaseMessage/save.do?id=${pchPurchaseType.id}&delFlag=1')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></shiro:hasPermission></span>
 --%>		<%--  <span class="r">共有数据：<strong>${fn:length(pchPurchaseMessages)}</strong> 条</span> --%> </div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="40"><input name="" type="checkbox" value=""></th>
						<!-- <th width="40">ID</th> -->
						<!-- <th width="60">缩略图</th> -->
						<th width="100">申请名称</th>
						<th>规格</th>
						<th width="100">型号</th>
						<th width="100">单价</th>
						<th width="100">数量</th>
						<th width="100">使用方向</th>
						<th width="100">申请时间</th>
						<th width="100">申请人</th>
						<th width="100">状态</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pchPurchaseMessages}" var="pchPurchaseMessage">
					<tr class="text-c va-m">
						<td><input type="checkbox" value="${pchPurchaseMessage.id }" name="ids" id="ids"></td>
					    <td class="text-l">${pchPurchaseMessage.name }</td>
						<td class="text-l">${pchPurchaseMessage.specifications }</td>
						<td>${pchPurchaseMessage.model }</td>
						<td>${pchPurchaseMessage.unitPrice }</td>
						<td>${pchPurchaseMessage.num }</td>
						<td>${pchPurchaseMessage.useWay }</td>
						<td><fmt:formatDate value="${pchPurchaseMessage.purchaseStartDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${pchPurchaseMessage.createBy.name }</td>
						<td>${pchPurchaseMessage.status }</td>
						<td class="td-manage">
						 <shiro:hasPermission name="pch:pchPurchaseMessage:edit"><a style="text-decoration:none" class="ml-5" onClick="product_edit('产品编辑','<%=basePath%>a/pchPurchaseMessage/update.do?id=${pchPurchaseMessage.id}&delFlag=1','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> </shiro:hasPermission>
						 <shiro:hasPermission name="pch:pchPurchaseMessage:del"><a style="text-decoration:none" class="ml-5" onClick="product_del(this,'${pchPurchaseMessage.id}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></shiro:hasPermission>
								<c:if test="${pchPurchaseMessage.status=='审核'}">
								  <shiro:hasPermission name="pch:pchPurchaseMessage:aduit"><a style="text-decoration:none" onClick="article_shenhe(this,'${pchPurchaseMessage.id}')" href="javascript:;" title="审核">审核</a></shiro:hasPermission>
								</c:if>
								<c:if test="${pchPurchaseMessage.status=='审核通过'}">
								  <shiro:hasPermission name="pch:pchPurchaseMessage:finsh"><a style="text-decoration:none" onClick="comfirm(this,'${pchPurchaseMessage.id}')" href="javascript:;" title="确认采购完成">确认采购完成<i class="Hui-iconfont">&#xe631;</i></a></shiro:hasPermission>
								</c:if> 
						 </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>static/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				//demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};

/* var zNodes =[
	{ id:1, pId:0, name:"一级分类", open:true},
	{ id:11, pId:1, name:"二级分类"},
	{ id:111, pId:11, name:"三级分类"},
	{ id:112, pId:11, name:"三级分类"},
	{ id:113, pId:11, name:"三级分类"},
	{ id:114, pId:11, name:"三级分类"},
	{ id:115, pId:11, name:"三级分类"},
	{ id:12, pId:1, name:"二级分类 1-2"},
	{ id:121, pId:12, name:"三级分类 1-2-1"},
	{ id:122, pId:12, name:"三级分类 1-2-2"},
]; */
		
		
		
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	//demoIframe = $("#testIframe");
	//demoIframe.on("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
});

$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[0,4]}// 制定列不参与排序
	]
});
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-查看*/
function product_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*确认采购完成*/
function comfirm(obj,id){
	layer.confirm('确认要完成采购吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{status:'采购完成',id:id},
			url: '<%=basePath%>a/pchPurchaseMessage/comfirm.do',
			dataType: 'json',
			success: function(data){
/* 				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
 */		/* 		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">空闲</span>');
				$(obj).remove(); */
				 location.reload();
				layer.msg('已完成!',{icon: 5,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/*申请-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$.ajax({
			type: 'POST',
			data:{id:id,status:'审核通过'},
			url: '<%=basePath%>a/pchPurchaseMessage/audit.do',
			dataType: 'json',
			success: function(data){
				location.reload();
				layer.msg('审核通过', {icon:6,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
		
	},
	function(){
		$.ajax({
			type: 'POST',
			data:{status:'审核不通过',id:id},
			url: '<%=basePath%>a/pchPurchaseMessage/audit.do',
			dataType: 'json',
			success: function(data){
				location.reload();
				layer.msg('审核不通过', {icon:5,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});	
}
/*产品-下架*/
function product_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*产品-发布*/
function product_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}

/*产品-申请上线*/
function product_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

/*产品-编辑*/
function product_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*产品-删除*/
function product_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{id:id},
			url: '<%=basePath%>a/pchPurchaseMessage/del.do',
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
			url: '<%=basePath%>a/pchPurchaseMessage/dels.do',
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