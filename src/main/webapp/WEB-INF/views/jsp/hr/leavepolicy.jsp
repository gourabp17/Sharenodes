<link href="resources/core/css/home.css" rel="stylesheet" />
<%@include file="../header.jsp"%>
<div class="container" id="allBody">
	<div class="row">

		<div class="col-md-2" style="padding-right: 0px">
			<%@include file="../general/allhome.jsp"%>
		</div>


		<div class="col-md-8" id="midContent"
			style="border-left: 1px solid #CFCFCF; border-right: 1px solid #CFCFCF;">

			
			<div class="col-xs-6 col-md-4">
				<div href="#" class="thumbnail">
					<div class="caption">
						<h4>Thumbnail label</h4>
						<p>...</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-4">
				<div href="#" class="thumbnail">
					<div class="caption">
						<h4>Thumbnail label</h4>
						<p>...</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-4">
				<div href="#" class="thumbnail">
					<div class="caption">
						<h4>Thumbnail label</h4>
						<p>...</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-4">
				<div href="#" class="thumbnail">
					<div class="caption">
						<h4>Thumbnail label</h4>
						<p>...</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-4">
				<div href="#" class="thumbnail">
					<div class="caption">
						<h4>Thumbnail label</h4>
						<p>...</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			
			<div class="col-xs-6 col-md-4">
				<div href="#" class="thumbnail">
					<div class="caption">
						<h4>Thumbnail label</h4>
						<p>...</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>

		</div>
		<div class="col-md-2" id="individualDiv" style="padding-left: 0px;">

			<jsp:include page="../${userRole}/rightNav.jsp" />

		</div>
	</div>
</div>

<%@include file="../footer.jsp"%>
