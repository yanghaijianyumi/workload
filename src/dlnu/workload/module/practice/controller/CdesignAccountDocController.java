package dlnu.workload.module.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dlnu.workload.framework.controller.BaseController;
import dlnu.workload.module.common.model.College;
import dlnu.workload.module.common.model.User;
import dlnu.workload.module.common.service.CollegeService;
import dlnu.workload.module.practice.doc.CollegeCdesignAccountExcelView;
import dlnu.workload.module.practice.doc.MajorCdesignAccountExcelView;
import dlnu.workload.module.practice.doc.UserCdesignAccountExcelView;
import dlnu.workload.module.practice.model.CdesignAccount;
import dlnu.workload.module.practice.service.CdesignAccountService;
import dlnu.workload.module.theoryteaching.model.CourseAccount;

@Controller
public class CdesignAccountDocController extends BaseController {

	@Autowired
	private CdesignAccountService cdesignAccountService;
	@Autowired
	private CollegeService collegeService;

	@RequestMapping(value = "/user/{userId}/major/cdesignAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printMajorCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		String majorId = this.getMajor().getId();

		model.put("semester", semester);
		model.put("cdesignAccounts",
				cdesignAccountService.findMajorCourseAccount(semester, majorId));
		College college = collegeService.get(this.getCollege());
		model.put("college", college.getName());

		MajorCdesignAccountExcelView excelView = new MajorCdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/college/cdesignAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printCollegeCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		String collegeId = this.getCollege().getId();
		CdesignAccount cdesignAccount = new CdesignAccount();
		cdesignAccount.setSemester(semester);

		model.put("semester", semester);
		model.put("cdesignAccounts",
				cdesignAccountService.findByCollege(collegeId, cdesignAccount));

		College college = collegeService.get(this.getCollege());
		model.put("college", college.getName());

		CollegeCdesignAccountExcelView excelView = new CollegeCdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/cdesignAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printUserCourseAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		User user = this.getUser();

		model.put("semester", semester);
		model.put("cdesignAccounts",
				cdesignAccountService.findByUser(user, semester));

		College college = collegeService.get(this.getCollege());
		model.put("college", college.getName());

		UserCdesignAccountExcelView excelView = new UserCdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}

}
