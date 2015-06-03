package dlnu.workload.module.teacher.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import dlnu.workload.module.practice.model.CdesignAccount;

public class Test {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos;

		fos = new FileOutputStream("E:\\test.xls");

		HSSFWorkbook workbook = new HSSFWorkbook();

		// 1.生成工作簿
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("大创项目申报表");
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
		c_sj_1.setCellValue("大连民族学院2014---2015学年第二学期");
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
		c_a_grade.setCellValue("专业年级");
		c_a_grade.setCellStyle(a_style);
		Cell c_a_classNum = a_row.createCell(a_index++);
		c_a_classNum.setCellValue("班级数");
		c_a_classNum.setCellStyle(a_style);
		Cell c_a_stuNum = a_row.createCell(a_index++);
		c_a_stuNum.setCellValue("学生人数");
		c_a_stuNum.setCellStyle(a_style);
		Cell c_a_weeks = a_row.createCell(a_index++);
		c_a_weeks.setCellValue("计划周数");
		c_a_weeks.setCellStyle(a_style);
		Cell c_a_factor = a_row.createCell(a_index++);
		c_a_factor.setCellValue("系 数");
		c_a_factor.setCellStyle(a_style);
		Cell c_a_workload = a_row.createCell(a_index++);
		c_a_workload.setCellValue("标准工作量");
		c_a_workload.setCellStyle(a_style);
		Cell c_a_period = a_row.createCell(a_index++);
		c_a_period.setCellValue("金石滩校区计划学时");
		c_a_period.setCellStyle(a_style);
		Cell c_a_remark = a_row.createCell(a_index++);
		c_a_remark.setCellValue("备  注");
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
		c_at_f_workload.setCellValue("100");
		c_at_f_workload.setCellStyle(at_f_style);
		Cell c_at_f_period = at_f_row.createCell(3);
		c_at_f_period.setCellValue("200");
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

		//
		workbook.write(fos);
		fos.close();

	}

	// 头部样式
	private static CellStyle getCommonStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 10);// 设置字体大小
		font.setFontName("宋体");
		style.setFont(font);

		return style;
	}

	// 头部样式
	private static CellStyle getFooterStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 14);// 设置字体大小

		style.setFont(font);

		return style;
	}

	// 头部样式
	private static CellStyle getHeaderStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 10);// 设置字体大小

		style.setFont(font);

		return style;
	}

	// 主题样式
	private static CellStyle getSubjectStyle(HSSFWorkbook workbook) {

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
	private static CellStyle getTitleStyle(HSSFWorkbook workbook) {

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
