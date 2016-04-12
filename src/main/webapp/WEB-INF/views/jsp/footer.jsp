<div class="mainFooter">
	<div class="container">

		<footer>
			<p class="text-left navbar-text">
				Author: 
				<a href="http://www.gourabpaul.info" target="_blank"> <span class="glyphicon glyphicon-link" aria-hidden="true"> </span> Gourab Paul </a>
				<a href="http://www.pradeepinfo.sharenodes.com" target="_blank"> <span class="glyphicon glyphicon-link" aria-hidden="true"> </span> Pradeep Tripathi </a>
			</p>
			<p class="navbar-right navbar-text">&copy; sharenodes.com</p>
		</footer>
	</div>
</div>
<spring:url value="${baseurl}/resources/core/js/base.js" var="coreJs" />
<spring:url value="${baseurl}/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script src="${bootstrapJs}"></script>

</body>
</html>