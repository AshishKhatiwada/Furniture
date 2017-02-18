<%-- 
    Document   : Signup
    Created on : Jan 13, 2017, 1:19:41 PM
    Author     : AAA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SignUp</title>
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </head>
    <body>

        <div class="container">
            <div class="container">
                <form class="form-inline" method="Post" action="SignUpController">
                    <label class="control-label col-sm-2">Full Name   :</label><input class="form-control" required="true" type="text" name="name"><br><br>
                    <label class="control-label col-sm-2">Address     :</label><input class="form-control" required="true" type="text" name="address"><br><br>
                    <label class="control-label col-sm-2">E-Mail      :</label><input class="form-control" required="true" type="email" name="email"><br><br>
                    <label class="control-label col-sm-2">Phone No    :</label><input class="form-control" required="true" type="number" name="phone"><br><br>
                    <label class="control-label col-sm-2">Password    :</label><input class="form-control" required="true" type="password" name="password"><br><br>
                    <input type="hidden" name="usertype" value="user">
                    <input class="btn" type="submit" value="SignUp">
                </form>
            </div>
        </div>
    </body>
</html>
