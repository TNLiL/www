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
    <title>CHI TIET PHONG TRO</title>
</head>
<body>
<p><strong>MA PHONG</strong>${phongTro.maPhong}</p>
<p><strong>TEN PHONG</strong>${phongTro.tenPhong}</p>
<p><strong>GIA THUE</strong>${phongTro.giaThue}</p>
<p><strong>DIEN TICH</strong>${phongTro.dienTich}</p>
<p><strong>HINH ANH</strong><img src="${phongTro.hinhAnh}"></p>
<p><strong>MA KHU</strong>${phongTro.khuTro.maKhu}</p>
<p><strong>TEN KHU</strong>${phongTro.khuTro.tenKhu}</p>
<p><strong>DIA CHI</strong>${phongTro.khuTro.diaChi}</p>
<p><strong>CHU SO HUU</strong>${phongTro.khuTro.chuSoHuu}</p>
</body>
<a href="phongtro">QUAY LAI</a>
</html>
