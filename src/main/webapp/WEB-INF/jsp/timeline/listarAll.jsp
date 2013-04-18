<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">

        <script src="../js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="../js/vendor/jquery-1.9.1.min.js"></script>
        <script type="text/javascript">
			$('#chorinho').keypress(function(event){
				contador = parseInt($('#contador_chorinho').text());
					if(event.which==8 && contador <= 140){
						$('#contador_chorinho').text(contador+1);
					}else{
						$('#contador_chorinho').text(contador-1);
						if(contador== 0) {
							alert('perdeu playboy!!!');
						}
					}
			});
		</script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href="#">Chorus</a>
                    <div class="nav-collapse collapse">
                        <form class="navbar-form pull-right">
                            <input class="span2" type="text" placeholder="Email">
                            <input class="span2" type="password" placeholder="Password">
                            <button type="submit" class="btn">Acessar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="container-fluid">
			  <div class="row-fluid">
			    <div class="span3">
			      <ul class="nav nav-tabs nav-stacked">
  					<li><a href="#" class="">Chorinhos<i class="icon-chevron-right pull-right"></i></a></li>
  					<li><a href="#" class="">Seguindo<i class="icon-chevron-right pull-right"></i></a></li>
  					<li><a href="#" class="">Seguidores<i class="icon-chevron-right pull-right"></i></a></li>
				  </ul>
			    </div>
			    <div class="span8">
			    	<div class="well">
			    	<span class="pull-right"><a href="#myModal" role="button" class="btn btn-primary" data-toggle="modal">Enviar chorinho</a></span>
			    	</div>
			    	<div class="well">
			    		<legend>Chorinhos</legend>
			    		<ul class="media-list">
			    			<c:forEach var="chorus" items="${chorinhos}">
					    		<li class="media">
								    <a class="pull-left" href="#">
								      <img class="media-object" data-src="../images/thumb64x64.png">
								    </a>
								    <div class="media-body">
								    	<h4 class="media-heading">${chorus.usuario.login}</h4>
								    	<p>${chorus.mensagem}</p>
								    </div>
								  </li>
							 </c:forEach> 
			    		</ul>
			    	</div>
			    </div>
			  </div>
			</div>
            <hr>

            <footer>
                <p>&copy; Company 2012</p>
            </footer>
			<!-- Modal -->
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <form action="<c:url value="/timeline/publicar" />" method="post">
				  <div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				    <h3 id="myModalLabel">Escrevendo chorinho</h3>
				  </div>
				  <div class="modal-body">
				    <p>Nome<input class="input-block-level" id="nome" name ="chorus.usuario.login"></input></p>
				  </div>
				  <div class="modal-body">
				    <p>Chorus<textarea rows="3" class="input-block-level" id="chorinho" name="chorus.mensagem"></textarea></p>
				  </div>
				  <div class="modal-footer">
				    <button class="btn btn-primary" type="submit">Enviar</button>
				  </div>
			  </form>
			</div>

        </div> 

        <script src="../js/vendor/bootstrap.min.js"></script>

    </body>
</html>
