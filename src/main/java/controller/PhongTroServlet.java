package controller;

import dao.KhuTroDAO;
import dao.PhongTroDAO;
import impl.KhuTroImpl;
import impl.PhongTroImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.KhuTro;
import model.PhongTro;
import jakarta.servlet.annotation.MultipartConfig;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


@MultipartConfig
public class PhongTroServlet extends HttpServlet {
    private final KhuTroDAO khuTroDAO = new KhuTroImpl();
    private final PhongTroDAO phongTroDAO = new PhongTroImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "detail":
                try {
                    detail(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    search(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "byKhuTro":
                try {
                    byKhuTro(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    editForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "add":
                try {
                    addForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                try {
                    list(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void addForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("danhSachKhuTro", khuTroDAO.findAll());
        request.getRequestDispatcher("themPhongTro.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("danhSachKhuTro", khuTroDAO.findAll());
        request.setAttribute("danhSachPhongTro",phongTroDAO.findAll());
        request.getRequestDispatcher("danhSachPhongTro.jsp").forward(request,response);
    }
    private void detail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maPhong = request.getParameter("maPhong");
        request.setAttribute("danhSachKhuTro", khuTroDAO.findAll());
        request.setAttribute("phongTro", phongTroDAO.findById(maPhong));
        request.getRequestDispatcher("chiTietPhongTro.jsp").forward(request,response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String tenPhong = request.getParameter("tenPhong");
        request.setAttribute("danhSachPhongTro",phongTroDAO.findByName(tenPhong));
        request.getRequestDispatcher("danhSachPhongTro.jsp").forward(request,response);
    }
    private void byKhuTro(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String maKhu = request.getParameter("maKhu");
        request.setAttribute("danhSachPhongTro", phongTroDAO.findByKhuTro(maKhu));
        request.setAttribute("danhSachKhuTro", khuTroDAO.findAll());
        request.getRequestDispatcher("danhSachPhongTro.jsp").forward(request,response);
    }
    private void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String maPhong = request.getParameter("maPhong");
        request.setAttribute("danhSachKhuTro", khuTroDAO.findAll());
        request.setAttribute("phongTro", phongTroDAO.findById(maPhong));
        request.getRequestDispatcher("formPhongTro.jsp").forward(request,response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String maPhong = request.getParameter("maPhong");
        String tenPhong = request.getParameter("tenPhong");
        double giaThue = Double.parseDouble(request.getParameter("giaThue"));
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        Part filePart = request.getPart("hinhAnh");
        String hinhAnh = null;
        String fileName = filePart.getSubmittedFileName();
        if (fileName!= null && !fileName.isEmpty()){
            fileName = System.currentTimeMillis() + "_" + fileName;
            String url = getServletContext().getRealPath("") + "images";
            File uploadDir = new File(url);
            uploadDir.mkdir();
            filePart.write(url + File.separator + fileName);
             hinhAnh = "images/" + fileName;
            System.out.println("PATH = " + getServletContext().getRealPath(""));
        }

        String maKhu = request.getParameter("maKhu");
        KhuTro khuTro = khuTroDAO.findById(maKhu);
        PhongTro phongTro = new PhongTro(maPhong,tenPhong,giaThue,dienTich,hinhAnh,khuTro);
        phongTroDAO.update(phongTro);
        response.sendRedirect("phongtro");
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String maPhong = request.getParameter("maPhong");
        String tenPhong = request.getParameter("tenPhong");
        double giaThue = Double.parseDouble(request.getParameter("giaThue"));
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        Part filePart = request.getPart("hinhAnh");
        String hinhAnh = null;
        String fileName = filePart.getSubmittedFileName();
        if (fileName!= null && !fileName.isEmpty()){
            fileName = System.currentTimeMillis() + "_" + fileName;
            String url = getServletContext().getRealPath("") + "images";
            File uploadDir = new File(url);
            uploadDir.mkdir();
            filePart.write(url + File.separator + fileName);
            hinhAnh = "images/" + fileName;
            System.out.println("PATH = " + getServletContext().getRealPath(""));
        }

        String maKhu = request.getParameter("maKhu");
        KhuTro khuTro = khuTroDAO.findById(maKhu);
        PhongTro phongTro = new PhongTro(maPhong,tenPhong,giaThue,dienTich,hinhAnh,khuTro);
        phongTroDAO.insert(phongTro);
        response.sendRedirect("phongtro");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)){
            try {
                update(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if ("insert".equals(action)){
            try {
                insert(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maPhong = request.getParameter("maPhong");
        phongTroDAO.delete(maPhong);
        response.sendRedirect("phongtro");
    }
}
