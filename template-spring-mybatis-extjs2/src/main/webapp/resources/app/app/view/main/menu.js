/**
 * Created by James Choi on 2016-02-23.
 */
Ext.define("App.view.main.menu", {
    extend: "Ext.tree.Panel",
    title: 'Simple Tree',
    alias: 'widget.menubar',
    width: 150,
    height: 150,
    root: {
        text: 'Root',
        expanded: true,
        children: [
            {
                text: 'menu 1',
                leaf: true
            },
            {
                text: 'menu 2',
                leaf: true
            },
            {
                text: 'menu 3',
                expanded: true,
                children: [
                    {
                        text: 'Grandchild',
                        leaf: true
                    }
                ]
            }
        ]
    }
});



Ext.OnReady(function(){
    Ext.create('Ext.panel.Panel', {
        renderTo: Ext.getBody(),
        html: '패널입니다',
        bodyPadding: 5,
        width: 600,
        height: 200
    });

    Ext.create('Ext.panel.Panel', {
        title: 'Panel 입니다.',
        renderTo: Ext.getBody(),
        bodyPadding: 5,
        width: 600,
        height: 200,
        items: [
            {
                xtype: 'panel',
                html: '패널'
            }, {
                xtype: 'panel',
                html: '패널1'
            }
        ]
    });

    Ext.create('Ext.panel.Panel', {
        title: 'panel 입니다',
        renderTo: Ext.getBody(),
        bodyPadding: 5,
        width: 600,
        height: 200,
        items: [
            {
                xtype: 'datefield',
                fieldLabel: '시작일'
            }, {
                xtype: 'datefield',
                fieldLabel: '종료일'
            }
        ]
    });
})




function getDatePicker () {
    return applySizing('datePicker', {
        xtype: 'panel',
        border: false,
        items: {
            xtype: 'datepicker'
        }
    });
}