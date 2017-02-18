
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="style.css">
	<title>Login Page</title>
  <script type="text/javascript" src="js/materialize.min.js"></script>  
  <script>
     
      </script>
</head>
<body>
    <div id="Blankdiv"></div>
<div id="heading_login">Login Form</div>   
<div class="form_div">
    <form class="login_form" action="LoginController" method="Post">
       
<p class="username">
<label>Username </label><input type="text" name="username" required="true">
</p>
<p class="password">
<label>Password    </label><input type="password" name="password" required="true">
</p>
<p>
	<input id="login" type="submit" value="Login">
</p>
	
</form>
</div>
</body>
</html>