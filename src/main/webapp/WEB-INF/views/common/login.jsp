<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false" %>
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
<link href="<%=basePath%>static/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>


<script>
DD_belatedPNG.fix('*');

</script>
<![endif]-->

<title>后勤管理系统后台登录 </title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="<%=basePath%>/a/login.do" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="loginName" name="loginName" type="text" placeholder="账户" class="input-text size-L" required="required">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="oldPassword" name="password" type="password" placeholder="密码" class="input-text size-L" required="required">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
            <div id="v_container" style="width: 200px;height: 50px;"></div>
          <input id="code_input" class="input-text size-L" required="required" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <%--<img src="/SessionTest/VerificodeServlet" id="image"> <a id="kanbuq" href="javascript:change();">看不清，换一张</a> </div>--%>
      </div>
      </div>
   <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="rememberMe" id="rememberMe" value="true">
            使我保持登录状态</label>
     </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" id="my_button" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" >
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;" >
        </div>
      </div>
    </form>
  </div>
</div>
<input type="hidden" value="${message }" name="msg" id="msg">
<div class="footer">后勤管理系统后台</div>
<script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/gVerify.js" ></script>
<script type="text/javascript">
window.onload=function(){
	var msg = document.getElementById('msg').value;
	if(msg != null && msg != '') {layer.msg(msg,{icon: 5,time:2000});}
	
}
var verifyCode = new GVerify("v_container");

document.getElementById("my_button").onclick = function(){
    var res = verifyCode.validate(document.getElementById("code_input").value);
    if(res){
        return true;
    }else{
        alert("验证码错误");
        return false;
    }
}



</script>
</body>
</html>