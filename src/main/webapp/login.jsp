<%--
  Created by IntelliJ IDEA.
  User: 14221
  Date: 2018/2/3
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head >
    <title>登陆页面</title>




    <!--引入样式的先后问题，会产生不同的影响-->
    <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/orange.css" />
    <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/carrt_base.css" />
    <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/public.css" />
    <!-- jq -->
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>

    <script type="text/javascript" src="<%=basePath%>/plugs/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="wrapper">

<div class="bg-img ">
    <div class="login-container  container">
        <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div>
                    <img src="img/login-logo.png" class="login-circle-img">
                </div>
                <div class="panel-body login-panel">
                    <form  action = "<%=basePath%>login/admin" name="loginForm"
                          method="post" class="login-from" >
                        <div class="form-group">
                            <input class="form-control input-lg pd-left-50 login-user  " placeholder="用户名"
                                   name="adminName"  maxlength="16">
                            <div class="login-user-icon"></div>
                        </div>
                        <div class="form-group">
                            <input class="form-control input-lg pd-left-50 login-psd" placeholder="密码"
                                   name="password"
                                   type="password"  minlength="6" maxlength="16">
                            <div class="login-psd-icon"></div>
                        </div>
                        <span class="error">
                            <%--${sessionScope['org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS'][0]['login']}  --%>

                          ${param.login}
                            </span>

                        <input type="submit" class="btn btn-lg btn-submit btn-block login-btn" value="登陆">
                        </input>
                    </form>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>


</body>
</html>
