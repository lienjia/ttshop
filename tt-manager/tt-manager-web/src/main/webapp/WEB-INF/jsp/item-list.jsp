<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="table"></table>
<script>
    function searchForm(){
        $("#table").datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        })
    }
    function add(){
        ttshop.addTab('新增商品','item-add');
    }
    function edit(){
        console.log('edit');
    }
    function remove(){
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
    function dowm(){
        console.log('down');
    }
    function up(){
        var selectRows = $('#table').datagrid('getSelections');
        if(selectRows.length==0){
            $.messager.alert('提示','未选中任何记录','warning');
            return;
        }
        $.messager.confirm('确认','确认要上架吗?',function(r){
            if(r){
                var ids = [];
                for(var i=0;i<selectRows.length;i++){
                    ids.push(selectRows[i].id);
                }
//                    ajax提交数组给后台
                $.post(
                    'items/up',
                    {'ids[]':ids},
                    function(data){
                        $('#table').datagrid('reload')
                    },
                    'json'
                )
            }
        })
    }

    $("#table").datagrid({
        multiSort:true,
        pageSize:10,
        pageList:[10,15,20,25,30,40,50],
        toolbar:'#toolbar',
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'商品编号',width:100,sortable:true},
            {field:'title',title:'商品名称',width:100,sortable:true},
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
            {field:'price',title:'商品价格',width:100},
            {field:'created',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('dddd,MMMM Do YYYY, h:mm:ss a');
            }},
            {field:'updated',title:'更新时间',formatter:function(value,row,index){
                return moment(value).format('dddd,MMMM Do YYYY, h:mm:ss a');
            }}
        ]]
    });
</script>