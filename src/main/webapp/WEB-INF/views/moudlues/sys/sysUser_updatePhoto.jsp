<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet" href="<%=basePath%>static/lib/bootstrap.min.css" >
<link rel="stylesheet" href="<%=basePath%>static/lib/assets/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>static/lib/assets/css/view.css" />
<link rel="stylesheet" href="<%=basePath%>static/lib/assets/css/admin.css">
<link href="<%=basePath%>static/lib/bootstrap-fileInput.css" rel="stylesheet">
 <script src="<%=basePath%>static/lib/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>static/lib/bootstrap-fileInput.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script>  --%>
<title></title>
<style type="text/css">
.custom-logo {
	background-color: #fff;
}
</style>


</head>
<body class="layui-view-body">

	<div class="layui-content">
		<div class="layui-row">
			<div class="layui-card">
				<div class="layui-card-header">修改头像</div>
				<form class="layui-form layui-card-body" action="<%=basePath%>a/sysUser/updatePhoto.do"  method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<label class="layui-form">我的头像</label><br>
						<div class="layui-input-block custom-logo">
							<img src="<%=basePath%>/sysUserPhoto/${sysUser.photo }" alt="" /><br>
						</div>
					</div><hr>
					<div class="layui-form-item">
					<label class="layui-form">修改头像</label><br>
           <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                    <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                        <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="images/noimage.png" alt="" />
                    </div>
                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                    <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="Mphoto" id="Mphoto" accept="image/gif,image/jpeg,image/x-png"/>
                        </span>
                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                    </div>
                </div>
           </div>
					<div class="layui-form-item">
						<div class="layui-input-block">
						    <input type="hidden" name="id" value="${sysUser.id }">
							<button class="layui-btn layui-btn-blue" lay-submit
								lay-filter="formDemo">保存</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="<%=basePath%>static/lib/assets/layui.all.js"></script>
	<script>
		var form = layui.form, layer = layui.layer;
	</script>

</body>
</html>