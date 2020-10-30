// REST 风格请求
function update(url) {
	$("form input").attr("disabled", "disabled");
	$("form").attr("method", "get");
	$("form").attr("action", url).submit();
	return false;
}
function del(url) {
	$("form input").attr("name", "_method");
	$("form").attr("action", url).submit();
	return false;
}


//鼠标移入当前行 显示被隐藏的按钮
$(function() {
	$("tr").mouseover(function() {
		$(this).children("td").children("div").children(".dynamicBtn").show();
	}).mouseout(function() {
		$(this).children("td").children("div").children(".dynamicBtn").hide();		
	});
});