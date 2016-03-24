<link href="resources/core/css/home.css" rel="stylesheet" />
<%@include file="../header.jsp"%>
<div class="container">
	<div class="row">

		<div class="col-md-2" style="padding-right: 0px">
			<%@include file="../general/allhome.jsp"%>
		</div>
		

		<div class="col-md-8" id="midContent"
			style="border-left: 1px solid #CFCFCF; border-right: 1px solid #CFCFCF;">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<c:forEach var="listValue" items="${broadcast}" varStatus="theCount">
					<div class="panel panel-default">

						<div class="panel-heading" role="tab"
							id="heading${theCount.index}" role="button"
							data-toggle="collapse" data-parent="#accordion"
							href="#collapse${theCount.index}" aria-expanded="false"
							aria-controls="collapse${theCount.index}">
							<h4 class="panel-title">
								<a> ${listValue.broadcasterPath}
									${listValue.broadcasterName} ${listValue.broadcastHeader}</a>
							</h4>
						</div>
						<div id="collapse${theCount.index}"
							class="panel-collapse collapse" role="tabpanel"
							aria-labelledby="heading${theCount.index}">
							<div class="panel-body">${listValue.broadcastMsg}</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>
		<div class="col-md-2" id="individualDiv" style="padding-left: 0px;">
		
			<jsp:include page="../${userRole}/rightNav.jsp" />

		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>
