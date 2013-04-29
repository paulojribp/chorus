<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/cabecalho.jsp" %>

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
								    	<h4 class="media-heading">${chorus.usuario.username}</h4>
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
				    <p>Nome<input class="input-block-level" id="nome" name ="chorus.usuario.username"></input></p>
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
