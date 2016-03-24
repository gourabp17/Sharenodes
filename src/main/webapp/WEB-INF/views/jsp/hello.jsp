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
	</div>
</div>
<%@include file="footer.jsp"%>
