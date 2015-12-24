﻿﻿<%--
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
  function makeRequest()
  {
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// код для IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
    }
    else
    {// код для IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function takeResponse()
    {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
        document.getElementById("tf1").value = xmlhttp.responseText;
        var responseTable = makeTable(2,2);
        document.body.appendChild(responseTable);




        //alert(xmlhttp.responseText);
      }
    }

    xmlhttp.open("POST","mainPage",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    xmlhttp.send('tf1='+encodeURIComponent(document.getElementById("tf1").value));
  }

  function makeTable(cols, rows) {
    var table = document.createElement("table"), tr,td;
    for(x = 0; x < rows; x++) {
      tr = document.createElement("tr");
      for(y = 0; y < cols; y++){
        td = document.createElement("td");
        td.innerHTML = x;
        tr.appendChild(td);
      }
      table.appendChild(tr);
    }
    return table;
  }
</script>

<form name="textForm" onSubmit="makeRequest();return false;" >
  <textarea id="tf1" name="text"></textarea>
  <input type="button" id="button1" onClick="makeRequest()" value="Update"/>
</form>

</body>
</html>