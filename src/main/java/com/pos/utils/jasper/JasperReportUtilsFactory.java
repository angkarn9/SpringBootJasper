package com.pos.utils.jasper;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperReportUtilsFactory {
	public static JasperReport getReportByName(File reportFile) throws Exception{
		return (JasperReport)JRLoader.loadObject(reportFile);
	}
	
	public static JRPrintServiceExporter getJRPrintServiceExporter() throws Exception {
		final JRPrintServiceExporter jasperExporter = new JRPrintServiceExporter();
		return jasperExporter;
	}
	
	public static void executeExportToPrinter(JasperPrint jasperPrint) throws Exception {
		PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		JRPrintServiceExporter exporter = getJRPrintServiceExporter();
		exporter.setParameter(JRPrintServiceExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, service.getAttributes());
	    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
	    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
	    exporter.exportReport();
	}
	
	public static void executeExportToPrinter(List<?> list, Map<String, Object> parameters, File reportFile) throws Exception {
		JasperReport report = null;
		if(reportFile!=null){
			report = getReportByName(reportFile);
			executeExportToPrinter(JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(list)));
		}
	}
	
}
