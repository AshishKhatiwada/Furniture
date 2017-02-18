

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $(".dropdown-button").dropdown();
            });
        </script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper grey darken-3" >
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <a href="Welcome.jsp" class="brand-logo"><img src="images/logo.jpg" class=" responsive-img" style="height: 61px;border-radius: 12px;"></a>
                    <ul  class="right hide-on-med-and-down">
                        <li><a href="">Home</a></li>
                        <li><a class="dropdown-button" href="#dropdown1" data-activates="dropdown1">Product<i class="material-icons right">arrow_drop_down</i></a></li>
                        <ul id="dropdown1" class="dropdown-content">
                            <li><a href="AddProduct.jsp">Add Product</a></li>
                            <li class="divider"></li>
                            <li><a href="ProductList.jsp">View Product</a></li>
                        </ul>


                        <li><a href="">Users</a></li>
                        <li><a href="">Order Details</a></li>
                        <li><a href="">Logout</a></li>
                    </ul>
                    <ul class="side-nav"  id="mobile-demo" >
                        <li><a href="">Home</a></li>
                        <li><a href="">Product</a></li>
                        <li><a href="">Users</a></li>
                        <li><a href="">Order Details</a></li>
                        <li><a href="">Logout</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>
