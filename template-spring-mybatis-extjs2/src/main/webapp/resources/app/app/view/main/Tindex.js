/**
 * Created by James Choi on 2016-03-02.
 */


Ext.onReady(function(){
    Ext.create('Ext.panel.Panel',{
        title:'Hello ExtJS',
        html:'Welcome ExtJS!!',
        width:400,
        height:300,
        renderTo:document.body
    });
})