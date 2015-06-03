package dlnu.workload.module.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dlnu.workload.framework.controller.BaseController;
import dlnu.workload.framework.util.SemesterUtil;
import dlnu.workload.framework.util.parameter.ParameterCheck;
import dlnu.workload.module.common.model.Major;
import dlnu.workload.module.common.model.User;
import dlnu.workload.module.common.service.MajorService;
import dlnu.workload.module.practice.doc.CollegeGrdtdesignAccountExcelView;
import dlnu.workload.module.practice.doc.MajorGrdtdesignAccountExcelView;
import dlnu.workload.module.practice.doc.SingleGrdtdesignAccountExcelView;
import dlnu.workload.module.practice.model.GrdtdesignAccount;
import dlnu.workload.module.practice.model.GrdtdesignActTeacher;
import dlnu.workload.module.practice.service.GrdtdesignAccountService;
import dlnu.workload.module.practice.service.GrdtdesignActTeacherService;

@Controller
public class GrdtdesignAccountDocController extends BaseController {

	@Autowired
	private GrdtdesignAccountService grdtdesignAccountService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private GrdtdesignActTeacherService grdtdesignActTeacherService;

	@RequestMapping(value = "/user/{userId}/major/grdtdesignAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printMajorGrdtdesignAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		String majorId = this.getMajor().getId();
		GrdtdesignAccount grdtdesignAccount = new GrdtdesignAccount();
		grdtdesignAccount.setSemester(semester);

		model.put("semester", semester);
		model.put("grdtdesignAccounts", grdtdesignAccountService.findByMajor(
				majorId, grdtdesignAccount));
		Major major = majorService.get(this.getMajor());
		model.put("major", major.getName());

		MajorGrdtdesignAccountExcelView excelView = new MajorGrdtdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/college/grdtdesignAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printCollegeGrdtdesignAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		String collegeId = this.getCollege().getId();
		GrdtdesignAccount grdtdesignAccount = new GrdtdesignAccount();
		grdtdesignAccount.setSemester(semester);

		model.put("semester", semester);
		model.put("grdtdesignAccounts", grdtdesignAccountService.findByCollege(
				collegeId, grdtdesignAccount));

		CollegeGrdtdesignAccountExcelView excelView = new CollegeGrdtdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	@RequestMapping(value = "/user/{userId}/grdtdesignAccounts/excel", method = RequestMethod.GET)
	public ModelAndView printUserGrdtdesignAccount(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "semester", required = true) String semester,
			ModelMap model) {

		User user = this.getUser();

		model.put("semester", semester);
		model.put("grdtdesignAccounts",
				grdtdesignAccountService.findByUser(user, semester));

		SingleGrdtdesignAccountExcelView excelView = new SingleGrdtdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}

	/**
	 * 导出单个毕设的excel
	 * 
	 * @param grdtdesignAccountId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/{userId}/grdtdesignAccount/{grdtdesignAccountId}/excel", method = RequestMethod.GET)
	public ModelAndView printSingleGrdtdesignAccount(
			@PathVariable(value = "grdtdesignAccountId") String grdtdesignAccountId,
			ModelMap model) {

		if (!ParameterCheck.checkObjectId(grdtdesignAccountId)) {
			return new ModelAndView("error/404");
		}

		GrdtdesignAccount grdtdesignAccount = grdtdesignAccountService
				.get(new GrdtdesignAccount(grdtdesignAccountId));

		if (grdtdesignAccount == null) {
			return new ModelAndView("error/404");
		}

		List<GrdtdesignActTeacher> grdtdesignActTeachers = grdtdesignActTeacherService
				.findByGrdtdesignAccount(grdtdesignAccountId);

		grdtdesignActTeachers = grdtdesignActTeachers != null ? grdtdesignActTeachers
				: new ArrayList<GrdtdesignActTeacher>();
		grdtdesignAccount.setGrdtdesignActTeachers(grdtdesignActTeachers);

		model.put("semester",
				SemesterUtil.getSemesterString(grdtdesignAccount.getSemester()));
		model.put("grdtdesignAccount", grdtdesignAccount);

		SingleGrdtdesignAccountExcelView excelView = new SingleGrdtdesignAccountExcelView();

		return new ModelAndView(excelView, model);

	}
}
