package dlnu.workload.module.theoryteaching.doc;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import dlnu.workload.module.common.model.College;
import dlnu.workload.module.common.model.Major;
import dlnu.workload.module.theoryteaching.model.CourseAccount;

/**
 * 专业的理论工作量导出
 * 
 * @author weber
 *
 */
public class MajorCourseAccountExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String semester = (String) model.get("semester");
		College college = (College) model.get("college");
		Major major = (Major) model.get("major");
		List<CourseAccount> courseAccounts = (List<CourseAccount>) model
				.get("courseAccounts");

		// 1.生成工作簿
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("理论课程申报表");
		sheet.setDefaultColumnWidth(12);
		sheet.setDefaultRowHeightInPoints(24);
		int index = 0;// 整个sheet的行数纪录
		// CellStyle dateStyle = getDataFormatStyle(workbook);

		// 1.主题
		HSSFRow subjectRow = sheet.createRow(index++);
		CellStyle subjectStyle = getSubjectStyle(workbook);
		CellRangeAddress subCra = new CellRangeAddress(0, 0, 0, 10);// 主题合并
		sheet.addMergedRegion(subCra);
		Cell c_sj_1 = subjectRow.createCell(0);
		c_sj_1.setCellValue("大连民族大学 " + semester + " 理论教学工作量核算表");
		c_sj_1.setCellStyle(subjectStyle);
		// 2.题目getTitleStyle

		HSSFRow titleRow = sheet.createRow(index++);
		CellStyle titleStyle = getTitleStyle(workbook);
		Cell c_t_name_0 = titleRow.createCell(0);
		c_t_name_0.setCellValue("专业：");
		c_t_name_0.setCellStyle(titleStyle);
		CellRangeAddress c_t_majorCra = new CellRangeAddress(index - 1,
				index - 1, 1, 2);// 合并
		sheet.addMergedRegion(c_t_majorCra);
		Cell c_t_name_1 = titleRow.createCell(1);
		c_t_name_1.setCellValue(major.getName());
		c_t_name_1.setCellStyle(titleStyle);

		Cell c_t_title_5 = titleRow.createCell(3);
		c_t_title_5.setCellValue("开课学院:");
		c_t_title_5.setCellStyle(titleStyle);
		CellRangeAddress c_t_clgCra = new CellRangeAddress(index - 1,
				index - 1, 4, 5);// 合并
		sheet.addMergedRegion(c_t_clgCra);
		Cell c_t_title_6 = titleRow.createCell(4);
		c_t_title_6.setCellValue(college.getName());
		c_t_title_6.setCellStyle(titleStyle);
		// 2.内容头部
		// 2.sheet头部
		int c_index = 0;
		HSSFRow _headerRow = sheet.createRow(index++);
		CellStyle _headerStyle = getHeaderStyle(workbook);

		CellRangeAddress _c_h_teacherCra = new CellRangeAddress(index - 1,
				index, 0, 0);// 合并
		sheet.addMergedRegion(_c_h_teacherCra);
		Cell _c_h_teacher = _headerRow.createCell(0);
		_c_h_teacher.setCellValue("授课教师");
		_c_h_teacher.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_courseNameCra = new CellRangeAddress(index - 1,
				index, 1, 1);// 合并
		sheet.addMergedRegion(_c_h_courseNameCra);
		Cell _c_h_courseName = _headerRow.createCell(1);
		_c_h_courseName.setCellValue("课程名称");
		_c_h_courseName.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_studentCra = new CellRangeAddress(index - 1,
				index, 2, 2);// 合并
		sheet.addMergedRegion(_c_h_studentCra);
		Cell _c_h_student = _headerRow.createCell(2);
		_c_h_student.setCellValue("授课对象");
		_c_h_student.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_courseNumCra = new CellRangeAddress(index - 1,
				index - 1, 3, 5);// 合并
		sheet.addMergedRegion(_c_h_courseNumCra);
		Cell _c_h_courseNum = _headerRow.createCell(3);
		_c_h_courseNum.setCellValue("修课学生人数");
		_c_h_courseNum.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_classHourCra = new CellRangeAddress(index - 1,
				index, 6, 6);// 合并
		sheet.addMergedRegion(_c_h_classHourCra);
		Cell _c_h_classHour = _headerRow.createCell(6);
		_c_h_classHour.setCellValue("计划学时");
		_c_h_classHour.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_workloadCra = new CellRangeAddress(index - 1,
				index - 1, 7, 9);// 合并
		sheet.addMergedRegion(_c_h_workloadCra);
		Cell _c_h_workload = _headerRow.createCell(7);
		_c_h_workload.setCellValue("工作量核算");
		_c_h_workload.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_campusCra = new CellRangeAddress(index - 1,
				index, 10, 10);// 合并
		sheet.addMergedRegion(_c_h_campusCra);
		Cell _c_h_campus = _headerRow.createCell(10);
		_c_h_campus.setCellValue("授课校区");
		_c_h_campus.setCellStyle(_headerStyle);

		//

		HSSFRow headerRow = sheet.createRow(index++);
		CellStyle headerStyle = getHeaderStyle(workbook);

		Cell c_h_courseNum = headerRow.createCell(3);
		c_h_courseNum.setCellValue("正常选课人数");
		c_h_courseNum.setCellStyle(headerStyle);
		Cell c_h_courseRepnum = headerRow.createCell(4);
		c_h_courseRepnum.setCellValue("重修人数");
		c_h_courseRepnum.setCellStyle(headerStyle);
		Cell c_h_stuNums = headerRow.createCell(5);
		c_h_stuNums.setCellValue("总人数");
		c_h_stuNums.setCellStyle(headerStyle);

		Cell c_h_typeFactor = headerRow.createCell(7);
		c_h_typeFactor.setCellValue("课程类型系数");
		c_h_typeFactor.setCellStyle(headerStyle);
		Cell c_h_repFactor = headerRow.createCell(8);
		c_h_repFactor.setCellValue("重复课系数");
		c_h_repFactor.setCellStyle(headerStyle);
		Cell c_h_workload = headerRow.createCell(9);
		c_h_workload.setCellValue("工作量");
		c_h_workload.setCellStyle(headerStyle);
		// 2.1写入内容头部
		Integer t_stuNums = 0;
		double t_period = 0.0;
		double t_workload = 0.0;
		Iterator<CourseAccount> it_a = courseAccounts.iterator();
		while (it_a.hasNext()) {
			c_index = 0;
			CourseAccount courseAccount = it_a.next();
			t_stuNums += courseAccount.getCourseNum()
					+ courseAccount.getCourseRepnum();
			t_period += courseAccount.getClassHour();
			t_workload += courseAccount.getWorkload();
			HSSFRow row_a = sheet.createRow(index++);
			CellStyle row_a_Style = getCommonStyle(workbook);

			Cell c_a_teacher = row_a.createCell(c_index++);
			c_a_teacher.setCellValue(courseAccount.getTeacher().getName());
			c_a_teacher.setCellStyle(row_a_Style);
			Cell c_a_course = row_a.createCell(c_index++);
			c_a_course.setCellValue(courseAccount.getCourse().getName());
			c_a_course.setCellStyle(row_a_Style);
			Cell c_a_student = row_a.createCell(c_index++);
			c_a_student.setCellValue(courseAccount.getStudent());
			c_a_student.setCellStyle(row_a_Style);
			Cell c_a_courseNum = row_a.createCell(c_index++);
			c_a_courseNum.setCellValue(courseAccount.getCourseNum());
			c_a_courseNum.setCellStyle(row_a_Style);
			Cell c_a_courseRepnum = row_a.createCell(c_index++);
			c_a_courseRepnum.setCellValue(courseAccount.getCourseRepnum());
			c_a_courseRepnum.setCellStyle(row_a_Style);
			Cell c_a_stuNums = row_a.createCell(c_index++);
			c_a_stuNums.setCellValue(courseAccount.getCourseNum()
					+ courseAccount.getCourseRepnum());
			c_a_stuNums.setCellStyle(headerStyle);
			Cell c_a_classHour = row_a.createCell(c_index++);
			c_a_classHour.setCellValue(courseAccount.getClassHour());
			c_a_classHour.setCellStyle(row_a_Style);
			Cell c_a_typeFactor = row_a.createCell(c_index++);
			c_a_typeFactor.setCellValue(courseAccount.getTypeFactor());
			c_a_typeFactor.setCellStyle(row_a_Style);
			Cell c_a_repFactor = row_a.createCell(c_index++);
			c_a_repFactor.setCellValue(courseAccount.getRepFactor());
			c_a_repFactor.setCellStyle(row_a_Style);
			Cell c_a_workload = row_a.createCell(c_index++);
			c_a_workload.setCellValue(courseAccount.getWorkload());
			c_a_workload.setCellStyle(row_a_Style);
			Cell c_a_campus = row_a.createCell(c_index++);
			c_a_campus.setCellValue(courseAccount.getCampus());
			c_a_campus.setCellStyle(row_a_Style);

		}
		//
		c_index = 0;
		HSSFRow a_f_row = sheet.createRow(index++);
		CellStyle a_f_Style = getHeaderStyle(workbook);
		Cell c_a_f_total = a_f_row.createCell(0);
		c_a_f_total.setCellValue("总计");
		c_a_f_total.setCellStyle(a_f_Style);
		Cell c_a_f_stuNum = a_f_row.createCell(5);
		c_a_f_stuNum.setCellValue(t_stuNums);
		c_a_f_stuNum.setCellStyle(a_f_Style);
		Cell c_a_f_workload = a_f_row.createCell(6);
		c_a_f_workload.setCellValue(t_period);
		c_a_f_workload.setCellStyle(a_f_Style);
		Cell c_a_f_period = a_f_row.createCell(9);
		c_a_f_period.setCellValue(t_workload);
		c_a_f_period.setCellStyle(a_f_Style);
		//
		index++;
		int f_index = index + 1;
		HSSFRow footerRow = sheet.createRow(f_index);
		CellStyle footerStyle = getHeaderStyle(workbook);
		CellRangeAddress c_f_titlera = new CellRangeAddress(f_index, f_index,
				0, 10);// 合并
		sheet.addMergedRegion(c_f_titlera);
		Cell c_f_1 = footerRow.createCell(0);
		c_f_1.setCellValue("填报人:                 填报日期:                  负责人:    ");
		c_f_1.setCellStyle(footerStyle);

		//
		// 3.写入页脚
		// 5.返回客户端
		// 设置下载时客户端Excel的名称
		String filename = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				+ ".xls";
		// 处理中文文件名
		// filename = MyUtils.encodeFilename(filename, request);
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename="
				+ filename);
		OutputStream ouputStream = response.getOutputStream();
		workbook.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();

	}

	// 头部样式
	private CellStyle getCommonStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 10);// 设置字体大小
		font.setFontName("宋体");
		style.setFont(font);

		return style;
	}

	// 头部样式
	private CellStyle getHeaderStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 9);// 设置字体大小

		style.setFont(font);

		return style;
	}

	// 主题样式
	private CellStyle getSubjectStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 16);// 设置字体大小

		style.setFont(font);

		return style;
	}

	// 主题样式
	private CellStyle getTitleStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setBold(true);
		font.setFontHeightInPoints((short) 10);// 设置字体大小

		style.setFont(font);

		return style;
	}

}
