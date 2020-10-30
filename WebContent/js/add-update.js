/*----------------------------添加修改操作相关--------------------------------*/
//修改/添加 提交
$("#sub").click(function sub() {
	$.ajax({
		type : 'POST',
		data : $('form').serialize(),
		// 修改和添加 URL处理
		// uUrl/aUrl属性存放请求路径, isupdate 判断是否为修改操作
		url : $("#isupdate").val() != null ? $(this).attr("uUrl") : $(this).attr("aUrl"),
		success : function() {
			// 成功提示
			zeroModal.show({
				title : "Success",
				content : "Change Submitted!",
				width : '200px',
				height : '130px',
				overlay : false,
				ok : true,
				okFn:function(){
					//window.top.frames["right"].history.back(-1);
					window.parent.location.reload();
				}
			});
			
		},
		error : function(xhr) {
			alert("Failed to submit!");
		}
	});
	//return false;
});

$("#sub2").click(function sub() {
	data = $('form').serialize();
	skills = data.split('&').filter(function(item){
		return item.startsWith('skillsId')})
		.map(function(item){
			return item.split('=')[1]
			}
		).join(',');
	console.log("hello", data);
	$.ajax({
		type : 'POST',
		data : 'skills=' + skills + '&' + data,
		// 修改和添加 URL处理
		// uUrl/aUrl属性存放请求路径, isupdate 判断是否为修改操作
		url : $("#isupdate").val() != null ? $(this).attr("uUrl") : $(this).attr("aUrl"),
		success : function() {
			// 成功提示
			zeroModal.show({
				title : "Success",
				content : "Change Submitted!",
				width : '200px',
				height : '130px',
				overlay : false,
				ok : true,
				okFn:function(){
					//window.top.frames["right"].history.back(-1);
					window.parent.location.reload();
				}
			});
			
		},
		error : function(xhr) {
			alert("Failed to submit!");
		}
	});
	//return false;
});


// 弹出修改添加框 flag:修改添加标识 url: 请求路径 action: 回调form表单路径
function _iframe(flag, url, action) {
	zeroModal.show({
		title : flag == 1 ? 'Edit' : 'Add',
		iframe : true,
		url : url,
		width : '90%',
		height : '90%',
		cancel : true,
		top : '0px',
		left : '0px',
		esc : true,
		overlay : true,
		overlayClose : true,
		// 关闭后回调刷新数据
		onClosed : function() {
			$("form input").attr("disabled", "disabled");
			$("form").attr("method", "get");
			$("form").attr("action", action).submit();
		}
	});
}