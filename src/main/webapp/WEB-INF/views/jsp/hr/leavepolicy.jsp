<link href="${baseurl}/resources/core/css/home.css" rel="stylesheet" />
<link href="${baseurl}/resources/core/css/datePicker.css"
	rel="stylesheet" />
<%@include file="../header.jsp"%>
<div class="container" id="allBody">
	<div class="row">

		<div class="col-md-2" style="padding-right: 0px">
			<%@include file="../general/allhome.jsp"%>
		</div>


		<div class="col-md-8" id="midContent"
			style="border-left: 1px solid #CFCFCF; border-right: 1px solid #CFCFCF; text-align: center;">




			<div class="form-group form-horizontal"
				style="display: -webkit-inline-box; margin-top: 50px">
				<label class="col-sm-3 control-label">Holiday</label>

				<div class="input-group input-append date col-sm-5"
					id="dateRangePicker">
					<span class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span> <input type="text" class="form-control" name="date" id="inputDate" />

				</div>
				<label class="col-sm-1 control-label"> <span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>

				</label>
			</div>

			<div class="row">
				<div class="holidayDates">
					kjlj
					
				</div>
				
			</div>
		</div>
		<div class="col-md-2" id="individualDiv" style="padding-left: 0px;">

			<jsp:include page="../${userRole}/rightNav.jsp" />

		</div>
	</div>
</div>

<%@include file="../footer.jsp"%>

<script src="${baseurl}/resources/core/js/datePicker.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>