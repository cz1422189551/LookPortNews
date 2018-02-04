<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
        <meta charset="utf-8">
        <title>管理人员</title>
			<meta charset="UTF-8">
			<link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/public.css" />
			<link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/bootstrap.css" />
			<link rel="stylesheet" href="<%=basePath%>plugs/bootstrap/css/content.css" />
        <!-- jq -->
        <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>

        <script type="text/javascript" src="<%=basePath%>/plugs/bootstrap/js/bootstrap.min.js"></script>

        <!-- 分页插件 -->
        <link rel="stylesheet" href="<%=basePath%>plugs/bootstrap-table/bootstrap-table.min.css">
        <script type="text/javascript" src="<%=basePath%>plugs/bootstrap-table/bootstrap-table.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>plugs/bootstrap-table/bootstrap-table-locale-all.min.js"></script>

	</head>

    <body class="border20">

<div class="panel panel-default border20" ng-if="!vm.searchParams.companyId">
    <div class="form-horizontal">
        <div class="panel-body">
            <div class="row pd-bottom-2">
                <div class="col-md-4">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户账号</label>

                        <div class="col-md-8">
                            <input type="text" class=" form-control" name="age" placeholder="请输入账号">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label class="control-label col-md-4">用户密码</label>
                        <div class="col-md-8">
                            <input type="text" class=" form-control" name="name" placeholder="请输入密码">
                        </div>
                    </div>
                </div>

            </div>
            <div class="row pd-bottom-2">
                <div class="col-md-4">
                    <div class="form-group">
                        <label class="control-label col-md-4">创建时间</label>
                        <div class="col-md-8">
                            <input class="form-control" size="20" bs-datepicker autoclose="true"
                                   data-date-format="yyyy-MM-dd" data-date-type="number"
                                   ng-model="vm.searchParams.startAt" data-max-date="{{vm.searchParams.endAt}}">
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label class="control-label col-md-4 ">联系电话</label>
                        <div class="col-md-8">
                            <input class="form-control" size="20" bs-datepicker autoclose="true"
                                   data-date-format="yyyy-MM-dd" data-date-type="number"
                                   ng-model="vm.searchParams.endAt" data-min-date="{{vm.searchParams.startAt}}"
                                   data-max-date="today">
                        </div>
                    </div>
                </div>


            <div class="col pd-bottom-2">
                <div class="col-md-4 pull-right ">
                    <button class="btn btn-danger pull-right "><i class="fa fa-edit"></i>清空</button>
                     <button class="btn btn-info pull-right "><i class="fa fa-remove"></i>搜索</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
    <strong >管理员列表</strong>

    <a class="btn btn-sm  btn-danger pull-right ">
        <i class="fa fa-plus"></i>新增
    </a>
</div>
    <div class="panel-body table-responsive">
        <table class="table table-striped add-table-border">

        </table>

    </div>

</div>


    <script type="text/javascript">
        class BstpTable{
            constructor(obj) {
                this.obj=obj;
            }
            inint(searchArgs){
                //---先销毁表格 ---
                this.obj.bootstrapTable('destroy');
                //---初始化表格,动态从服务器加载数据---
                this.obj.bootstrapTable({
                    //【发出请求的基础信息】
                    url: '<%=basePath%>admin/adminList',
                    method: 'post',
                    contentType: "application/x-www-form-urlencoded",


                    //【查询设置】
                    /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                      设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
                    queryParamsType:'',
                    queryParams: function queryParams(params) {
                        var param = {
                            pageNumber: params.pageNumber,
                            pageSize: params.pageSize
                        };
                        for(var key in searchArgs){
                            param[key]=searchArgs[key]
                        }
                        return param;
                    },

                    //【其它设置】
                    locale:'zh-CN',//中文支持
                    pagination: true,//是否开启分页（*）
                    pageNumber:1,//初始化加载第一页，默认第一页
                    pageSize: 3,//每页的记录行数（*）
                    pageList: [3,4,5,10],//可供选择的每页的行数（*）
                    sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
                    showRefresh:true,//刷新按钮

                    //【样式设置】
                    height: 300,//table的高度
                    //按需求设置不同的样式：5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                    rowStyle: function (row, index) {
                        var style = "";
                        if (row.name=="小红") {style='success';}
                        return { classes: style }
                    },

                    //【设置列】
                    columns: [
                        {field: 'adminName',title: '账号'},
                        {field: 'password',title: '密码'},
                        {field: 'creatime',title: '创建时间'},
                        {field:'nickName', title:'昵称'},
                        {field:'email', title:'邮箱'},
                        {field:'gender', title:'性别'},
                        {field:'birthday',title:'出生年月'},
                        {field:'loginlast',title:'上次登陆'},
                        {field: 'tool',title: '操作', align: 'center',
                            formatter:function(value,row,index){
                                var element =
                                    "<a class='btn btn-xs btn-success'  data-id='"+row.id +"' title='编辑'><span class='glyphicon glyphicon-search'></span></a> "+
                                    "<a class='btn btn-xs btn-info'  data-id='"+row.id +"'><span class='glyphicon glyphicon-pencil'></span></a> "+
                                    "<a class='btn btn-xs btn-warning'  data-id='"+row.id +"'><span class='glyphicon glyphicon-remove'></span></a> ";
                                return element;
                            }
                        }
                    ]
                })
            }
        }

        var bstpTable=new BstpTable($("table"));
        bstpTable.inint({})

        $(".search").click(function(){
            var searchArgs={
                name:$("input[name='name']").val(),
                age:$("input[name='age']").val()
            }
            bstpTable.inint(searchArgs)
        })
    </script>

</body>
</html>