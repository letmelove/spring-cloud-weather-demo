/**
 * report页面下拉框事件
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		var url = '/report/citydata/'+cityId;
		window.location.href = url;
	})
})