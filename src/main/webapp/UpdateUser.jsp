

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Update</title>
        <link rel="stylesheet" type="text/css" href="css/materialize.min.css">
 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
	
  
</head>
<body>
    <jsp:include page="Navigation.jsp" />
    
<div class="page-header"></div>
 <div class="container">
  <div class="container">
  	<form class="form-inline" method="Post" action="UpdateController">
            <input class="form-control"  type="hidden" name="id" value="<%=request.getAttribute("id")%>">
            <label class="control-label col-sm-2">Full Name   :</label><input class="form-control" required="true" type="text" name="name" value="<%=request.getAttribute("name")%>"><br><br>
  		<label class="control-label col-sm-2">Address     :</label><input class="form-control" required="true" type="text" name="address" value="<%=request.getAttribute("address")%>"><br><br>
                <label class="control-label col-sm-2">E-Mail      :</label><input class="form-control" required="true" type="email" name="email" value="<%=request.getAttribute("email")%>"><br><br>
  		<label class="control-label col-sm-2">Phone No    :</label><input class="form-control" required="true" type="number" name="phone" value="<%=request.getAttribute("phone")%>"><br><br>
  		<label class="control-label col-sm-2">Password    :</label><input class="form-control" required="true" type="password" name="password" value="<%=request.getAttribute("password")%>"><br><br>
  		<input type="hidden" name="usertype" value="user">
  		<input class="btn" type="submit" value="Update">
  	</form>
  </div>
  </div>
</body>
</html>
