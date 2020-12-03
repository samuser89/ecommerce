/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utap.ecommerce.service;

import co.edu.utap.ecommerce.domain.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EliteBook
 */
public class ProductService {

    public List<Product> GetProducts() throws Exception {

        try {

            List<Product> products = new ArrayList<>();
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call ConsultarProducto() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                //asignando
                p.setCodigo(rs.getString("Codigo"));
                p.setNombre(rs.getString("Nombre"));
                p.setCantidad(rs.getInt("Cantidad"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setGenero(rs.getInt("Genero"));
                p.setCategoria(rs.getInt("Categoria"));
                p.setImagen(rs.getString("Imagen"));
                
                products.add(p);
            }

            return products;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void CreateProduct(String nombre,
            String imagen,
            int cantidad,
            double precio,
            int categoria,
            int genero) throws Exception {

        try {

            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call CrearProducto(?,?,?,?,?,?) }");

            ps.setString(1, nombre);
            ps.setString(2, imagen);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            ps.setInt(5, genero);
            ps.setInt(6, categoria);

            ps.execute();

        } catch (Exception ex) {
            throw ex;
        }
    }
}

