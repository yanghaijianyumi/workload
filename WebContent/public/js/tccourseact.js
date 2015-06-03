$(function() {

	// course select
	$('#query-course').on(
			'click',
			function() {
				var page = new AjaxPageParser(new CourseTargetObject(
						'#course-page', '#course-content',
						'/api/user/1234567890/college/courses'), 'page');
				page.pageCallBack('1');
			});
	//
	$('#courseactModal').on('show.bs.modal', function(e) {
		// loadsemester();
		if ($('#semester').children().length < 1) {
			return false;
		}
		loadSemester();
	})
	//
	$('#courseact-form').submit(function(e) {

		var courseId = $('#course-id').val();
		if (courseId == '') {
			alert('请选择课程!');
			e.preventDefault();
			return false;
		}

		$("#courseact-submit").attr("disabled", true);
		$('#courseact-form').ajaxSubmit({
			url : '/api/user/courseAccount',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				$("#courseact-submit").attr("disabled", false);
				alert(data.message)
			},
			error : function() {
				$("#courseact-submit").attr("disabled", false);
				alert('添加失败！服务器异常!');
			},
		});
		e.preventDefault();
		return false;
	});
	// 历史记录导入
	$("#btn-query-his").on(
			'click',
			function() {
				var semester = $(this).closest('tr').attr('data-id');
				var target = new CourseAccountTargetObject(
						'#courseAccount-page', '#courseAccount-content',
						'/api/user/courseAccounts');
				var page = new AjaxPageParser(target, 'page');
				page.pageCallBack('1');
			});
	// 学时总人数计算
	$("#courseact-courseNum")
			.blur(
					function() {
						var courseNum = $(this).val();
						var courseRepnum = $('#courseact-courseRepnum').val();
						if (courseNum != '' && /^[1-9]\d*|0$/.test(courseNum)) {
							if (courseRepnum != ''
									&& /^[1-9]\d*|0$/.test(courseRepnum)) {
								$('#courseact-peoples').val(
										parseInt(courseNum)
												+ parseInt(courseRepnum));
							} else {
								$('#courseact-peoples').val(0);
							}
						} else {
							if (courseRepnum != ''
									&& /^[1-9]\d*|0$/.test(courseRepnum)) {
								$('#courseact-peoples').val(courseRepnum);
							} else {
								$('#courseact-peoples').val(0);
							}
						}
					});

	$("#courseact-courseRepnum").blur(
			function() {
				var courseRepnum = $(this).val();
				var courseNum = $('#courseact-courseNum').val();
				if (courseRepnum != '' && /^[1-9]\d*|0$/.test(courseRepnum)) {
					if (courseNum != '' && /^[1-9]\d*|0$/.test(courseNum)) {
						$('#courseact-peoples').val(
								parseInt(courseNum) + parseInt(courseRepnum));
					} else {
						$('#courseact-peoples').val(0);
					}
				} else {
					if (courseNum != '' && /^[1-9]\d*|0$/.test(courseNum)) {
						$('#courseact-peoples').val(courseNum);
					} else {
						$('#courseact-peoples').val(0);
					}
				}
			});
	// 工作量计算
	$("#courseact-typeFactor").blur(
			function() {
				var typeFactor = $(this).val();
				var repFactor = $('#courseact-repFactor').val();
				var stuNum = $('#courseact-peoples').val();
				if (typeFactor != ''
						&& /^(\d|[1-9]\d+)(\.\d+)?$/.test(typeFactor)) {
					if (repFactor != ''
							&& /^(\d|[1-9]\d+)(\.\d+)?$/.test(repFactor)) {
						$('#courseact-workload').val(
								parseInt(typeFactor) * parseInt(repFactor)
										* parseInt(stuNum));
					} else {
						$('#courseact-workload').val(0);
					}
				} else {
					$('#courseact-workload').val(0);
				}
			});
	$("#courseact-repFactor").blur(
			function() {
				var repFactor = $(this).val();
				var typeFactor = $('courseact-typeFactor').val();
				var stuNum = $('#courseact-peoples').val();
				if (repFactor != ''
						&& /^(\d|[1-9]\d+)(\.\d+)?$/.test(repFactor)) {
					if (typeFactor != ''
							&& /^(\d|[1-9]\d+)(\.\d+)?$/.test(typeFactor)) {
						$('#courseact-workload').val(
								parseInt(typeFactor) * parseInt(repFactor)
										* parseInt(stuNum));
					} else {
						$('#courseact-workload').val(0);
					}
				} else {
					$('#courseact-workload').val(0);
				}
			});

});

//
function loadSemester() {

	ajaxAction({
		url : '/api/user/semesters/',
		method : 'GET'
	}, {}, {
		callbackHandler : function(data) {
			alert(data)
		},
		exceptionHandler : function(XMLHttpRequest, textStatus, errorThrown) {
			alert('服务器忙!');
		}
	});

}

var CourseTargetObject = function(dom, pageContainer, url) {
	this.dom = dom;
	this.pageContainer = pageContainer;
	this.url = url;
	this.paramData = null;

	this.pageInfoParser = function(jsonPageInfo) {

		var pageContainer = this.pageContainer;

		$
				.each(
						jsonPageInfo.courses.pageList,
						function(index, course) {
							var createDate = course.createDate ? dateFormat
									.format(new Date(course.createDate)) : '';

							var html = '<tr data-id="'
									+ course.id
									+ '">'
									+ '<td>'
									+ course.name
									+ '</td>'
									+ '<td>'
									+ course.college.name
									+ '</td>'
									+ '<td>'
									+ createDate
									+ '</td>'
									+ '<td>'
									+ '<span class="glyphicon glyphicon-copy" aria-hidden="true"></span>'
									+ '</td>' + '</tr>';
							$(pageContainer).append(html);
						});// $.each
		// 绑定事件
		this.bind();
	}

	this.getParamData = function() {
		var searchKeyWord = $('#search-course').val();

		if (searchKeyWord.length == 0) {
			searchKeyWord = null;
		} else if (searchKeyWord.length > 10) {
			alert('输入查询关键字不能超过十个字!');
			return false;
		}
		var paramData = {
			name : searchKeyWord,
		};

		return paramData;
	}

	this.paramData = this.getParamData();

}

CourseTargetObject.prototype.bind = function() {
	$('#course-content td .glyphicon-copy').on('click', function() {

		var courseId = $(this).closest('tr').attr('data-id');
		var courseName = $(this).closest('tr').find('td').first().html();

		$('#course-id').val(courseId);
		$('#course-name').val(courseName);

		$('#courseModal').modal('hide')
	});
};
//
var CourseAccountTargetObject = function(dom, pageContainer, url) {
	this.dom = dom;
	this.pageContainer = pageContainer;
	this.url = url;
	this.paramData = null;

	this.pageInfoParser = function(jsonPageInfo) {

		var pageContainer = this.pageContainer;

		$
				.each(
						jsonPageInfo.courseAccounts.pageList,
						function(index, account) {

							var html = '<tr data-id="'
									+ account.id
									+ '">'
									+ '<td>'
									+ getSemesterName(account.semester)
									+ '</td>'
									+ '<td>'
									+ account.course.name
									+ '</td>'
									+ '<td>'
									+ account.student
									+ '</td>'
									+ '<td>'
									+ account.classHour
									+ '</td>'
									+ '<td>'
									+ account.typeFactor
									+ '</td>'
									+ '<td>'
									+ account.repFactor
									+ '</td>'
									+ '<td>'
									+ account.workload
									+ '</td>'
									+ '<td>'
									+ account.campus
									+ '</td>'
									+ '<td><span class="glyphicon glyphicon-copy"aria-hidden="true" data-toggle="modal" data-target="#courseAccountModal"></span></td>'
									+ '</tr>';
							$(pageContainer).append(html);
						});// $.each
		// 绑定事件
		this.bind();
	}

	this.getParamData = function() {

		var paramData = {
			type : 'all'
		};

		return paramData;
	}

	this.paramData = this.getParamData();

}

CourseAccountTargetObject.prototype.bind = function() {

	$('#courseAccount-content td .glyphicon-copy')
			.on(
					'click',
					function() {
						var accountId = $(this).closest('tr').attr('data-id');
						if (typeof (accountId) == 'undefined'
								|| accountId.length != 24) {
							return false;
						}
						ajaxAction({
							url : '/api/user/courseAccount/' + accountId,
							method : 'GET',
						}, {

						}, {
							callbackHandler : function(data) {

								var account = data.data;
								$('#course-id').val(account.course.id);
								$('#course-name').val(account.course.name);
								$('#courseact-student').val(account.student);
								$('#courseact-courseNum')
										.val(account.courseNum);
								$('#courseact-courseRepnum').val(
										account.courseRepnum);
								$('#courseact-peoples').val(
										account.courseNum
												+ account.courseRepnum);
								$('#courseact-classHour')
										.val(account.classHour);
								$('#courseact-typeFactor').val(
										account.typeFactor);
								$('#courseact-repFactor')
										.val(account.repFactor);
								$('#courseact-workload').val(account.workload);
								$('#courseact-campus').val(account.campus);

							},
							exceptionHandler : function(XMLHttpRequest,
									textStatus, errorThrown) {
								alert('服务器忙!');
							}
						});
					});

}
//