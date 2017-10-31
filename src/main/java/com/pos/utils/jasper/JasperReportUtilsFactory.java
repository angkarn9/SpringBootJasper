package com.pos.utils.jasper;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperReportUtilsFactory {
	private static ResourceBundle resConfig = null;
	private final static Logger logger = Logger.getLogger(JasperReportUtilsFactory.class);
	
//	static {
//		try {
//			resConfig = new PropertyResourceBundle(new FileInputStream("C:/images/BPClient/properties/config.properties"));
//		} 
//		catch (FileNotFoundException e) {} 
//		catch (IOException e) {}
//	}
//	
	public static JasperReport getReportByName(File reportFile) throws Exception{
		JasperReport report = null;
//		resConfig = new PropertyResourceBundle(new FileInputStream("C:/images/BPClient/properties/config.properties"));
//		final String jasperUrl = resConfig.getString("pathfile")+"\\BPClient\\jasper\\"+reportName;
//
//		if(!GenericValidator.isBlankOrNull(jasperUrl)){
			report = (JasperReport)JRLoader.loadObject(reportFile);
//		}else{
//			logger.error("Error null jasperUrlReport ");
//		}
		return report;
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
