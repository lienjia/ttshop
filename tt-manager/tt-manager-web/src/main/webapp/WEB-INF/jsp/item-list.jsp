<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="table"></table>
<script>
    var toolbar=[{
        iconCls:'icon-add',
        text:'新增',
        handler:function(){
//            在网页控制台输出
            console.log('add');
        }
    },{
        iconCls:'icon-remove',
        text:'删除',
        handler:function(){
//            获取选中的行
            var selectRows = $('#table').datagrid('getSelections');
            if(selectRows.length==0){
                $.messager.alert('提示','未选中任何记录','warning');
                return;
            }
            $.messager.confirm('确认','确认要删除吗?',function(r){
                if(r){
                    var ids = [];
                    for(var i=0;i<selectRows.length;i++){
                        ids.push(selectRows[i].id);
                    }
//                    ajax提交数组给后台
                    $.post(
                     'items/batch',
                        {'ids[]':ids},
                        function(data){
                         $('#table').datagrid('reload')
                        },
                        'json'
                    )
                }
            })
        }
    },{
        iconCls:'icon-edit',
        text:'编辑',
        handler:function(){
            console.log('edit');
        }
    },{
        iconCls:'icon-up',
        text:'上架',
        handler:function(){
            console.log('up');
        }
    },{
        iconCls:'icon-down',
        text:'下架',
        handler:function(){
            console.log('down');
        }
    }

    ];
    $("#table").datagrid({
        pageSize:10,
        pageList:[10,15,20,25,30,40,50],
        toolbar:toolbar,
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'商品编号',width:100},
            {field:'title',title:'商品名称',width:100},
            {field:'sellPoint',title:'卖点',width:100},
            {field:'catName',title:'类别',width:100},
            {field:'status',title:'状态',formatter:function(value,row,index){
                switch (value){
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            {field:'created',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('dddd,MMMM Do YYYY, h:mm:ss a');
            }}
        ]]
    });
</script>