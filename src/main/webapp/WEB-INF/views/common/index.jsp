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
<title>后勤管理系统</title>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">后勤管理系统</a> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>

		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>${currentSysUser.sysRole.name}</li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${currentSysUser.name} <i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
					<!-- 	<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li> -->
						<!--<li><a href="#">切换账户</a></li>-->
						 <shiro:hasPermission name="sys:sysUser:user:update">
						<li><a href="javascript:;" onClick="member_updatePassWord('修改个人信息','<%=basePath%>a/sysUser/update.do','','600','510')">修改个人信息</a></li>、
						</shiro:hasPermission>
						<shiro:hasPermission name="sys:sysUser:user:updatePassword">
						<li><a href="javascript:;" onClick="member_updatePassWord('修改密码','<%=basePath%>a/sysUser/updatePassword.do','','600','510')">修改密码</a></li>
						</shiro:hasPermission>
						<li><a href="<%=basePath%>a/logout.do">退出</a></li>
				</ul>
			</li>
				<!-- <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li> -->
				<!-- <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li> -->
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 资产管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="ast:astFixedCapital:list">
					<li><a data-href="<%=basePath%>a/astFixedCapital/list.do" data-title="固定资产管理" href="javascript:void(0)">固定资产管理</a></li>
					</shiro:hasPermission>
					<li><a data-href="<%=basePath%>a/astFixedCapital/save.do" data-title="添加已有的固定资产" href="javascript:void(0)">添加已有的固定资产</a></li>
					<li><a data-href="<%=basePath%>a/reRepairOrder/list.do?type=1" data-title="设备维修" href="javascript:void(0)">设备维修</a></li>
					
					<%--  <shiro:hasPermission name="ast:astWorkingCapital:list">
					<li><a data-href="<%=basePath%>a/astWorkingCapital/list.do" data-title="流动资产管理" href="javascript:void(0)">流动资产管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="ast:astSpecialCapital:list">
					<li><a data-href="<%=basePath%>a/astSpecialCapital/list.do" data-title="专项资产管理" href="javascript:void(0)">专项资产管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="ast:astCapitalStatistics:list">
					<li><a data-href="<%=basePath%>a/astCapitalStatistics/list.do" data-title="资产统计" href="javascript:void(0)">资产统计</a></li> --%>
			<%-- 		</shiro:hasPermission> --%>
			</ul>
		</dd>
	</dl>
	<!-- <dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe613;</i> 图片管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="picture-list.html" data-title="图片管理" href="javascript:void(0)">图片管理</a></li>
			</ul>
		</dd>
	</dl> -->
	<%-- <shiro:hasPermission name="sys:user:save"> --%>
	<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 采购管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="pch:pchPurchaseMessage:list">
					<li><a data-href="<%=basePath%>a/pchPurchaseMessage/list.do" data-title="采购管理" href="javascript:void(0)">采购管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="pch:pchPurchaseType:list">
					<li><a data-href="<%=basePath%>a/pchPurchaseType/list.do" data-title="采购管理类型" href="javascript:void(0)">采购管理类型</a></li>
					</shiro:hasPermission>
					<%-- <shiro:hasPermission name="pch:pchPurchaseType:list"> --%>
					<li><a data-href="<%=basePath%>a/pchPurchaseMessage/apply.do" data-title="采购申请" href="javascript:void(0)">采购申请</a></li>
					<%-- </shiro:hasPermission> --%>
					 <shiro:hasPermission name="wh:whWarehouseApply:list">
					<li><a data-href="<%=basePath%>a/whWarehouseApply/list.do" data-title="仓库申请" href="javascript:void(0)">仓库申请</a></li>
					</shiro:hasPermission>
					
			</ul>
		</dd>
	</dl>
<%-- 	</shiro:hasPermission> --%>
    <dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 仓库管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="wh:whWarehouse:list">
					<li><a data-href="<%=basePath%>a/whWarehouse/list.do" data-title="仓库管理" href="javascript:void(0)">仓库管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="wh:whWarehouseType:list">
					<li><a data-href="<%=basePath%>a/whWarehouseType/list.do" data-title="仓库类型管理" href="javascript:void(0)">仓库类型管理</a></li>
					</shiro:hasPermission>
			<%-- 		 <shiro:hasPermission name="wh:whWarehouseApply:list">
					<li><a data-href="<%=basePath%>a/whWarehouseApply/list.do" data-title="仓库申请" href="javascript:void(0)">仓库申请</a></li>
					</shiro:hasPermission> --%>
				<%-- 	 <shiro:hasPermission name="wh:whWarehouseApply:list"> --%>
					<li><a data-href="<%=basePath%>a/whWarehouse/astFixedCapitalApplyList.do" data-title="固定资产申请入仓列表" href="javascript:void(0)">固定资产申请入仓列表</a></li>
					<%-- </shiro:hasPermission> --%>
			</ul>
		</dd>
	</dl>
    <dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 物业管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<!-- <li><a data-href="product-brand.html" data-title="品牌管理" href="javascript:void(0)">品牌管理</a></li>
					<li><a data-href="product-category.html" data-title="分类管理" href="javascript:void(0)">分类管理</a></li>
					<li><a data-href="product-list.html" data-title="产品管理" href="javascript:void(0)">产品管理</a></li> -->
					 <shiro:hasPermission name="pty:ptyProperty:list">
					<li><a data-href="<%=basePath%>a/ptyProperty/list.do" data-title="物业管理" href="javascript:void(0)">物业管理</a></li>
					</shiro:hasPermission>
					<li><a data-href="<%=basePath%>a/reRepairOrder/list.do?type=2" data-title="物业维修" href="javascript:void(0)">物业维修</a></li>
				<%-- 	<shiro:hasPermission name="pty:ptyPropertyType:list">
					<li><a data-href="<%=basePath%>a/ptyPropertyType/list.do" data-title="物业管理类型" href="javascript:void(0)">物业管理类型</a></li>
					</shiro:hasPermission> --%>
			</ul>
		</dd>
	</dl>
    <dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 食堂管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="ctn:ctnFood:list">
					<li><a data-href="<%=basePath%>a/ctnFood/list.do" data-title="食物管理" href="javascript:void(0)">食物管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="ctn:ctnFoodType:list">
					<li><a data-href="<%=basePath%>a/ctnFoodType/list.do" data-title="食物类型管理" href="javascript:void(0)">食物类型管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="ctn:ctnMenu:list">
					<li><a data-href="<%=basePath%>a/ctnMenu/list.do" data-title="菜单管理" href="javascript:void(0)">菜单管理</a></li>
					</shiro:hasPermission>
			</ul>
		</dd>
	</dl>

    <dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 维修管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="re:reRepairOrder:list">
					<li><a data-href="<%=basePath%>a/reRepairOrder/list.do" data-title="维修管理" href="javascript:;">维修管理</a></li>
					</shiro:hasPermission>
				    <shiro:hasPermission name="re:reRepairOrderType:list">
					<li><a data-href="<%=basePath%>a/reRepairOrderType/list.do" data-title="维修类型管理" href="javascript:;">维修类型管理</a></li>
					</shiro:hasPermission>
                </ul>    
		</dd>
	</dl>
    <dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 保洁管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <%-- <shiro:hasPermission name="cl:clClean:list">
					<li><a data-href="<%=basePath%>a/clClean/list.do" data-title="保洁管理" href="javascript:;">保洁管理</a></li>
					</shiro:hasPermission> --%>
					<shiro:hasPermission name="cl:clClean:list">
					<li><a data-href="<%=basePath%>a/clCleanArea/list.do" data-title="保洁区域管理" href="javascript:;">保洁区域管理</a></li>
					</shiro:hasPermission>
					<li><a data-href="<%=basePath%>a/paiBan/inti.do" data-title="排班" href="javascript:;">排班</a></li>
                </ul>    
		</dd>
	</dl>
    <dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 公告管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
				    <shiro:hasPermission name="nt:ntNotice:list">
					<li><a data-href="<%=basePath%>a/ntNotice/list.do" data-title="公告管理" href="javascript:;">公告管理</a></li>
					</shiro:hasPermission>
					<%-- <shiro:hasPermission name="nt:ntNoticeType:list">
                    <li><a data-href="<%=basePath%>a/ntNoticeType/list.do" data-title="公告类型管理" href="javascript:;">公告类型管理</a></li>
                    </shiro:hasPermission> --%>
                    <shiro:hasPermission name="nt:ntNotice:shows">
                    <li><a data-href="<%=basePath%>a/ntNotice/shows.do" data-title="公告查看" href="javascript:;">公告查看</a></li>
                    </shiro:hasPermission>
			</ul>
		</dd>
	</dl>
      <dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 建言建策<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<!-- <li><a data-href="http://h-ui.duoshuo.com/admin/" data-title="评论列表" href="javascript:;">评论列表</a></li>
					<li><a data-href="feedback-list.html" data-title="意见反馈" href="javascript:void(0)">意见反馈</a></li>  -->
					 <shiro:hasPermission name="ad:adAdvice:list">
					<li><a data-href="<%=basePath%>a/adAdvice/list.do" data-title="建言建策管理" href="javascript:;">建言建策</a></li>
					</shiro:hasPermission>
					<%--  <shiro:hasPermission name="ad:adAdviceType:list">
                    <li><a data-href="<%=basePath%>a/adAdviceType/list.do" data-title="建言建策类型管理" href="javascript:;">建言建策类型管理</a></li>
                    </shiro:hasPermission> --%>
					
					
			</ul>
		</dd>
	</dl>
			<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="sys:sysRole:list">
					<li><a data-href="<%=basePath%>a/sysRole/list.do" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="sys:sysPermission:list">
					<li><a data-href="<%=basePath%>a/sysPermission/list.do" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="sys:sysUser:list">
					<li><a data-href="<%=basePath%>a/sysUser/list.do" data-title="用户管理" href="javascript:;">用户管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="sys:sysDepartment:list">
                    <li><a data-href="<%=basePath%>a/sysDepartment/list.do" data-title="部门管理" href="javascript:;">部门管理</a></li>
                    </shiro:hasPermission>
					<!--<li><a data-href="admin-list.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>-->
			</ul>
		</dd>
	</dl>
  <%--   <dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul> <shiro:hasPermission name="sys:sysUser:list">
					<li><a data-href="<%=basePath%>a/sysUser/list.do" data-title="用户管理" href="javascript:;">用户管理</a></li>
					</shiro:hasPermission>
					 <shiro:hasPermission name="sys:sysDepartment:list">
                    <li><a data-href="<%=basePath%>a/sysDepartment/list.do" data-title="部门管理" href="javascript:;">部门管理</a></li>
                    </shiro:hasPermission>
                     <shiro:hasPermission name="sys:sysUser:user:update">
                    <li><a data-href="<%=basePath%>a/sysUser/update.do" data-title="修改个人信息" href="javascript:;">修改个人信息</a></li>
                    </shiro:hasPermission>
                     <shiro:hasPermission name="sys:sysUser:user:updatePassword">
                    <li><a data-href="<%=basePath%>a/sysUser/updatePassword.do" data-title="修改密码" href="javascript:;">修改密码</a></li>
                    </shiro:hasPermission>
                     <shiro:hasPermission name="sys:sysUser:updatePhoto">
                    <li><a data-href="<%=basePath%>a/sysUser/updatePhoto.do" data-title="修改个人头像" href="javascript:;">修改个人头像</a></li>
                    </shiro:hasPermission>
                </ul>
		</dd>
	</dl> --%>
    <!--
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="charts-1.html" data-title="折线图" href="javascript:void(0)">折线图</a></li>
					<li><a data-href="charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
					<li><a data-href="charts-3.html" data-title="区域图" href="javascript:void(0)">区域图</a></li>
					<li><a data-href="charts-4.html" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
					<li><a data-href="charts-5.html" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
					<li><a data-href="charts-6.html" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
					<li><a data-href="charts-7.html" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
			</ul>
		</dd>
	</dl>
  
    
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
					<li><a data-href="system-category.html" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
					<li><a data-href="system-data.html" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
					<li><a data-href="system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
					<li><a data-href="system-log.html" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
			</ul>
		</dd>
	</dl>
      -->
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="welcome.html">我的桌面</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="<%=basePath%>welcome.html"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/
});
/*个人信息*/
function myselfinfo(){
	layer.open({
		type: 1,
		area: ['300px','200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: '<div>管理员信息</div>'
	});
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-修改密码*/
function member_updatePassWord(title,url,id,w,h){
	layer_show(title,url,w,h);
}

</script> 


</body>
</html>