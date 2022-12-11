var apiUtil = {
	ajaxGetMethod: function(urlval, dataval, asyncval, datatype, successFunc, failureFunc){
			
		$.ajax({
			type: "GET",//NO I18N
			url: urlval,
			dataType: datatype,
			data: dataval,
			async: asyncval,
			success: function(data){
				successFunc(data);
			}, error: function(xhr){
				if(failureFunc){
					failureFunc(xhr);
				}
			}
		});    
	},
	ajaxPostMethod: function(urlVal, dataval, asyncval, datatype, successFunc, failureFunc){   
		//If an ajax call is synchronous, it means that code execution will block (or wait) for the ajax call to return from the server before continuing then asyncval should be false
		//If an ajax call is asynchronous, it means that code execution will not block (or wait) for the ajax call to return from the before continuing then asyncval should be true

		$.ajax({
			type: "POST",//NO I18N
			url: urlVal,
			dataType: datatype,
			data: dataval,
			async: asyncval, 
			success: function(data){
				successFunc(data);
			}, error: function(xhr){
				if(failureFunc){
					failureFunc(xhr);
				}
			}
		});    
	}
};