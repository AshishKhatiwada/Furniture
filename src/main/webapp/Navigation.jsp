


<%@page import="com.mycompany.furniture.SystemDto.Cart.CartData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <% CartData data = new CartData();
            Object user_id = session.getAttribute("user_id");
            int id = Integer.parseInt(user_id.toString());
            int count = data.countCartData(id);


        %>
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper grey darken-3" >
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <a href="Welcome.jsp" class="brand-logo"><img src="images/logo.jpg" class=" responsive-img" style="height: 61px;border-radius: 12px;"></a>
                    <ul  class="right hide-on-med-and-down">
                        <li><a href="Welcome.jsp">Home</a></li>
                        <li><a href="ListProduct">Order</a></li>
                        <li><a href="#">Staff</a></li>
                        <li><a href="About.jsp">About Us</a></li>
                        <li><a href="Cart.jsp">Cart <span class="new badge red"><%=count%></span></a></li>
                        <li><a href="UpdateController?email=<%= session.getAttribute("user")%>">Profile</a></li>
                        <li><a href="Logout">Logout</a></li>
                    </ul>
                    <ul class="side-nav"  id="mobile-demo" >
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Order</a></li>
                        <li><a href="">Staff</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Cart</a></li>
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>
