<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<
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
        <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>

        <script type="text/javascript" src="<%=basePath%>/plugs/bootstrap/js/bootstrap.min.js"></script>
        <!-- include summernote css/js-->
        <link href="<%=basePath%>dist/summernote.css" rel="stylesheet">
        <!-- jq -->

        <script src="<%=basePath%>dist/summernote.js"></script>

        <script type="text/javascript">

            function alerts(){
                var markupStr = $('#summernote').summernote('code');
                alert(markupStr);
            }

            function setChannel(parent, sub,channelList)
            {
                console.log("测试");
                var  p = parent.value;


                for(i=0; i<channelList.length; i++)
                {
                    console.log(channelList[i].name);
                }

            }
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#summernote').summernote({
                    height: 300,                 // set editor height
                    minHeight:300,             // set minimum heightof editor
                    maxHeight:null,             // set maximum heightof editor
                    focus: true ,                // set focus to editable areaafter initializing summernote
                    callbacks: {
                        onImageUpload: function(files) {
                            sendFile(files);
                        }
                    }
                });

                parent.document.getElementById("iframe").height=0;
                parent.document.getElementById("iframe").height=document.body.scrollHeight;
            });

            function sendFile(file) {

                alert("sdd");
                var filename = false;
                try{
                    filename=file['name'];
                }catch(e) {
                    filename=false;
                }
                if(!filename){
                    $(".note-alarm").remove();
                }

                data = new FormData();
                data.append("file", file);
                data.append("key",filename);
                console.log(data);
                $.ajax({
                    data: data,
                    type: "POST",
                    url: "<%=basePath%>news/insertFile",
                    cache: false,
                    contentType: false,
                    dataType:'json',
                    processData: false,
                    success: function(url) {
                        var path = url.path;
                        alert(path);
                        $("#summernote").summernote('insertImage', path); 
                    },
                    error:function() {
                        alert("upload failed");
                    }
                });
            }



        </script>



	</head>
    <body class="border20">
    <div id="summernote">Hello Summernote</div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <!--根据传过来的参数中是否有id,来判断是显示新增还是编辑-->
            <strong>编辑新闻</strong>
        </div>
        <div class="panel-body">
            <form action="<%=basePath%>news/insert" class="form-horizontal" name="myForm" method="post" >
                <div class="form-group">
                    <label class="col-md-2 control-label "><span class="text-danger">*</span>新闻标题</label>
                    <div class="col-md-8">
                        <input class="form-control" name="title">

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label word-spacing-25"><span class="text-danger">*</span>新闻类型</label>
                    <div class="col-md-2">
                        <%--<select id="channel" class="form-control"  name="channel" onchange="setChannel(this,subChannel,JSON.stringify('${requestScope.channelList}'))">--%>

                            <%--<c:forEach var="channel" items="${requestScope.channelList}">--%>
                                <%--<option value="${channel}">${channel.name}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>

                    </div>
                    <div class="col-md-2">
                        <select class="form-control"  name="subChannel">
                            <option value="0">选择分类</option>
                        </select>
                        <%--<span class="error" ng-show="myForm.industry.$invalid && myForm.industry.$dirty">--%>

                    </span>

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label word-spacing-25"><span class="text-danger">*</span>说 明</label>
                    <div class="col-md-8">

                        <!--富文本编辑器-->
                        <div type="text/html" style="margin:auto;height:300px;"
                             name="content" meta-umeditor meta-umeditor-placeholder="内容 " required="">
                            <textarea name="content"  class="form-control " style="height: 300px; font-size: 18px;"  maxlength="5000">

                            </textarea>

                            <input name="editor" value="${sessionScope.admin.adminName}" type="text" style="display: none;">"

                        </div>

                    </div>

                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label"><span class="text-danger">*</span>文章描述</label>
                    <div class="col-md-8">
                        <input class="form-control" type="text" name="description" >

                    </div>
                </div>

                <%----%>
                <div class="form-group">
                    <div class="col-md-8  col-md-offset-2">
                        <!-- 每个input都不为空且验证通过时且图片上传，最下方的提交按钮才变为可使用状态-->
                        <input type="submit" value="立即上线" class="btn btn-success">
                        </input>
                        <input  type="submit"  value="存为草稿" class="btn btn-success" >
                        </input>
                        <button type="button" class="btn btn-danger pull-right" onclick="alerts()" >取消
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    </body>
</html>