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
		                </form>
		            </div>
		        </div>
		    </div>
		</div>
	</c:otherwise>
</c:choose>			
					