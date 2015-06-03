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

import dlnu.workload.module.common.model.User;
import dlnu.workload.module.practice.model.ProjectAccount;

public class UserProjectAccountExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<ProjectAccount> projectAccounts = (List<ProjectAccount>) model
				.get("projectAccounts");
		User user = (User) model.get("user");

		// 1.生成工作簿
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("个人大创项目申报表");
		sheet.setDefaultColumnWidth(16);
		sheet.setDefaultRowHeightInPoints(24);
		int index = 0;// 整个sheet的行数纪录
		// CellStyle dateStyle = getDataFormatStyle(workbook);
		// 1.主题
		HSSFRow subjectRow = sheet.createRow(index++);
		CellStyle subjectStyle = getSubjectStyle(workbook);
		CellRangeAddress subCra = new CellRangeAddress(0, 0, 0, 7);// 主题合并
		sheet.addMergedRegion(subCra);
		Cell c_sj_1 = subjectRow.createCell(0);
		c_sj_1.setCellValue("年度“大创计划”第二批结题项目指导教师工作量汇总表");
		c_sj_1.setCellStyle(subjectStyle);
		// 2.题目
		HSSFRow titleRow = sheet.createRow(index++);
		CellStyle titleStyle = getTitleStyle(workbook);
		Cell c_t_teacher_0 = titleRow.createCell(0);
		c_t_teacher_0.setCellValue("教师姓名：");
		c_t_teacher_0.setCellStyle(titleStyle);
		Cell c_t_teacher_1 = titleRow.createCell(1);
		c_t_teacher_1.setCellValue(user.getName());
		c_t_teacher_1.setCellStyle(titleStyle);
		CellRangeAddress c_t_Cra = new CellRangeAddress(index - 1, index - 1,
				2, 3);// 主题合并
		sheet.addMergedRegion(c_t_Cra);
		Cell c_t_name_0 = titleRow.createCell(2);
		c_t_name_0.setCellValue("学院（公章）：");
		c_t_name_0.setCellStyle(titleStyle);

		// 2.内容头部
		// 2.sheet头部
		HSSFRow _headerRow = sheet.createRow(index++);
		CellStyle _headerStyle = getHeaderStyle(workbook);
		CellRangeAddress _c_h_orderCra = new CellRangeAddress(index - 1, index,
				0, 0);// 合并
		sheet.addMergedRegion(_c_h_orderCra);
		Cell _c_h_order = _headerRow.createCell(0);
		_c_h_order.setCellValue("序号");
		_c_h_order.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_teacherCra = new CellRangeAddress(index - 1,
				index, 1, 1);// 合并
		sheet.addMergedRegion(_c_h_teacherCra);
		Cell _c_h__c_h_teacherCra = _headerRow.createCell(1);
		_c_h__c_h_teacherCra.setCellValue("指导教师姓名");
		_c_h__c_h_teacherCra.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_singleCra = new CellRangeAddress(index - 1,
				index - 1, 2, 3);// 合并
		sheet.addMergedRegion(_c_h_singleCra);
		Cell _c_h_single = _headerRow.createCell(2);
		_c_h_single.setCellValue("单独指导项目");
		_c_h_single.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_multipleCra = new CellRangeAddress(index - 1,
				index - 1, 4, 6);// 合并
		sheet.addMergedRegion(_c_h_multipleCra);
		Cell _c_h_multiple = _headerRow.createCell(4);
		_c_h_multiple.setCellValue("2人（含）以上共同指导项目");
		_c_h_multiple.setCellStyle(_headerStyle);

		CellRangeAddress _c_h_workloadCra = new CellRangeAddress(index - 1,
				index, 7, 7);// 合并
		sheet.addMergedRegion(_c_h_workloadCra);
		Cell _c_h_workload = _headerRow.createCell(7);
		_c_h_workload.setCellValue("总工作量");
		_c_h_workload.setCellStyle(_headerStyle);
		//
		HSSFRow headerRow = sheet.createRow(index++);
		CellStyle headerStyle = getHeaderStyle(workbook);
		Cell c_h_spcode = headerRow.createCell(2);
		c_h_spcode.setCellValue("项目编号");
		c_h_spcode.setCellStyle(headerStyle);
		Cell c_h_pworkload = headerRow.createCell(3);
		c_h_pworkload.setCellValue("工作量");
		c_h_pworkload.setCellStyle(headerStyle);

		Cell c_h_mpcode = headerRow.createCell(4);
		c_h_mpcode.setCellValue("项目编号");
		c_h_mpcode.setCellStyle(headerStyle);
		Cell c_h_mworkload = headerRow.createCell(5);
		c_h_mworkload.setCellValue("工作量");
		c_h_mworkload.setCellStyle(headerStyle);
		Cell c_h_rmworkload = headerRow.createCell(6);
		c_h_rmworkload.setCellValue("实际分得工作量");
		c_h_rmworkload.setCellStyle(headerStyle);
		// 内容
		int a_index = 0;
		int a_order = 1;
		Iterator<ProjectAccount> it_pa = projectAccounts.iterator();
		while (it_pa.hasNext()) {
			a_index = 0;
			ProjectAccount projectAccount = it_pa.next();
			HSSFRow row_a = sheet.createRow(index++);
			CellStyle row_a_Style = getCommonStyle(workbook);

			Cell c_a_order = row_a.createCell(a_index++);
			c_a_order.setCellValue(a_order++);
			c_a_order.setCellStyle(row_a_Style);

			Cell c_a_teacher = row_a.createCell(a_index++);
			c_a_teacher.setCellValue(projectAccount.getCreator().getName());
			c_a_teacher.setCellStyle(row_a_Style);

			Cell c_a_spcode = row_a.createCell(a_index++);
			c_a_spcode.setCellValue(projectAccount.getSpcode());
			c_a_spcode.setCellStyle(row_a_Style);
			Cell c_a_sworkload = row_a.createCell(a_index++);
			c_a_sworkload.setCellValue(projectAccount.getSworkload());
			c_a_sworkload.setCellStyle(row_a_Style);

			Cell c_a_mpcode = row_a.createCell(a_index++);
			c_a_mpcode.setCellValue(projectAccount.getMpcode());
			c_a_mpcode.setCellStyle(row_a_Style);
			Cell c_a_mworkload = row_a.createCell(a_index++);
			c_a_mworkload.setCellValue(projectAccount.getMworkload());
			c_a_mworkload.setCellStyle(row_a_Style);
			Cell c_a_mrworkload = row_a.createCell(a_index++);
			c_a_mrworkload.setCellValue(projectAccount.getSworkload()
					+ projectAccount.getMrworkload());
			c_a_mrworkload.setCellStyle(row_a_Style);

			Cell c_a_workload = row_a.createCell(a_index++);
			c_a_workload.setCellValue(projectAccount.getMworkload());
			c_a_workload.setCellStyle(row_a_Style);
		}

		// 底部
		index++;
		int f_index = index + 1;
		HSSFRow footerRow = sheet.createRow(f_index);
		CellStyle footerStyle = getFooterStyle(workbook);
		CellRangeAddress c_f_titlera = new CellRangeAddress(f_index, f_index,
				0, 7);// 合并
		sheet.addMergedRegion(c_f_titlera);
		Cell c_f_1 = footerRow.createCell(0);
		c_f_1.setCellValue("填表人签字：               联系电话：                   教学院长签字：");
		c_f_1.setCellStyle(footerStyle);
		//
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
