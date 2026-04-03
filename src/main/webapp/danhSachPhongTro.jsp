<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DANH SACH PHONG TRO</title>
</head>
<body>
<form action="phongtro" method="get">
    <input type="hidden" name="action" value="byKhuTro">
    <select name="maKhu">
    <option>CHON KHU TRO</option>
<c:forEach var="k" items="${danhSachKhuTro}">
    <option value="${k.maKhu}">
        ${k.tenKhu}
    </option>
</c:forEach>
    </select>
    <button type="submit">LOC</button>
</form>
<button>
    <a href="phongtro?action=add">THEM PHONG TRO</a>
</button>
<form action="phongtro" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="tenPhong" placeholder="NHAP TEN PHONG TRO CAN TIM" value="${tenPhong}">
    <button type="submit">TIM KIEM</button>
</form>
<a href="phongtro">XEM TAT CA</a>
<table>
    <tr>
       <th>
          MA PHONG
       </th>
        <th>
TEN PHONG
        </th>
        <th>
GIA THUE
        </th>
        <th>
DIEN TICH


        </th>
        <th>
HINH ANH
        </th>
        <th>
KHU TRO
        </th>

    </tr>
<c:forEach var="p" items="${danhSachPhongTro}">
    <tr>
        <td>
                ${p.maPhong}
        </td>
        <td>
                ${p.tenPhong}
        </td>
        <td>
                ${p.giaThue}
        </td>
        <td>
                ${p.dienTich}
        </td>
        <td >
                <img src="${p.hinhAnh}" style="width: 150px">
        </td>
        <td>
                ${p.khuTro.tenKhu}
        </td>
        <td>
            <a href="phongtro?action=detail&maPhong=${p.maPhong}">CHI TIET</a>
            <a href="phongtro?action=update&maPhong=${p.maPhong}">SUA PHONG</a>
            <a href="phongtro?action=delete&maPhong=${p.maPhong}">XOA PHONG</a>
        </td>

    </tr>
</c:forEach>
</table>
</body>
</html>
