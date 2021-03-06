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
          var response = JSON.parse(xmlhttp.responseText);
          if(document.getElementById("table") != null){
              document.body.removeChild(document.getElementById("table"));
          }
          var responseTable = makeTable(response);
          document.body.appendChild(responseTable);
      }
    }

    xmlhttp.open("POST","mainPage",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send('tf1='+encodeURIComponent(document.getElementById("tf1").value));
  }

  function makeTable(responseObj) {
      var table = document.createElement("table"), tr, td;
      table.setAttribute("id", "table");
      tr = document.createElement("tr");
      for (var i in responseObj.colNames) {
          td = document.createElement("td");
          td.innerHTML = responseObj.colNames[i];
          tr.appendChild(td);
      }
      table.appendChild(tr);

      for(var i in responseObj.dataArray) {
          tr = document.createElement("tr");
          for(var x in responseObj.dataArray[i]){
              td = document.createElement("td");
              td.innerHTML = responseObj.dataArray[i][x];
              tr.appendChild(td);
          }
          table.appendChild(tr);
      }

      return table;
  }
</script>

<form name="textForm" onSubmit="makeRequest();return false;" >
  <textarea id="tf1" name="text" rows="10" cols="70"></textarea>
  <input type="button" id="button1" onClick="makeRequest()" value="Update"/>
</form>

</body>
</html>