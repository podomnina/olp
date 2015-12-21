<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-16"%>
<html>
<head>
  <title>Medicine clinic database</title>
  <link rel="stylesheet" href="index.css">

</head>
<body>
  <textarea name="input" id="input">Введите SQL запрос</textarea>
<script>
  function loadText(){
  var formData = new FormData(document.getElementsByName("input"));
  var xhr = new XMLHttpRequest();
  xhr.open("POST","/mainPage");
  xhr.send(formData);
  }
  </script>
    <button onclick="loadText()" name="button">Выполнить запрос</button>
    <textarea id="output"></textarea>




</body>
</html>
