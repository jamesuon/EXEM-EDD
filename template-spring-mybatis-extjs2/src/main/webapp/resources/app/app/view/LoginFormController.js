Ext.define('App.view.LoginFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.loginform',

    onLoginClick: function (comp, e, eOpts) {
        var usernameField = this.lookupReference('username');
        var passwordField = this.lookupReference('password');

        console.log(usernameField.getValue());
        console.log(passwordField.getValue());

        Ext.Ajax.request({
            url: "/example/login.json",
            method: "GET",
            params: {
                "username": this.lookupReference('username').getValue(),
                "password": this.lookupReference('password').getValue()
            },
            // HTTP 프로토콜 상에서 200
            success: function (result, request) {
                var jsonData = Ext.util.JSON.decode(result.responseText);

                if (jsonData.success) {
                    Ext.Msg.alert("요청처리 성공 Username : ", jsonData.map.username);
                } else {
                    Ext.Msg.alert("요청처리 실패");
                }
            },
            // HTTP 프로토콜 상에서 에러가 발생한 경우
            failure: function (result, request) {
                Ext.Msg.alert("Failed", result.responseText);
            }

        });
    }
});
