$(function() {
	initSemester();
	$('#btn-query-semester').on('click', function() {
		var year = $('#search-semester').val();
		var thisYear = new Date().getFullYear();
		if (/^((?:19|20)\d\d)/.test(year)) {
		} else {
			alert('请输入正确的年格式,例如2015');
			return false;
		}
		if (year > thisYear) {
			alert('查询年不能大于当前年!');
			return false;
		}

		generateSemester(year);

	});

});
//
function initSemester() {
	var thisYear = new Date().getFullYear();
	$('#search-semester').val(thisYear);
	generateSemester(thisYear);
}

function generateSemester(year) {
	$('#semester-content').empty();
	$.each(generateSemestersByYear(year), function(index, semester) {
		var html = '<tr data-id="' + semester.id + '">' + '<td>'
				+ semester.name + '</td>'
				+ '<td><span class="glyphicon glyphicon-eye-open"></span></td>'
				+ '</tr>';
		$('#semester-content').append(html);
	});
	// bind

	$('#semester-content td .glyphicon-eye-open').on(
			'click',
			function() {
				$('#grdtdesignActTea--content').empty();
				var semester = $(this).closest('tr').attr('data-id');
				var target = new GrdtdesignActTeachTargetObject(
						'#grdtdesignActTea-page', '#grdtdesignActTea-content',
						'/api/user/1234567890/grdtdesignActTeachers');
				var page = new AjaxPageParser(target, 'page');
				target.paramData.semester = semester;
				page.pageCallBack('1');
			});
}

var GrdtdesignActTeachTargetObject = function(dom, pageContainer, url) {
	this.dom = dom;
	this.pageContainer = pageContainer;
	this.url = url;
	this.paramData = null;

	this.pageInfoParser = function(jsonPageInfo) {

		var pageContainer = this.pageContainer;

		$.each(jsonPageInfo.grdtdesignActTeachers.pageList, function(index,
				account) {

			var html = '<tr>' + '<td>'
					+ getSemester(account.grdtdesignAccount.semester) + '</td>'
					+ '<td>' + account.grdtdesignAccount.major.name
					+ account.grdtdesignAccount.grade + '</td>' + '<td>'
					+ account.workload + '</td>' + '<td>' + account.period
					+ '</td>' + '<td>' + account.remark + '</td>'
			'</tr>';

			$(pageContainer).append(html);
		});// $.each
		// 绑定事件
		this.bind();
	}

	this.getParamData = function() {

		var paramData = {
			type : 'previous'
		};

		return paramData;
	}

	this.paramData = this.getParamData();

}

GrdtdesignActTeachTargetObject.prototype.bind = function() {

};