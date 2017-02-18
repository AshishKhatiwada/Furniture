

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/materialize.min.css">
 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
	<title>
		Main Page
	</title>
	<script type="text/javascript">
		  $(document).ready(function(){
		  	$(".button-collapse").sideNav();
		  	$('.slider').slider('start');

      $('.slider').slider({full_width: true});
    });
      	
	</script>
</head>
<body>
<jsp:include page="Navigation.jsp" />
 
<div class= "slider">
<ul class="slides">
	<li><img class="responsive-img" src="images/h.jpg"></li>
	<li><img class="responsive-img" src="images/h2.jpg"></li>
    <li><img class="responsive-img" src="images/h3.jpg"></li>
	<li><img class="responsive-img" src="images/h2.jpg"></li>
</ul>
</div>

<div>
	<h5 class="center-align" style="font-family:cursive ;margin-top: 20px;"> What We Do</h1>
</div>
<hr style="width: 29em;">
<div class=" valign-wrapper">
<div class="row">
      <div class="col s1" style="width: 16em;">
        <div class="card-small hoverable ">
    	<div class="card-image waves-effect waves-block waves-light">
     		<img class="responsive-img" src="images/home.jpg">
   		 </div>
   		 <div class="card-content">
     		 <p><a href="#">link</a></p>
   			 </div>
        </div>
      </div>
   


      <div class="col s2" style= "width: 16em;">
        <div class = "card-small hoverable">
    	<div class="card-image waves-effect waves-block waves-light">
     		<img class="responsive-img" src="images/home.jpg">
   		 </div>
   		 <div class="card-content">
     		 <p><a href="#">link</a></p>
   			 </div>
   		</div>      
      </div> 



        <div class="col s3" style= "width: 16em;">
        <div class = "card-small hoverable">
    	<div class="card-image waves-effect waves-block waves-light">
     		<img class="responsive-img" src="images/home.jpg">
   		 </div>
   		 <div class="card-content">
     		 <p><a href="#">link</a></p>
   			 </div>
   		</div>      
      </div> 


        <div class="col s4" style= "width: 16em;">
        <div class = "card-small hoverable">
    	<div class="card-image waves-effect waves-block waves-light">
     		<img class="responsive-img" src="images/home.jpg">
   		 </div>
   		 <div class="card-content">
     		 <p><a href="#">link</a></p>
   			 </div>
   		</div>      
      </div> 
</div>

</div>







<footer class="page-footer" style="background-color:rgba(0, 0, 0, 0.66)">
          <div class="container">
            <div class="row">
              <div class="col l5 s5">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2017 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>

</body>
</html>
