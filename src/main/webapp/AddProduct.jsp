<%-- 
    Document   : newjsp1
    Created on : Jan 19, 2017, 2:06:20 PM
    Author     : AAA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

       
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <jsp:include page="AdminNav.jsp"></jsp:include>
        <div class="row">
            <form class="col s12" action="ProductController" enctype="multipart/form-data" method="post">
                <div class="row">
                    <div class="input-field col s12">
                        <input class="validate" id="product_name"  type="text" name="product_name">
                        <label for="product_name">Product Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input class="validate" id="price"  type="number" name="price">
                        <label for="price">Price</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <textarea class="materialize-textarea"  id="description" type="text"  name="description"></textarea>
                        <label for="description">Description</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input class="validate" id="product_stock"  type="number" name="product_stock">
                        <label for="product_stock">Product Stock</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s5">
                        <div class="file-field input-field">
                            <div class="btn">
                                <span>Upload</span>
                                <input type="file" name="file"  multiple>
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text" placeholder="Upload one or more files">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12">
                         <input class="btn" type="submit" value="Add Product" >
                    </div>
                </div>
            </form>
        </div>
    
</html>
