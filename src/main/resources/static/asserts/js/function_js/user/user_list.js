$(function () {
    $("#search_user").click(function () {
        $("#userList").bootstrapTable('refresh');
    });
    $("#updateUser").submit(function(){
        if($("[name='password2']").val()!=$("[name='password']").val()){
            alert("两次密码不一致，请重新输入！");
            $("[name='password2']").select();
            return false;
        }
    })
})

$("#userList").bootstrapTable({ // 对应table标签的id
    method:'post',
    url: basePath + "/user/getUserlist", // 获取表格数据的url
    cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
    striped: true,  //表格显示条纹，默认为false
    pageSize: 10, // 页面数据条数
    pagination: true, // 在表格底部显示分页组件，默认false
    pageNumber: 1, // 首页页码
    pageList: [5,10,15], // 设置页面可以显示的数据条数
    sidePagination: 'server', // 设置为服务器端分页
    height: 460,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
    uniqueId: "id",         //每一行的唯一标识，一般为主键列
    toolbar : "#toolbar",// 指明自定义的toolbar
    queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
        return {
            pageSize: params.limit, // 每页要显示的数据条数
            offset: params.offset, // 每页显示数据的开始行号
            sort: params.sort, // 要排序的字段
            order: params.order, // 排序规则
            queryModel: {
                username:$("#uname").val(),
                id:$("#uid").val()
            }
        }
    },
    sortName: 'id', // 要排序的字段
    sortOrder: 'asc', // 排序规则
    columns: [
        {
            checkbox: true, // 显示一个勾选框
            align: 'center' // 居中显示
        }, {
            field: 'id', // 返回json数据中的name
            title: '编号', // 表格表头显示文字
            align: 'center', // 左右居中
            sortable : true
        }, {
            field: 'username',
            title: '用户名',
            align: 'center',
            sortable : true
        }, {
            field: 'password',
            title: '密码',
            align: 'center',
        }, {
            title: "操作",
            align: 'center',
            width: 160, // 定义列的宽度，单位为像素px
            formatter: function (value, row, index) {
                return '<button class="btn btn-primary btn-sm" onclick="del(\'' + row.stdId + '\')">删除</button>';
            }
        }
    ],
    onLoadSuccess: function(){  //加载成功时执行
        console.info("加载成功");
    },
    onLoadError: function(){  //加载失败时执行
        console.info("加载数据失败");
    }
})
