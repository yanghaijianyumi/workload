package dlnu.workload.module.practice.controller;

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
import dlnu.workload.module.practice.doc.CollegeProjectAccountExcelView;
import dlnu.workload.module.practice.doc.MajorProjectAccountExcelView;
import dlnu.workload.module.practice.doc.UserProjectAccountExcelView;
import dlnu.workload.module.practice.model.ProjectAccount;
import dlnu.workload.module.practice.service.ProjectAccountService;

@Controller
public class ProjectAccountDocController extends BaseController {

	@Autowired
	private ProjectAccountService projectAccountSevice;
	@Autowired
	private UserService userService;
	@Autowired
	private MajorService majorSerice;
	@Autowired
	private CollegeService collegeSerice;

	@RequestMapping(value = "/user/{userId}/college/projectAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printCollegeCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		if (!SemesterUtil.isSemester(semester)) {
			return new ModelAndView("error/404");
		}

		ProjectAccount projectAccount = new ProjectAccount();
		projectAccount.setSemester(semester);

		College college = collegeSerice.get(this.getCollege());
		model.put("college", college);
		model.put("semester", SemesterUtil.getSemesterString(semester));

		List<ProjectAccount> projectAccounts = projectAccountSevice
				.findByCollege(this.getCollege().getId(), projectAccount);
		projectAccounts = projectAccounts != null ? projectAccounts
				: new ArrayList<ProjectAccount>();
		model.put("projectAccounts", projectAccounts);

		CollegeProjectAccountExcelView excelView = new CollegeProjectAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/major/projectAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printMajorCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		if (!SemesterUtil.isSemester(semester)) {
			return new ModelAndView("error/404");
		}

		ProjectAccount projectAccount = new ProjectAccount();
		projectAccount.setSemester(semester);

		Major major = majorSerice.get(this.getMajor());
		model.put("major", major);
		model.put("semester", SemesterUtil.getSemesterString(semester));

		List<ProjectAccount> projectAccounts = projectAccountSevice
				.findByMajor(this.getMajor().getId(), projectAccount);
		projectAccounts = projectAccounts != null ? projectAccounts
				: new ArrayList<ProjectAccount>();
		model.put("projectAccounts", projectAccounts);

		MajorProjectAccountExcelView excelView = new MajorProjectAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/projectAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printUserCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		if (!SemesterUtil.isSemester(semester)) {
			return new ModelAndView("error/404");
		}

		User user = userService.get(this.getUser());
		model.put("user", user);
		model.put("semester", semester);
		List<ProjectAccount> projectAccounts = projectAccountSevice.findByUser(
				user, semester);
		projectAccounts = projectAccounts != null ? projectAccounts
				: new ArrayList<ProjectAccount>();
		model.put("projectAccounts", projectAccounts);

		UserProjectAccountExcelView excelView = new UserProjectAccountExcelView();

		return new ModelAndView(excelView, model);

	}

}
