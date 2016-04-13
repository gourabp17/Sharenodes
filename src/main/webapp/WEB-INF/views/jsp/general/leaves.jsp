<link href="resources/core/css/home.css" rel="stylesheet" />
<%@include file="../header.jsp"%>
<div class="container" id="allBody">
	<div class="row">

		<div class="col-md-2" style="padding-right: 0px">
			<%@include file="../general/allhome.jsp"%>
		</div>


		<div class="col-md-8" id="midContent"
			style="border-left: 1px solid #CFCFCF; border-right: 1px solid #CFCFCF;">
			<div style="margin: 25px">

				<form class="form-horizontal">
					<div class="form-group" style="display: -webkit-inline-box">
						<label class="col-sm-2 control-label">From</label>
						<div class="col-sm-10 input-group input-append date col-sm-3"
							id="dateRangePickerFrom">
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span> <input type="text" class="form-control" name="date" id="from" />
						</div>
						<div class="col-md-2" style="margin-left: 10px">

							<div class="form-group">
								<select class="form-control">
									<option value="half">Half Day</option>
									<option value="full" selected>Full Day</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group" style="display: -webkit-inline-box">
						<label class="col-sm-2 control-label">To</label>
						<div class="col-sm-10 input-group input-append date col-sm-3"
							id="dateRangePickerTo">
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span> <input type="text" class="form-control" name="date" id="to" />
						</div>
						<div class="col-md-2" style="margin-left: 10px">

							<div class="form-group">
								<select class="form-control">
									<option value="half">Half Day</option>
									<option value="full" selected>Full Day</option>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-warning" id="getBetween">Calculate
								Leaves</button>
							<button type="submit" class="btn btn-primary">Apply
								Leaves</button>

						</div>

					</div>
				</form>

			</div>
			<div id="results"></div>
		</div>
		<div class="col-md-2" id="individualDiv" style="padding-left: 0px;">

			<jsp:include page="../${userRole}/rightNav.jsp" />

		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>
<script src="${baseurl}/resources/core/js/applyleave.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>