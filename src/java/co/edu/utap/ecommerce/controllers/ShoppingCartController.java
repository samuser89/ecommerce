/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utap.ecommerce.controllers;

import co.edu.utap.ecommerce.domain.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EliteBook
 */
@WebServlet(name = "ShoppingCartController", urlPatterns = {"/ShoppingCartController"})
public class ShoppingCartController extends HttpServlet {

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

            String id = request.getParameter("id");
            String action = request.getParameter("action");

            HttpSession session = request.getSession();
            List<Product> products = new ArrayList<>();
            List<Product> shoppingCart = new ArrayList<>();
            Product p = new Product();

            if (session.getAttribute("products") != null) {
                products = (List<Product>) session.getAttribute("products");
            }

            if (session.getAttribute("shoppingCart") != null) {
                shoppingCart = (List<Product>) session.getAttribute("shoppingCart");
            }

            for (Product item : products) {
                if (item.getCodigo().equals(id)) {
                    p = item;
                    break;
                }
            }

            boolean exist = false;

            for (Product item : shoppingCart) {
                if (item.getCodigo().equals(id)) {
                    exist = true;
                    int cantidadActual = p.getCantidad();

                    if (action.equals("add")) {
                        item.setCantidad(cantidadActual + 1);
                    } else if (action.equals("remove")) {

                        if (cantidadActual == 1) {
                            shoppingCart.remove(item);
                        } else {
                            item.setCantidad(cantidadActual - 1);
                        }
                    }

                    break;
                }
            }

            if (!exist) {
                p.setCantidad(1);
                shoppingCart.add(p);
            }

            session.setAttribute("shoppingCart", shoppingCart);

            request.setAttribute("message", "El proceso fue exitoso.");
            request.setAttribute("type", "success");

            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
        }catch(Exception ex){
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("type", "error");
            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
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