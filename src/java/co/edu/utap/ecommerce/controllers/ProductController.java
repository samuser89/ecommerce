/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utap.ecommerce.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import co.edu.utap.ecommerce.domain.Product;
import co.edu.utap.ecommerce.service.ProductService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EliteBook
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String codigo = request.getParameter("txtCodigo");
            String nombre = request.getParameter("txtNombre");
            String imagen = request.getParameter("txtImagen");
            int cantidad = Integer.valueOf(request.getParameter("txtCantidad"));
            double precio = Double.valueOf(request.getParameter("txtPrecio"));
            int genero = Integer.valueOf(request.getParameter("ddlGenero"));
            int categoria = Integer.valueOf(request.getParameter("ddlCategoria"));

            //database
            ProductService productService = new ProductService();
            productService.CreateProduct(nombre, imagen, cantidad, precio, categoria, genero);

            HttpSession session = request.getSession();

            Product p = new Product();
        //Product p = new Product(codigo, nombre, imagen, cantidad, precio, genero, categoria);

            //asignando
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setCantidad(cantidad);
            p.setPrecio(precio);
            p.setGenero(genero);
            p.setCategoria(categoria);
            p.setImagen(imagen);

            List<Product> products = new ArrayList<>();

            if (session.getAttribute("products") != null) {
                products = (List<Product>) session.getAttribute("products");
            }

            products.add(p);

            session.setAttribute("products", products);
            request.setAttribute("preview", codigo + "/" + nombre + "/" + cantidad + "/" + precio);

            request.getRequestDispatcher("CreateProduct.jsp").forward(request, response);

        } catch (Exception ex) {
            request.getRequestDispatcher("CreateProduct.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}