<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<% Date nowDate = new Date(); request.setAttribute("nowDate", nowDate); %>
<!--_meta 作为公共模版分离出去-->
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

<link href="<%=basePath%>static/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<form action="<%=basePath%>/a/astFixedCapital/applyInWarehouse.do" method="post" class="form form-horizontal" id="form-article-add">
	<input type="hidden" value="${sysUser.id}" name="createBy.id" id="createBy.id" >
	 <input type="hidden" value="${nowDate}" name="createDate" id="createDate">
	  <input type="hidden" value="${astFixedCapital.id }" name="id" id="id">
	 <input type="hidden" value="申请入仓中" name="status" id="status">
	       
		 <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${astFixedCapital.name }" placeholder="" id="name" name="name" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">规格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="specifications" id="specifications" placeholder="" value="${astFixedCapital.specifications }" class="input-text" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">型号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="model" id="model" placeholder="" value="${astFixedCapital.model }" class="input-text" readonly="readonly">
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
				<input type="text" name="num" id="num" placeholder="" value="${astFixedCapital.num }" class="input-text" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">使用方向：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="useWay" id="useWay" placeholder="" value="${astFixedCapital.useWay }" class="input-text" readonly="readonly">
			</div>
		</div> 
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>仓库：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="whWarehouse.id" class="select" onchange="getComputingUnit()" id="whWarehouse">
				     <option value=''>请选择</option>
			      <c:forEach items="${whWarehouses }" var="whWarehouse">
					<option value="${whWarehouse.id }" >${whWarehouse.name }</option>
				  </c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">现仓库的库存量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="cuttentInventory" placeholder="" value="" class="input-text" readonly="readonly">
				<input type="text" name="computingUnit" id="computingUnit" placeholder="" value="" class="input-text" readonly="readonly">
				
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 申请</button>
<!-- 				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
 -->				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
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
<script type="text/javascript" src="<%=basePath%>static/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="<%=basePath%>static/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(document).ready(function() {
  /**获取仓库的计算单位和现库存量**/
	$("#whWarehouse").change(function(){
		var id = $("#whWarehouse").val();
			$.ajax({
				type: 'POST',
				data:{id:id},
				url: '<%=basePath%>a/pchPurchaseMessage/getWhWharehouseComputingUnit.do',
				dataType: 'json',
				success: function(data){
					$("#computingUnit").val(data.computingUnit);
					$("#cuttentInventory").val(data.cuttentInventory);
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
	});
	/**限制数量**/
  $("#num").blur(function(){
	  var num = parseInt($("#num").val());
	  var cuttentInventory = parseInt($("#cuttentInventory").val());
	  var whWarehouseId = parseInt($("#whWarehouse").val());
	   /*  if($("#whWarehouse").val()=='' || $("#whWarehouse").val()== null ){alert("请选择仓库");$("#num").val("");return false} */
		if(num>cuttentInventory) {alert("所选的仓库的现存量不足");return false}
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
	
	$("#form-article-add").validate({
		rules:{
			/* name:{
				required:true,
				minlength:2,
				maxlength:16
			}, */
			whWarehouse:{
				required:true,
			},
			/* pchPurchaseType:{
				required:true,
			},
			purchaseStartDate:{
				required:true,
			},
			purchaseEndDate:{
				required:true,
			},
			num:{
				required:true,
				number:true
			},
			spend:{
				required:true,
				number:true
			},
			originPlace:{
				required:true,
				minlength:2,
				maxlength:16
			},
			supplier:{
				required:true,
				minlength:0,
				maxlength:100
			},
			remark:{
				required:true,
				minlength:0,
				maxlength:100
			}, */
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			form.submit();
			//var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			//parent.layer.close(index);
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
</body>
</html>