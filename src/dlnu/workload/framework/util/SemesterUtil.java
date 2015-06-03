package dlnu.workload.framework.util;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemesterUtil {

	/**
	 * 生成当前学期字符串工具(日期格式的字符串)
	 * 
	 * @return
	 */
	public static String getSemester() {

		Calendar calendar = Calendar.getInstance();

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);

		if (month > 1 && month < 8) {
			return year + "-02-01";
		} else {
			return year + "-08-01";
		}
	}

	/**
	 * 获取学期的名称
	 * 
	 * @param semester
	 * @return
	 */
	public static String getSemesterString(String semester) {

		String year = semester.substring(0, 4);
		if (semester.indexOf("02-01") != -1) {
			year += "春季期";
		} else {
			year += "秋季期";
		}

		return year;
	}

	public static boolean isSemester(String semester) {

		if (semester == null || semester.length() != 10) {
			return false;
		}

		Pattern pattern = Pattern.compile("^((?:19|20)\\d\\d)-(02|08)-(01)$");
		Matcher matcher = pattern.matcher(semester);

		if (matcher.matches()) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {

		System.out.println(SemesterUtil.isSemester("2011-02-01"));

	}
}
