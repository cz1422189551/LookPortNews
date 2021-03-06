<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/left_page.css" />
		<link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/right_page.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>plugs/bootstrap/css/base.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>plugs/bootstrap/css/left.css" />
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
						<button class="btn-link head_right">${requestScope.admin.adminName}</button>
						<img class="img_login_out" src="../../img/login_out.png" />
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

							<c:forEach var="role" items="${requestScope.admin.roleList}" varStatus="idexStatus">
								<c:forEach var="parentFunction" items="${role.functionList}" varStatus="idxStatus">
									<li>
										<a href="#systemSetting${idxStatus.count}" class="nav-header collapsed" data-toggle="collapse">
											<i class="${parentFunction.icon}"></i> ${parentFunction.name}
											<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
										</a>
											<ul id="systemSetting${idxStatus.count}" class="nav nav-list collapse secondmenu">
										<c:forEach var="subFunction" items="${parentFunction.subFunctionList}">
											<li><a href="<%=basePath%>${subFunction.url}" target="mainFrame">
												<i class="${subFunction.icon}"></i>${subFunction.name}</a></li>
										</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</c:forEach>

						</ul>
					</div>

				</div>
			</div>

		</div>

		<!--内容页（right)-->
		<div class="right">

			<div class="right_content"/>

			<iframe id="iframe" src="../welcome.jsp" name="mainFrame"
					width="100%" scrolling="no"  frameborder="0" onload="iframeLoad() ">

			</iframe>
		</div>

	</div>
	</div>

	</body>
</html>
