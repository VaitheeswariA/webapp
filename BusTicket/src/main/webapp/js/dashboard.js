var dashboard={
	searchBus : function(){
		var fromLocation = $("#fromLocation").val();
		var toLocation = $("#toLocation").val();
		var travelDate=$("#travelDate").val();
		if(new Date(travelDate).getTime() > new Date().getTime())
		{
			var successFunc=function(resp){
					if(resp!=null){
						$("#busListdiv").empty();
						var headerHtml="<table class='ui celled table' id='tablediv'><tr><th><b> Bus Name</b> </td><td ><b> Travel Timing</b></td><td><b> Available Seats</b></td><td><b> Bus Type</b></td><td><b> Seat Type</b></td><td><b>Available Service</b></td><td><b>Rating</b></td></tr>";
						$("#busListdiv").append(headerHtml);	
						for(var index=0;index<resp.data.length;index++){
							var seatType=(resp.data[index].seatTypeId==1)?"Semi Sleeper":(resp.data[index].seatTypeId==2)?"Sleeper":"Sleeper & Semi Sleeper";
							var innerHtml="<tr id=bus_"+resp.data[0].busId+"><td>"+resp.data[index].travelsName+"</td><td >"+resp.data[index].travelStartTime+"  -  "+resp.data[index].travelEndTime+"</td><td>"+resp.data[index].totalseats+" seats"+"</td><td>"+resp.data[index].busType +"</td><td>"+seatType+"</td><td><button class='ui primary button' id='bookbus_"+resp.data[0].busId+"'>Book</button></td><td><div class='ui yellow  rating disabled' data-icon='star' data-rating="+resp.data[index].rating.toString()+"></div></td><tr></table>";
							$("#tablediv").append(innerHtml);
							$('.ui.rating').rating();	
						}
					}
				}
			var failureFunc=function(resp){
				
				}
				apiUtil.ajaxGetMethod("../searchingbus",{"action":"search","fromLocation":fromLocation,"toLocation":toLocation,"travelDate":travelDate},true,"json",successFunc,failureFunc);		
		}
		else
		{
			
		}
	},
	boardingPoints : function(){
		var routeId =	$("[id^='bus_']").$("[id^='bookbus_']");
	},
	bindEvents : function(){
		$("#searchBusBtn").off("click").on("click", function(){
			$("#contentdiv").style.display="block";
		});
		$("#searchBus").off("click").on("click", function(){
			dashboard.searchBus();
		});
		
	}
}