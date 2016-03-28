<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <script>
        function onClickHandle(id){
            location.href = "http://localhost:8080/example/board/" + id;
        }
    </script>

</head>
<body>
Hello! Welcome to Board.
<p/>
<c:forEach var="board" items="${boardList}">
    <h1><c:out value="${board.b_id}" /></h1><p/>
    <h1><c:out value="${board.b_name}" /></h1><p/>
    <h1><c:out value="${board.c_date}" /></h1><p/>
    <h1><c:out value="${board.u_date}" /></h1><p/>
    <h1><c:out value="${board.member_id}" /></h1><p/>
    <input type="button" value="${board.b_name} 게시물 보기" onclick="onClickHandle(${board.b_id})" >
</c:forEach>



</body>
</html>
