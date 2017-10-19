
var ttshop = {

    //响应导航树上的动作
    registerMenuEvent: function () {

        $('#menu .easyui-tree').tree({
            onClick: function (node) {
                var href = node.attributes.href;
                var text=node.text;
               if($("#tab").tabs('exists',text)){
                    $("#tab").tabs('select',text)
               }else{
                   $("#tab").tabs('add',{
                       title:text,
                       href:href,
                       // 该选项卡可以被关闭
                       closable:true
                   })
               }
            }
        });
    },

};



