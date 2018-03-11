<%--
  Created by IntelliJ IDEA.
  User: 14221
  Date: 2018/2/3
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>WelCome</title>
    <!-- include libraries(jQuery, bootstrap) -->
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css" />
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <!-- include summernote css/js-->
    <link href="dist/summernote.css" rel="stylesheet">
    <script src="dist/summernote.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#summernote').summernote();
            $('#summernote').summernote({
                height: 300,                 // set editor height
                minHeight:null,             // set minimum heightof editor
                maxHeight:null,             // set maximum heightof editor
                focus: true                  // set focus to editable areaafter initializing summernote
            });
        });

    </script>
</head>
<body>
<h1>WelCome LookPort !</h1>

<div id="summernote" style="height: 300px;">Hello Summernote</div>

</body>

</html>
