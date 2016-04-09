<link href="resources/core/css/home.css" rel="stylesheet" />
<%@include file="../header.jsp"%>
<div class="container" id="allBody">
	<div class="row">

		<div class="col-md-2" style="padding-right: 0px">
			<%@include file="../general/allhome.jsp"%>
		</div>

		<div class="col-md-8"
			style="border-left: 1px solid #CFCFCF; border-right: 1px solid #CFCFCF;">

			<form style="text-align: center; margin-top: 25px" enctype="multipart/form-data">
				<div class="form-horizontal">
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">Buddy
							Name</label>
						<div class="col-md-4 col-sm-4">
							<input type="text" class="form-control" id="inputPassword"
								placeholder="John Paul">
						</div>
						<label for="inputPassword" class="col-sm-2 control-label">Buddy
							Email</label>
						<div class="col-md-4 col-sm-4">
							<input type="text" class="form-control" id="inputPassword"
								placeholder="abc@example.com">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">Mobile
							no</label>
						<div class="col-md-4 col-sm-4">
							<input type="text" class="form-control" id="inputPassword"
								placeholder="9512345678">
						</div>
						<label for="inputPassword" class="col-sm-2 control-label">Pancard</label>
						<div class="col-md-4 col-sm-4">
							<input type="text" class="form-control" id="inputPassword"
								placeholder="BKXXXXXX0">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">Subject</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="subject"
								placeholder="Brief description">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">Upload Resume</label>
						<div class="col-md-4 col-sm-4">
							<input type="file" id="inputPassword" style="padding:10px" >
						</div>
						<label for="inputPassword" class="col-sm-2 control-label"></label>
						<div class="col-md-4 col-sm-4">
							<button type="submit" class="btn btn-primary pull-right">Submit</button>
						</div>
					</div>
				</div>
			</form>

		</div>
		<div class="col-md-2" id="individualDiv" style="padding-left: 0px;">

			<jsp:include page="../${userRole}/rightNav.jsp" />

		</div>
	</div>
</div>

<%@include file="../footer.jsp"%>