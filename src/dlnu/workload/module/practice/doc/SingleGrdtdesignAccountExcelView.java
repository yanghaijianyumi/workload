package dlnu.workload.module.practice.doc;

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

import dlnu.workload.module.practice.model.GrdtdesignAccount;
import dlnu.workload.module.practice.model.GrdtdesignActTeacher;

public class SingleGrdtdesignAccountExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String semester = (String) model.get("semester");
		GrdtdesignAccount grdtdesignAccount = (GrdtdesignAccount) model
				.get("grdtdesignAccount");

		// 1.生成工作簿
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("单个毕业论文工作量申报表");
		sheet.setDefaultColumnWidth(16);
		sheet.setDefaultRowHeightInPoints(28);
		int index = 0;// 整个sheet的行数纪录
		// CellStyle dateStyle = getDataFormatStyle(workbook);
		// 1.主题
		HSSFRow subjectRow = sheet.createRow(index++);
		CellStyle subjectStyle = getSubjectStyle(workbook);
		CellRangeAddress subCra = new CellRangeAddress(0, 0, 0, 7);// 主题合并
		sheet.addMergedRegion(subCra);
		Cell c_sj_1 = subjectRow.createCell(0);
		c_sj_1.setCellValue("大连民族大学" + semester);
		c_sj_1.setCellStyle(subjectStyle);
		// 2.题目
		HSSFRow titleRow = sheet.createRow(index++);
		CellStyle titleStyle = getTitleStyle(workbook);
		CellRangeAddress c_t_Cra = new CellRangeAddress(index - 1, index - 1,
				0, 7);// 主题合并
		sheet.addMergedRegion(c_t_Cra);
		Cell c_t_name_0 = titleRow.createCell(0);
		c_t_name_0.setCellValue("教师指导毕业论文教学工作量核算表");
		c_t_name_0.setCellStyle(titleStyle);

		HSSFRow a_h_row = sheet.createRow(index++);
		CellStyle a_h_style = getCommonStyle(workbook);
		CellRangeAddress a_t_name_Cra = new CellRangeAddress(index - 1,
				index - 1, 0, 2);// 主题合并
		sheet.addMergedRegion(a_t_name_Cra);
		Cell c_a_h_name = a_h_row.createCell(0);
		c_a_h_name.setCellValue("毕业论文（设计）工作量核算表");
		c_a_h_name.setCellStyle(a_h_style);
		// 内容
		int a_index = 0;
		HSSFRow a_t_row = sheet.createRow(index++);
		CellStyle a_t_style = getCommonStyle(workbook);
		Cell c_a_t_grade = a_t_row.createCell(a_index++);
		c_a_t_grade.setCellValue("专业年级");
		c_a_t_grade.setCellStyle(a_t_style);
		Cell c_a_t_classNum = a_t_row.createCell(a_index++);
		c_a_t_classNum.setCellValue("班级数");
		c_a_t_classNum.setCellStyle(a_t_style);
		Cell c_a_t_stuNum = a_t_row.createCell(a_index++);
		c_a_t_stuNum.setCellValue("学生人数");
		c_a_t_stuNum.setCellStyle(a_t_style);
		Cell c_a_t_weeks = a_t_row.createCell(a_index++);
		c_a_t_weeks.setCellValue("计划周数");
		c_a_t_weeks.setCellStyle(a_t_style);
		Cell c_a_t_factor = a_t_row.createCell(a_index++);
		c_a_t_factor.setCellValue("系 数");
		c_a_t_factor.setCellStyle(a_t_style);
		Cell c_a_t_workload = a_t_row.createCell(a_index++);
		c_a_t_workload.setCellValue("标准工作量");
		c_a_t_workload.setCellStyle(a_t_style);
		Cell c_a_t_period = a_t_row.createCell(a_index++);
		c_a_t_period.setCellValue("金石滩校区计划学时");
		c_a_t_period.setCellStyle(a_t_style);
		Cell c_a_t_remark = a_t_row.createCell(a_index++);
		c_a_t_remark.setCellValue("备  注");
		c_a_t_remark.setCellStyle(a_t_style);
		//
		a_index = 0;
		HSSFRow a_row = sheet.createRow(index++);
		CellStyle a_style = getCommonStyle(workbook);
		Cell c_a_grade = a_row.createCell(a_index++);
		c_a_grade.setCellValue(grdtdesignAccount.getMajor().getName()
				+ grdtdesignAccount.getGrade());
		c_a_grade.setCellStyle(a_style);
		Cell c_a_classNum = a_row.createCell(a_index++);
		c_a_classNum.setCellValue(grdtdesignAccount.getClassNum());
		c_a_classNum.setCellStyle(a_style);
		Cell c_a_stuNum = a_row.createCell(a_index++);
		c_a_stuNum.setCellValue(grdtdesignAccount.getStuNum());
		c_a_stuNum.setCellStyle(a_style);
		Cell c_a_weeks = a_row.createCell(a_index++);
		c_a_weeks.setCellValue(grdtdesignAccount.getWeekNum());
		c_a_weeks.setCellStyle(a_style);
		Cell c_a_factor = a_row.createCell(a_index++);
		c_a_factor.setCellValue(grdtdesignAccount.getFactor());
		c_a_factor.setCellStyle(a_style);
		Cell c_a_workload = a_row.createCell(a_index++);
		c_a_workload.setCellValue(grdtdesignAccount.getWorkload());
		c_a_workload.setCellStyle(a_style);
		Cell c_a_period = a_row.createCell(a_index++);
		c_a_period.setCellValue(grdtdesignAccount.getPeriod());
		c_a_period.setCellStyle(a_style);
		Cell c_a_remark = a_row.createCell(a_index++);
		c_a_remark.setCellValue(grdtdesignAccount.getRemark());
		c_a_remark.setCellStyle(a_style);

		// 工作量分配
		a_index = 0;
		HSSFRow at_h_row = sheet.createRow(index++);
		CellStyle at_h_style = getCommonStyle(workbook);
		CellRangeAddress at_h_Cra = new CellRangeAddress(index - 1, index - 1,
				0, 1);// 主题合并
		sheet.addMergedRegion(at_h_Cra);
		Cell c_at_h_0 = at_h_row.createCell(a_index++);
		c_at_h_0.setCellValue("工作量分配情况如下：");
		c_at_h_0.setCellStyle(at_h_style);
		//
		int at_order = 1;
		a_index = 0;
		HSSFRow at_t_row = sheet.createRow(index++);
		CellStyle at_t_style = getCommonStyle(workbook);
		Cell c_at_t_order = at_t_row.createCell(a_index++);
		c_at_t_order.setCellValue("序号");
		c_at_t_order.setCellStyle(at_t_style);
		Cell c_at_t_teacher = at_t_row.createCell(a_index++);
		c_at_t_teacher.setCellValue("教师姓名");
		c_at_t_teacher.setCellStyle(at_t_style);
		Cell c_at_t_workload = at_t_row.createCell(a_index++);
		c_at_t_workload.setCellValue("工作量");
		c_at_t_workload.setCellStyle(at_t_style);
		Cell c_at_t_period = at_t_row.createCell(a_index++);
		c_at_t_period.setCellValue("金石滩校区计划学时");
		c_at_t_period.setCellStyle(at_t_style);
		CellRangeAddress at_t_Cra = new CellRangeAddress(index - 1, index - 1,
				4, 7);// 主题合并
		sheet.addMergedRegion(at_t_Cra);
		Cell c_at_t_remark = at_t_row.createCell(a_index++);
		c_at_t_remark.setCellValue("备             注");
		c_at_t_remark.setCellStyle(at_t_style);

		List<GrdtdesignActTeacher> grdtdesignActTeachers = grdtdesignAccount
				.getGrdtdesignActTeachers();
		Iterator<GrdtdesignActTeacher> it_ta = grdtdesignActTeachers.iterator();
		double t_workload = 0.0;
		double t_period = 0.0;
		
		while (it_ta.hasNext()) {
			GrdtdesignActTeacher grdtdesignActTeacher = it_ta.next();
			t_workload += grdtdesignActTeacher.getWorkload();
			t_period += grdtdesignActTeacher.getPeriod();
			a_index = 0;
			HSSFRow at_row = sheet.createRow(index++);
			CellStyle at_style = getCommonStyle(workbook);

			Cell c_at_order = at_row.createCell(a_index++);
			c_at_order.setCellValue(at_order++);
			c_at_order.setCellStyle(at_style);
			Cell c_at_teacher = at_row.createCell(a_index++);
			c_at_teacher.setCellValue(grdtdesignActTeacher.getTeacher()
					.getName());
			c_at_teacher.setCellStyle(at_style);
			Cell c_at_workload = at_row.createCell(a_index++);
			c_at_workload.setCellValue(grdtdesignActTeacher.getWorkload());
			c_at_workload.setCellStyle(at_style);
			Cell c_at_period = at_row.createCell(a_index++);
			c_at_period.setCellValue(grdtdesignActTeacher.getPeriod());
			c_at_period.setCellStyle(at_style);
			CellRangeAddress at_Cra = new CellRangeAddress(index - 1,
					index - 1, 4, 7);
			sheet.addMergedRegion(at_Cra);
			Cell c_at_remark = at_row.createCell(a_index++);
			c_at_remark.setCellValue(grdtdesignActTeacher.getRemark());
			c_at_remark.setCellStyle(at_style);
		}
		// 工作量分配底部
		HSSFRow at_f_row = sheet.createRow(index++);
		CellStyle at_f_style = getCommonStyle(workbook);
		CellRangeAddress at_f_Cra = new CellRangeAddress(index - 1, index - 1,
				0, 1);// 主题合并
		sheet.addMergedRegion(at_f_Cra);
		Cell c_at_f_total = at_f_row.createCell(0);
		c_at_f_total.setCellValue("工作量总计");
		c_at_f_total.setCellStyle(at_f_style);
		Cell c_at_f_workload = at_f_row.createCell(2);
		c_at_f_workload.setCellValue(t_workload);
		c_at_f_workload.setCellStyle(at_f_style);
		Cell c_at_f_period = at_f_row.createCell(3);
		c_at_f_period.setCellValue(t_period);
		c_at_f_period.setCellStyle(at_f_style);
		//
		index++;
		int f_index = index + 1;
		HSSFRow footerRow = sheet.createRow(f_index);
		CellStyle footerStyle = getFooterStyle(workbook);
		CellRangeAddress c_f_titlera = new CellRangeAddress(f_index, f_index,
				0, 6);// 合并
		sheet.addMergedRegion(c_f_titlera);
		Cell c_f_1 = footerRow.createCell(0);
		c_f_1.setCellValue("制表人:	             制表时间：		负责人：	            公章");
		c_f_1.setCellStyle(footerStyle);

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
	private CellStyle getFooterStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 14);// 设置字体大小

		style.setFont(font);

		return style;
	}

	// 头部样式
	private CellStyle getHeaderStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 10);// 设置字体大小

		style.setFont(font);

		return style;
	}

	// 主题样式
	private CellStyle getSubjectStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setBold(true);
		font.setFontHeightInPoints((short) 18);// 设置字体大小

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
		font.setFontHeightInPoints((short) 14);// 设置字体大小

		style.setFont(font);

		return style;
	}

}
