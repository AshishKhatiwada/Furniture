
<%@page import="com.mycompany.furniture.SystemDto.Product.ProductDetails"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>

        <link href="fonts/roboto/js.woff2" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Navigation.jsp" />
        <% Object id = session.getAttribute("user_id");
            String user_id = id.toString();

            List<ProductDetails> list = (List) request.getAttribute("data");

        %>

        <div class="container"> 
            <div class="row">

                <%     for (ProductDetails user : list) {

                %>

                <div class="col s1" style="width: 16em;"> 
                    <div class="card hoverable" style="height: 21em; width: 14em;">
                        <div class="card-image waves-effect waves-block waves-light" style="height:13em;">

                            <img class="activator" src="images/<%=user.getImage_Name()%>">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4"><%=user.getProduct_Name()%><i class="material-icons right"></i></span>
                            <p>Rs <%=user.getPrice()%> </p>
                            <p><a href="OrderController?user_id=<%=user_id%>&&product_id=<%=user.getId()%> ">Order</a></p>
                        </div>
                        <div class="card-reveal">

                            <span class="card-title grey-text text-darken-4"><%=user.getProduct_Name()%><i class="material-icons right">close</i></span>
                            <p><%=user.getDescription()%></p>
                        </div>
                    </div>
                </div>    


                <%
                    }

                %>
            </div>    
        </div>     


    </body>
</html>
