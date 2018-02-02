<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="plugs/bootstrap/css/left_page.css" />
		<link rel="stylesheet" href="plugs/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="plugs/bootstrap/css/right_page.css" />
		<link rel="stylesheet" type="text/css" href="plugs/bootstrap/css/base.css" />
		<link rel="stylesheet" type="text/css" href="plugs/bootstrap/css/left.css" />
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<script type="text/javascript">
            function iframeLoad()
            {
                document.getElementById("iframe").height=0;
                document.getElementById("iframe").height=document.getElementById("iframe").contentWindow.document.body.scrollHeight+100;
            }
		</script>
		<title>首页</title>
	</head>

	<body>
	<div class="container">
		<!--头部-->
		<div id="head">
			<table class="table table-bordered">
				<tr>
					<td class="head">新闻管理系统</td>
					<td class="head_right">
						<button class="btn-link head_right">admin</button>
						<img class="img_login_out" src="img/login_out.png" />
					</td>

				</tr>
			</table>
		</div>
		<!--导航-->
		<div class="left_nav">
			<div class="container-fluid">
				<div>
					<div>
						<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">

							<li>
								<a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
									<i class="glyphicon glyphicon-cog"></i> 系统管理
									<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
								</a>
								<ul id="systemSetting" class="nav nav-list collapse secondmenu">
									<li><a href="<%=basePath%>admin/user" target="mainFrame">
										<i class="glyphicon glyphicon-user"></i>用户管理</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
								</ul>
							</li>

							<li>
								<a href="./plans.html">
									<i class="glyphicon glyphicon-credit-card"></i> 物料管理
								</a>
							</li>
							<li>
								<a href="./grid.html">
									<i class="glyphicon glyphicon-globe"></i> 分发配置
									<span class="label label-warning pull-right">5</span>
								</a>
							</li>
							<li>
								<a href="./charts.html">
									<i class="glyphicon glyphicon-calendar"></i> 图表统计
								</a>
							</li>
							<li>
								<a href="#">
									<i class="glyphicon glyphicon-fire"></i> 关于系统
								</a>
							</li>
						</ul>
					</div>

				</div>
			</div>

		</div>

		<!--内容页（right)-->
		<div class="right">

			<div class="right_content"/>

			<iframe id="iframe" src="admin_user.jsp	" name="mainFrame"
					width="100%" scrolling="no" height="100%" frameborder="0" onload="iframeLoad()">

			</iframe>
		</div>

	</div>
	</div>
	</body>
</html>
