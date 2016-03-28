/**
 * Created by James Choi on 2016-02-25.
 */


Ext.define("App.view.main.grid", {
    extend: "Ext.grid.Panel",
//  store: userStore,
    width: 400,
    height: 200,
    title: 'Application Users',
    alias: 'widget.grid',
    columns: [
        {
            text: 'Name',
            width: 100,
            sortable: false,
            hideable: false,
            dataIndex: 'name'
        },
        {
            text: 'Email Address',
            width: 150,
            dataIndex: 'email',
            hidden: true
        },
        {
            text: 'Phone Number',
            flex: 1,
            dataIndex: 'phone'
        }
    ]
});