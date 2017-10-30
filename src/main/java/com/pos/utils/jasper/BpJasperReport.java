package com.pos.utils.jasper;



public class BpJasperReport extends JasperReportUtilsFactory {
	private static final BpJasperReport instance = new BpJasperReport();
	
	//ชื่อไฟล์ของ jasper
	public static final String bpcardReport = "bpcardReport.jasper";
	public static final String bpinoutReport = "bpinoutReport.jasper";
	public static final String LTCARD01Report = "LTCARD01Report.jasper";
	public static final String LTCARD02Report = "LTCARD02Report.jasper";
	public static final String LTCARD03Report = "LTCARD03Report.jasper";
	
	private BpJasperReport() {
		
	}
	
	public static BpJasperReport getInstance() {
		return instance;
	}
	
}
