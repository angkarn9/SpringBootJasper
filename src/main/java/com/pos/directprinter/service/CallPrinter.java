package com.pos.directprinter.service;

import bean.LTCardReportBean;

public class CallPrinter {

	public static void printSlip(String data) throws Exception{
		try{			
			String fileName = "04506011413191804021";
			
			PrinterService service = new PrinterService();
			LTCardReportBean ltCardReportBean = service.setTextFileToBean(fileName);
			System.out.println(ltCardReportBean);
			if(ltCardReportBean!=null){
				service.execute(ltCardReportBean, fileName);
			}
		}catch (Exception e) {
			throw e;
		}
	}
}
