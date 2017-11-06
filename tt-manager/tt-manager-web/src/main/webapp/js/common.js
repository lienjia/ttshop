
var ttshop = {

    //响应导航树上的动作
    registerMenuEvent: function () {
        var _this=this;
        $('#menu .easyui-tree').tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var text = node.text;
                _this.addTab(text,href);
            }
        });
    },
    addTab:function(text,href){
        if($("#tab").tabs('exists',text)){
            $("#tab").tabs('select',text)
        }else{
            $("#tab").tabs('add',{
                title:text,
                href:href,
                // 该选项卡可以被关闭
                closable:true
            });
        }
    }
};



