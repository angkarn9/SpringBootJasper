package com.pos.directprinter.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pos.directprinter.model.Slip;
import com.pos.utils.jasper.JasperReportUtilsFactory;

public class PrinterService {

	public void execute(List<Slip> slips, File reportFile) throws Exception{
		Map<String, Object> parameters = null;
		try{
			parameters = new HashMap<String, Object>();
			parameters.put("p_title", slips.get(0).getTitle());
			JasperReportUtilsFactory.executeExportToPrinter(slips, parameters, reportFile); 
		}catch (Exception exception) {
			
			throw exception;
		}
	}
}
