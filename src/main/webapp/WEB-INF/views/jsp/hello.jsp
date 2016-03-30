<%@include file="header.jsp"%>
<div id="homediv">
	<div class="container" style="text-align: center;" id="mainhome">

		<form class="form-inline">
			<div class="form-group">
				<label class="sr-only">Email</label>
			</div>
			<div class="form-group">
				<label for="ecompany" class="sr-only">Password</label> <input
					type="text" class="form-control" id="ecompany"
					placeholder="hr@company.com">
			</div>
			<button onclick="popupReg(); captchaRefresh()"
				class="btn btn-primary  btn-lg" type="button">
				Get started for FREE! </span>
			</button>
		</form>
		<div class="row"  id="styleHome">
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="thumbnail">
					<img src="resources/core/images/accountant.png" alt="...">
					<div class="caption">
						<p>Account Management</p>
						
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="thumbnail">
					<img src="resources/core/images/attendance.png" alt="...">
					<div class="caption">
						<p>Thumbnail label</p>
						
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="thumbnail">
					<img src="resources/core/images/resource.png" alt="...">
					<div class="caption">
						<p>Hr Management</p>
						
					</div>
				</div>
			</div>
		</div>
		

	</div>
</div>
<%@include file="footer.jsp"%>
