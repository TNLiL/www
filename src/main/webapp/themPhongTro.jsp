<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/03/2026
  Time: 6:37 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>THEM PHONG TRO</title>
</head>
<body>
<form action="phongtro" method="post" enctype="multipart/form-data">
    <input type="hidden" name="action" value="insert">
    <p>
        <input type="text" name="maPhong" >
    </p>
    <p>
        <input type="text" name="tenPhong" required>
    </p>
    <p>
        <input type="number" name="giaThue" required>
    </p>
    <p>
        <input type="number" name="dienTich"  required>
    </p>
    <p>
        <input type="file" name="hinhAnh" >
    </p>
    <p>
        <select name="maKhu">
            <c:forEach items="${danhSachKhuTro}" var="k">
                <option value="${k.maKhu}"> ${k.tenKhu}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit">LUU</button>
</form>
</body>
<a href="phongtro">QUAY LAI</a>
</html>
