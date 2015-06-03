package dlnu.workload.module.theoryteaching.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dlnu.workload.framework.controller.BaseController;
import dlnu.workload.framework.util.SemesterUtil;
import dlnu.workload.module.common.model.College;
import dlnu.workload.module.common.model.Major;
import dlnu.workload.module.common.model.User;
import dlnu.workload.module.common.service.CollegeService;
import dlnu.workload.module.common.service.MajorService;
import dlnu.workload.module.common.service.UserService;
import dlnu.workload.module.theoryteaching.doc.CollegeCourseAccountExcelView;
import dlnu.workload.module.theoryteaching.doc.MajorCourseAccountExcelView;
import dlnu.workload.module.theoryteaching.doc.UserCourseAccountExcelView;
import dlnu.workload.module.theoryteaching.model.CourseAccount;
import dlnu.workload.module.theoryteaching.service.CourseAccountService;

@Controller
public class CourseAccountDocController extends BaseController {

	@Autowired
	private CourseAccountService courseAccountService;
	@Autowired
	private CollegeService collegeService = null;
	@Autowired
	private UserService userSerice;
	@Autowired
	private MajorService majorSerice;
	@Autowired
	private CollegeService collegeSerice;

	@RequestMapping(value = "/user/{userId}/college/courseAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printCollegeCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		if (!SemesterUtil.isSemester(semester)) {
			return new ModelAndView("error/404");
		}

		CourseAccount courseAccount = new CourseAccount();
		courseAccount.setSemester(semester);

		model.put("courseAccounts", courseAccountService.findByCollege(this
				.getCollege().getId(), courseAccount));
		model.put("semester", semester);
		College college = collegeService.get(this.getCollege());
		model.put("college", college);

		CollegeCourseAccountExcelView excelView = new CollegeCourseAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/major/courseAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printMajorCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		if (!SemesterUtil.isSemester(semester)) {
			return new ModelAndView("error/404");
		}

		CourseAccount courseAccount = new CourseAccount();
		courseAccount.setSemester(semester);

		User user = userSerice.get(this.getUser());
		College college = user.getCollege();
		Major major = user.getMajor();
		model.put("user", user);
		model.put("college", college);
		model.put("major", major);
		model.put("semester", SemesterUtil.getSemesterString(semester));

		List<CourseAccount> courseAccounts = courseAccountService.findByMajor(
				this.getMajor().getId(), courseAccount);
		courseAccounts = courseAccounts != null ? courseAccounts
				: new ArrayList<CourseAccount>();
		model.put("courseAccounts", courseAccounts);

		MajorCourseAccountExcelView excelView = new MajorCourseAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/courseAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printUserCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		if (!SemesterUtil.isSemester(semester)) {
			return new ModelAndView("error/404");
		}

		User user = userSerice.get(this.getUser());
		College college = user.getCollege();
		Major major = user.getMajor();
		model.put("user", user);
		model.put("college", college);
		model.put("major", major);
		model.put("semester", SemesterUtil.getSemesterString(semester));

		List<CourseAccount> courseAccounts = courseAccountService.findByUser(
				this.getUser(), semester);
		courseAccounts = courseAccounts != null ? courseAccounts
				: new ArrayList<CourseAccount>();
		model.put("courseAccounts", courseAccounts);

		UserCourseAccountExcelView excelView = new UserCourseAccountExcelView();

		return new ModelAndView(excelView, model);

	}

}
