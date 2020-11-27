<%-- 
    Document   : ListProduct
    Created on : 12/11/2020, 08:44:25 PM
    Author     : Samsung
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.utap.ecommerce.domain.Product"%>
<%@page import="co.edu.utap.ecommerce.domain.Product"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            %>
    <head>
        <style type="text/css">
           .dollars:before{ content: '$'; }
       </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
              crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" 
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" 
                integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" 
        crossorigin="anonymous"></script>
        
    </head>
    <body>
        
        <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="CreateProduct.jsp">Inicio</a></li>
    <li class="breadcrumb-item"><a href="ListProduct.jsp">Detalle</a></li>
    <li class="breadcrumb-item active" aria-current="page"><a href="ShoppingCart.jsp">Carrito de Compra</a></li>
  </ol>
</nav>
        <%    List<Product> products = new ArrayList();
        
        if(session.getAttribute("products") !=null){
            products = (List<Product>)session.getAttribute("products");
        }
                    %>
            <div class="container">
                <span class="badge badge-light">
                <h1> Productos ( <%=products.size()%> ) </h1>
               </span>
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>Imagen</th>
                            
                        </tr>
                      </thead>  
                        <%
                        for (Product item: products){
                        %>
                        <tr>
                        <td><%=item.getCodigo()%></td>
                        <td><%=item.getNombre()%></td>
                        <td><%=item.getCantidad()%></td>
                        <td class="dollars"><%= df.format(item.getPrecio())%></td>
                        <td><img src=<%= item.getImagen()%> height="50px" width="50px" /></td>
                        </tr>
                        <%
                            }
                        %>
                        
                    </table>
            <a class="btn-outline-primary btn" href="CreateProduct.jsp">Volver</a>
            
            </div>
            
    </body>
</html>
