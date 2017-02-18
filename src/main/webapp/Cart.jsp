


<%@page import="com.mycompany.furniture.SystemDto.Cart.CartDetails"%>
<%@page import="com.mycompany.furniture.SystemDto.Cart.CartData"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('.modal').modal();

            });
        </script>
    </head>
    <body>
        <jsp:include page="Navigation.jsp" />
        <div class="container">
            <div class="row">

                <%
                    CartData data = new CartData();
                    Object id = session.getAttribute("user_id");
                    int user_id = Integer.parseInt(id.toString());
                    List<CartDetails> list = data.selectCartByUser(user_id);


                %>
                <%                     for (CartDetails details : list) {
                %>
                <a href="OrderController?product_id=<%=details.getProduct_id()%>&&user_id=<%=details.getUser_id()%>"> <div class="col ">
                        <div class="card-panel hoverable">
                            <div class="row">

                                <div   class="card-image ">
                                    <img class="responsive-img" src="images/<%=details.getImage_Name()%>" />
                                </div>

                            </div>
                            <div class="row">
                                <a href="#modal1" class="btn"  >Remove</a>
                                <div id="modal1" class="modal">
                                    <div class="modal-content">
                                        <h4>Are you sure You Want to remove from your Cart??</h4>
                                        <p>After Clicking on Agree This Product will be removed from your Cart</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="UpdateCart?product_id=<%=details.getCart_id()%>" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
                                    </div>
                                </div>


                            </div>


                        </div>
                </a>

                <%              }
                %>


                <div class="row">
                    <div class="col s1 m10">
                        <a class="btn" href="#modal1">Remove All</a>
                        <div id="modal1" class="modal">
                                    <div class="modal-content">
                                        <h4>Are you sure You Want to remove all products from your Cart??</h4>
                                        <p>After Clicking on Agree This all Product will be removed from your Cart</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="RemoveAllCart?user_id=<%=id.toString()%>" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
                                    </div>
                                </div>
                    </div>
                </div>
            </div>  
        </div>
    </div>
</body>
</html>
