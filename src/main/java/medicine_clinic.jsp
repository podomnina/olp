<%@ page import="Database.DatabaseHelper" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>
        ����������� �������
    </title>
</head>

<body>
<h1>
    <%
        DatabaseHelper db=new DatabaseHelper();
        db.UsingDatabase();
        ArrayList<String> list = db.Request();
        //String name = request.getParameter("name");
        if (list == null) {
    %>
    ������ � ���������� !
    <%            } else {
    %>
    �������: <%= list.get(0)%>
    <%
        }
        db.CloseDatabase();
    %>
</h1>
</body>
</html>