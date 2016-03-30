<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html manifest="">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>App</title>

    
    <script type="text/javascript">
        var Ext = Ext || {}; // Ext namespace won't be defined yet...

        // This function is called by the Microloader after it has performed basic
        // device detection. The results are provided in the "tags" object. You can
        // use these tags here or even add custom tags. These can be used by platform
        // filters in your manifest or by platformConfig expressions in your app.
        //
        Ext.beforeLoad = function (tags) {
            var s = location.search,  // the query string (ex "?foo=1&bar")
                profile;

            // For testing look for "?classic" or "?modern" in the URL to override
            // device detection default.
            //
            if (s.match(/\bclassic\b/)) {
                profile = 'classic';
            }
            else if (s.match(/\bmodern\b/)) {
                profile = 'modern';
            }
            else {
                profile = tags.desktop ? 'classic' : 'modern';
                //profile = tags.phone ? 'modern' : 'classic';
            }

            Ext.manifest = profile; // this name must match a build profile name

            // This function is called once the manifest is available but before
            // any data is pulled from it.
            //
            //return function (manifest) {
                // peek at / modify the manifest object
            //};
        };
    </script>
    
    
    <!-- The line below must be kept intact for Sencha Cmd to build your application -->
    <script id="microloader" data-app="e627b317-056b-48aa-974c-44faaebb0577" type="text/javascript" src="bootstrap.js"></script>

    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script>
        function onClickHandle(){
            location.href = "http://localhost:8080/example/board"
        }

        /*function update(id) {
            var updateForm = $("form[name=updateForm]").serialize();

            $.ajax({
                type : 'post',
                url : 'edit/'+id,
                data : updateForm,
                headers: {
                    "Content-Type": "application/json"},
                /!*dataType : 'json',*!/
                error: function(xhr, status, error){
                    alert(error);
                },
                success : function(json){
                    alert(json)
                }
            });
        }*/

    </script>

</head>
<body>
Hello! Welcome to Board.
<p/>
    <h1><c:out value="${board.b_id}" /></h1><p/>
    <h1><c:out value="${board.b_name}" /></h1><p/>
    <h1><c:out value="${board.c_date}" /></h1><p/>
    <h1><c:out value="${board.u_date}" /></h1><p/>
    <h1><c:out value="${board.member_id}" /></h1><p/>

<%--<input type="button" value="목록" onclick="onClickHandle()" >--%>

<form name="updateForm" method="post" action="edit">
    <%--<input name="_method" type="hidden" value="PUT">--%>
    <input type="number" value="${board.b_id}" name="b_id" />
    <input type="text" value="${board.b_name}" name="b_name" />
    <input type="text" value="<fmt:formatDate value="${board.c_date}" pattern="YYYY-MM-DD HH:mm:ss" />" name="c_date" />
    <input type="number" value="${board.member_id}" name="member_id" />
    <input type ="submit" value="완료" />
</form>
</body>
</html>
