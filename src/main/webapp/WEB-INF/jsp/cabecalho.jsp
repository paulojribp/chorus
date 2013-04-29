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
        <script src="../js/chorus.js"></script>
    </head>
    <body>
    	<c:out value="${basePath}" />
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->

<c:choose>
	<c:when test="${not empty usuario}">
		<div class="navbar navbar-inverse navbar-fixed-top">
		    <div class="navbar-inner">
		        <div class="container">
		            <a class="brand" href="#">Chorus</a>
		            <div class="nav-collapse collapse">
		            	Usuário:
		                ${usuario.nome}
		            </div>
		        </div>
		    </div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="navbar navbar-inverse navbar-fixed-top">
		    <div class="navbar-inner">
		        <div class="container">
		            <a class="brand" href="#">Chorus</a>
		            <div class="nav-collapse collapse">
		                <form class="navbar-form pull-right">
		                    <input class="span2" type="text" placeholder="Email">
		                    <input class="span2" type="password" placeholder="Password">
		                    <button type="submit" class="btn">Acessar</button>
		                    <a class="btn btn-medium btn-primary" id="btn-modal-cadastrar">
		                    	<i class="icon-user"> </i> Cadastrar
		                    </a>
		                </form>
		            </div>
		        </div>
		    </div>
		</div>
	</c:otherwise>
</c:choose>

	<div id="modal-cadastro" class="modal hide fade">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>Cadastro de Usuário</h3>
		</div>
		<div class="modal-body">
			<form id="form-cadastro" class="form-horizontal">
				<div class="control-group">
					<input type="text" id="inputUsername" placeholder="Nome de Usuário" style="width: 300px;" />
				</div>
				<div class="control-group">
					<input type="text" id="inputEmail" placeholder="Email" style="width: 300px;" />
				</div>
				<div class="control-group">
					<input type="text" id="inputSenha" placeholder="Senha" style="width: 300px;">
				</div>
				<div class="control-group">
					<input type="text" id="inputConfirmaSenha" placeholder="Confirmação de Senha" style="width: 300px;">
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<a href="#" id="btn-cancel-usuario" class="btn">Cancelar</a>
			<a href="#" id="btn-criar-usuario" class="btn btn-primary">Criar Usuário</a>
		</div>
	</div>