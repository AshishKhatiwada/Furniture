<%-- 
    Document   : OrderPage
    Created on : Jan 22, 2017, 8:42:24 PM
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
        <script type="text/javascript">
            $(document).ready(function () {
                $('.modal').modal();

            });
        </script>
    </head>
    <body>
        <jsp:include page="Navigation.jsp"></jsp:include>
            <div class="container">


                <div class="row">
                    <div class="card-panel">
                        <div class="card-image">

                            <div class="row ">
                                <div class="col s12">
                                    <span style="float:right;" class="right-aligned blue-grey-text">Price : Rs <%=request.getAttribute("price")%></span>
                            </div>
                            <div   class="col s4">
                                <span  class="right-aligned blue-grey-text">Product Name : <%=request.getAttribute("product_Name")%></span>
                            </div>
                        </div>
                        <img class="responsive-img" src="images/<%=request.getAttribute("image_name")%>">
                        <div class="row">
                            <div class="col s8">
                                <span  class="right-aligned blue-grey-text"> <%=request.getAttribute("description")%> </span>
                            </div>
                            <div  class="col s12 m2">
                                <a href="#modal1" class="waves-effect waves-light btn">Add Cart</a>
                                <div id="modal1" class="modal">
                                    <div class="modal-content">
                                        <h4>Are you sure You Want to Add to Cart??</h4>
                                        <p>After Clicking on Agree This Product will Save in Cart of your Profile</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="CartController?user_id=<%=request.getAttribute("user_id")%>&&product_id=<%=request.getAttribute("product_id")%>" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
                                    </div>
                                </div>
                            </div>
                            <div  class="col s1 ">
                                <a href="#modal2" class="waves-effect waves-light btn">Book Now</a>
                                <div id="modal2" class="modal">
                                    <div class="modal-content">
                                        <h4>Are you sure You Want to Book this Product??</h4>
                                        <p>After Clicking on Agree This Product will be booked and you will get Call..</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="BookController?user_id=<%=request.getAttribute("user_id")%>&&product_id=<%=request.getAttribute("product_id")%>" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div> 

            </div>


        </div>

    </body>
</html>
