<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Medicine clinic database</title>
</head>
<body>
  <select name="select">
    <option value="branch">Branch</option>
    <option value="doctor">Doctor</option>
    <option value="reception">Reception</option>
    <option value="service">Service</option>
  </select>

  <h3>Все пользователи:</h3>
  <ol>
    <c:forEach items="${list}" var="list">
      <li>
          ${list}
      </li>
    </c:forEach>
  </ol>

</body>
</html>