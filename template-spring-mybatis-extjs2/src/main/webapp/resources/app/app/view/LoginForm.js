Ext.define("App.view.LoginForm", {
    extend: "Ext.panel.Panel",

    requires: [
        "App.view.LoginFormController",
        "App.view.LoginFormModel",
        "App.view.main.menu"
    ],

    title: '로그인',

    bodyPadding: 70,

    controller: "loginform",

    viewModel: {
        type: "loginform"
    },

    defaultType: 'textfield',

    layout:'border',
    defaults: {
        collapsible: true,
        split: true,
        bodyStyle: 'padding:15px'
    },

    items : [ {
        region : 'north',
        xtype : 'container',
        html : '상단영역',
        height : 100,
        style : {
            borderColor : '#000000',
            borderStyle : 'solid',
            borderWidth : '1px'
        }
    }, {
        region : 'center',
        xtype : 'grid',
        title : '게시판 프로그램 영역',
        style : {
            borderColor : '#000000',
            borderStyle : 'solid',
            borderWidth : '1px'
        }
    }, {
        region : 'west',
        xtype : 'menubar',
        html : '메뉴 영역',
        width : 200,
        style : {
            borderColor : '#000000',
            borderStyle : 'solid',
            borderWidth : '1px'
        }
    } ],

    buttons: [
        {
            text: '로그인',
            formBind: true,
            listeners: {
                click: 'onLoginClick'
            }
        }
    ]
});





// **************************  여기 아래부터 테스트 페이지 **********************  //


/*
Ext.onReady(function(){
    Ext.create('Ext.panel.Panel',{
        title:'Hello ExtJS',
        html:'Welcome ExtJS!!',
        width:400,
        height:300,
        renderTo:document.body
    });
})*/


/*
Ext.define("App.view.LoginForm", {
    extend: "Ext.panel.Panel",

*/


/*
Ext.define('Logger', {
    singleton:true,
    logger:function(input){
        document.write(input + "<br>");
    }
});
Logger.logger("안녕하세요");
Logger.logger("반갑습니다");

*/


/*

Ext.define("App.view.LoginForm", {
        extend: "Ext.panel.Panel",

        title:'Hello ExtJS',
        html:'Welcome ExtJS!!',
        width:900,
        height:300,
        renderTo:document.body

});

*/

