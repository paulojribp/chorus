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

        <jsp:include page="../cabecalho.jsp"/>

        <div class="container">
            <div class="container-fluid">
			  <div class="row-fluid">
			  
			     <jsp:include page="../barraNavegacao.jsp"/>
			     
			    <div class="span8">
			    	<div class="well">
			    	<c:if test="${not empty notice}">
						<div id="notice" class="alert alert-success">
							<p>${notice.nome}</p>
						</div>
					</c:if>
		    		<legend>Cadastrar Usuario</legend>
					<form class="form-horizontal" action="<c:url value="/usuario/add" />" method="post">
					  <div class="control-group">
					    <label class="control-label" for="inputNome">Nome</label>
					    <div class="controls">
  				    	  <input type="text" id="nome" name ="usuario.nome" placeholder="Nome" >
					    </div>
					  </div>
					  <div class="control-group">
					    <label class="control-label" for="inputEmail">Email</label>
					    <div class="controls">
  				    	  <input type="text" id="email" name ="usuario.email" placeholder="Email" >
					    </div>
					  </div>
					  <div class="control-group">
					    <label class="control-label" for="inputLogin">Login</label>
					    <div class="controls">
  				    	  <input type="text" id="login" name ="usuario.login" placeholder="Login" >
					    </div>
					  </div>
					  <div class="control-group">
					    <label class="control-label" for="inputSenha">Senha</label>
					    <div class="controls">
  				    	  <input type="password" id="senha" name ="usuario.senha" placeholder="Senha" >
					    </div>
					  </div>
					  <div class="control-group">
					  	<div class="controls">
					    	<button class="btn btn-primary" type="submit">Salvar</button>
					  	</div>
				  	  </div>
				  </form>			    		
			    	</div>
			    </div>
			  </div>
			</div>
            <hr>

            <footer>
                <p>&copy; Company 2012</p>
            </footer>
        </div> 

        <script src="../js/vendor/bootstrap.min.js"></script>

    </body>
</html>
