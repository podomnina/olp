<%--
  Created by IntelliJ IDEA.
  User: PolinaDomnina
  Date: 21.12.2015
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

<script>
    function makeRequest() {
        var xmlhttp;
        if (window.XMLHttpRequest) {// код для IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// код для IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                // xmlhttp.responseText;
            }
        }
        var text = document.getElementById("tf1");
        xmlhttp.open("POST", "mainPage", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xmlhttp.send(encodeURIComponent(text.value));
    }
</script>

<form name="textForm" onSubmit="makeRequest();return false;">
    <textarea id="tf1" name="text"></textarea>
    <input type="button" id="button1" onClick="makeRequest()" value="Update"/>
</form>

</body>
</html>
