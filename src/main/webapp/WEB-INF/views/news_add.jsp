<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
        <meta charset="utf-8">
        <title>发布新闻</title>
			<meta charset="UTF-8">

        <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/orange.css" />
        <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/carrt_base.css" />
        <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/public.css" />


        <!-- jq -->
        <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>

        <script type="text/javascript" src="<%=basePath%>/plugs/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript">

            function getExpressCompany() {
                $.ajax({
                    type : "get",
                    url : '<%=basePath%>channel/channelList',    //url根据自己的项目实际定义
                    async : false,
                    dataType : "text",
                    error : function() {
                        alert("系统忙，请稍后再试！");
                        return false;
                    },
                    success : function(text) {
                        var channel = $("#channel");

                        var str = '';
                        var data = eval("("+text+")");;
                        for(var o in data) {
                            str += '<option value="'+data[o].id+'">'+data[o].name+'</option>';
                        }
                        channel.append(str);
                    }
                });
            }
        </script>


	</head>
    <body class="border20">
    <div class="panel panel-default">
        <div class="panel-heading">
            <!--根据传过来的参数中是否有id,来判断是显示新增还是编辑-->
            <strong>编辑新闻</strong>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" name="myForm">
                <div class="form-group">
                    <label class="col-md-2 control-label "><span class="text-danger">*</span>新闻标题</label>
                    <div class="col-md-8">
                        <input class="form-control" name="title">
                        <span class="error" >

                    </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label word-spacing-25"><span class="text-danger">*</span>新闻类型</label>
                    <div class="col-md-2">
                        <select id="channel" class="form-control"onclick="getExpressCompany()"  name="type">
                            <%--<option value="">请选择</option>--%>
                            <%--<option value="0">首页Banner</option>--%>
                            <%--<option value="1">找职位Banner</option>--%>
                            <%--<option value="2">找精英Banner</option>--%>
                            <%--<option value="3">行业大图</option>--%>
                        </select>
                        <span class="error" >
                        * 类型不能为空
                    </span>
                    </div>
                    <div class="col-md-2">
                        <select class="form-control"  name="industry" required>
                            <option value="">请选择</option>
                            <option value="0">移动互联网</option>
                            <option value="1">电子商务</option>
                            <option value="2">企业服务</option>
                            <option value="3">O2O</option>
                            <option value="4">教育</option>
                            <option value="5">金融</option>
                            <option value="6">游戏</option>
                        </select>
                        <span class="error" ng-show="myForm.industry.$invalid && myForm.industry.$dirty">

                    </span>

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label word-spacing-25"><span class="text-danger">*</span>说 明</label>
                    <div class="col-md-8">
                        <!--<input class="form-control" type="text" ng-model="vm.params.content" name="content" required>-->
                        <!--富文本编辑器-->
                        <div type="text/html" style="margin:auto;height:300px;"
                             name="content" meta-umeditor meta-umeditor-placeholder="内容 " required="">
                            <textarea class="form-control " style="height: 300px; font-size: 18px;"  maxlength="5000">

                            </textarea>

                        </div>
                        <span class="error">
                        * 说明不能为空
                    </span>
                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label"><span class="text-danger">*</span>跳转链接</label>
                    <div class="col-md-8">
                        <input class="form-control" ng-model="vm.params.url" name="url" required>
                        <span class="error" ng-show="myForm.url.$invalid && myForm.url.$dirty">
                        * 跳转链接不能为空
                    </span>
                    </div>
                </div>

                <div class="row form-group">
                    <label class="col-md-2 control-label word-spacing-25"><span class="text-danger">*</span>配 图</label>
                    <div class="col-md-10">
                        <!-- div class="col-md-10 padding-10"-->
                        <div class="col-md-12 ">
                            <label class="btn btn-primary" for="file2">选择文件</label>
                            <input id="file2" style="display: none" type="file" nv-file-select uploader="vm.uploader1">
                        </div>
                        <div class="col-md-12">
                            <img ng-src="{{vm.params.img}}" alt="配图预览" ng-if="vm.params.img" class="img-responsive">
                        </div>
                        <div class="col-md-12">
                            <div class="table-responsive col-md-8 padding-0">
                                <table class="table">
                                    <thead>
                                    <th>图片名</th>
                                    <th ng-show="vm.uploader1.isHTML5">文件大小</th>
                                    <th ng-show="vm.uploader1.isHTML5">进度</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="item in vm.uploader1.queue track by $index" class="ng-scope"
                                        ng-if="$first">
                                        <!--ng-if="$first"确保每一次上传一张图片-->
                                        <td>
                                            <strong class="ng-binding">{{item.file.name}}</strong>
                                            <img ng-src="{{vm.params.img}}" alt="配图预览" ng-if="vm.params.img"
                                                 class="img-responsive">
                                        </td>
                                        <td ng-show="vm.uploader1.isHTML5" class="ng-binding">{{
                                            item.file.size/1024/1024 | number:2 }} MB
                                        </td>
                                        <!--如果表达式的计算结果为true，则ng-show指令将显示指定的HTML元素，否则HTML元素将被隐藏。-->
                                        <td ng-show="vm.uploader1.isHTML5">
                                            <div class="progress" style="margin-bottom: 0;">
                                                <div class="progress-bar" role="progressbar"
                                                     ng-style="{ 'width': item.progress + '%' }"></div>
                                            </div>
                                        </td>
                                        <td class="text-center">
                                            <span ng-show="item.isSuccess">
                                                <i class="glyphicon glyphicon-ok"></i>
                                            </span>
                                            <span ng-show="item.isCancel">
                                                <i class="glyphicon glyphicon-ban-circle"></i>
                                            </span>
                                            <span ng-show="item.isError">
                                                <i class="glyphicon glyphicon-remove"></i>
                                            </span>
                                        </td>
                                        <td nowrap="">
                                            <button type="button" class="btn btn-info btn-xs" ng-click="item.upload()"
                                                    ng-disabled="item.isReady || item.isUploading || item.isSuccess">
                                                <i class="fa fa fa-upload"></i> 上传
                                            </button>
                                            <button type="button" class="btn btn-danger btn-xs"
                                                    ng-click="item.remove(); vm.clearImg()">
                                                <i class="fa fa fa-trash"></i> 删除
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-8  col-md-offset-2">
                        <!-- 每个input都不为空且验证通过时且图片上传，最下方的提交按钮才变为可使用状态-->
                        <button type="button" class="btn btn-success" ng-click="vm.publishArticle() "
                                ng-disabled="myForm.$invalid||vm.params.img===undefined">立即上线
                        </button>
                        <button type="button" class="btn btn-success" ng-click="vm.saveArticle()"
                                ng-disabled="myForm.$invalid||vm.params.img===undefined">存为草稿
                        </button>
                        <button type="button" class="btn btn-danger pull-right" ng-click="vm.cancelArticle()"
                                ui-sref="field.articleList">取消
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>




    </body>
</html>