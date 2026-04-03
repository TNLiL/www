<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CHINH SUA PHONG TRO</title>
</head>
<body>
<form action="phongtro" method="post" enctype="multipart/form-data">
    <input type="hidden" name="action" value="update">
    <p>
        <input type="text" name="maPhong" value="${phongTro.maPhong}" readonly>
    </p>
    <p>
        <input type="text" name="tenPhong" value="${phongTro.tenPhong}" required>
    </p>
    <p>
        <input type="number" name="giaThue" value="${phongTro.giaThue}" required>
    </p>
    <p>
        <input type="number" name="dienTich" value="${phongTro.dienTich}" required>
    </p>
    <p>
        <input type="file" name="hinhAnh" >
        <img src="${phongTro.hinhAnh}">
    </p>
    <p>
        <select name="maKhu">
            <c:forEach items="${danhSachKhuTro}" var="k">
                <option value="${k.maKhu}" ${phongTro.khuTro.maKhu} == k.maKhu ? 'selected' : ''> ${k.tenKhu}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit">LUU</button>
</form>
</body>
<a href="phongtro">QUAY LAI</a>
</html>
