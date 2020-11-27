<%-- 
    Document   : CreateProduct
    Created on : 11/11/2020, 07:05:41 PM
    Author     : Samsung
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.utap.ecommerce.domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            
        <div class="container">
            <form method="post" action="ProductController">
                <%    List<Product> products = new ArrayList();
        
        if(session.getAttribute("products") !=null){
            products = (List<Product>)session.getAttribute("products");
        }
                    %>
                    
                    <h1> Productos ( <%=products.size()%> ) </h1><hr>
                <div class="form-row">
                <br>
                <div class="col-md-3">
                    <label>Codigo: </label>
                    <input type="text" placeholder="Ingrese el código" id="txtCodigo" name="txtCodigo"/>
                </div>
                
                <div class="col-md-3">
                    <label>Nombre: </label>
                    <input type="text" placeholder="Ingrese el nombre" id="txtNombre" name="txtNombre"/>
                </div>    
                
                <div class="col-md-3">
                    <label>Cantidad: </label>
                    <input type="number" placeholder="Ingrese la cantidad" id="txtCantidad" name="txtCantidad"/>
                </div>
                
                <div class="col-md-3">
                    <label>Precio: </label>
                    <input type="number" placeholder="Ingrese el precio" id="txtPrecio" name="txtPrecio"/>
                </div>
            </div>
            
            <div class="form-row">
                <div class="col-md-3">
                    <br>
                    <label>Genero: </label>
                    <select class="form-control" id="ddlGenero" name="ddlGenero">
                        <option value="-1">--Seleccione--</option>
                        <option value="1">Hombre </option>
                        <option value="2">Mujer</option>
                    </select>
                </div>
                
                <div class="col-md-3">
                    <br>
                    <label>Categoria: </label>
                    <select class="form-control" id="ddlCategoria" name="ddlCategoria">
                        <option value="-1">--Seleccione--</option>
                        <option value="1">Camisetas</option>
                        <option value="2">Correas</option>
                        <option value="3">Calzado de Dama</option>
                        <option value="4">Accesorios</option>
                        
                    </select>
                </div>

            
                <div class="col-md-6">
                    <br>
                    <label>Imagen:</label>
                    <input type="text" class="form-control" id="txtImagen" name="txtImagen" placeholder="Ingrese la Url"/>
                </div>   
            </div>
            <div class="form-row">
                <br>
                <div class="col-md-12">
                    <br>
                    <input class="btn-outline-success btn" type="submit" value="Guardar" id="btnGuardar" name="btnGuardar" /input> 
                    <a class="btn-outline-primary btn" href="ListProduct.jsp">Detalle</a>
                    <a class="btn-outline-danger btn" href="ShoppingCart.jsp">Carrito de Compra</a>
                </div>
                
            </div>
                
                <%                 
                    if (request.getAttribute("preview") !=null){
                    %>
                    <label class="badge badge-success">Resumen: <%= request.getAttribute("preview")%> </label><br>
                    <br>
                <%
                    }
                %>
            </form>
        </div>
            
    </body>
</html>
