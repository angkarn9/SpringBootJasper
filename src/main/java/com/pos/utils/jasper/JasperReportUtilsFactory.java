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
	public static JasperReport getReportByName(String reportName) throws Exception{
		JasperReport report = null;
//		resConfig = new PropertyResourceBundle(new FileInputStream("C:/images/BPClient/properties/config.properties"));
//		final String jasperUrl = resConfig.getString("pathfile")+"\\BPClient\\jasper\\"+reportName;
//
//		if(!GenericValidator.isBlankOrNull(jasperUrl)){
			report = (JasperReport)JRLoader.loadObject(new File(reportName));
//		}else{
//			logger.error("Error null jasperUrlReport ");
//		}
		return report;
	}
	
	public static JRPrintServiceExporter getJRPrintServiceExporter() throws Exception {
		final JRPrintServiceExporter jasperExporter = new JRPrintServiceExporter();
		/*final Map<Object, Object> fontMap = new HashMap<Object, Object>();
		
        fontMap.put(new FontKey("TH SarabunPSK", false, false), new PdfFont(resConfig.getString("pathfile")+"\\BPClient\\fonts\\THSarabun.ttf", BaseFont.IDENTITY_H, true));
        fontMap.put(new FontKey("TH SarabunPSK", true, false), new PdfFont(resConfig.getString("pathfile")+"\\BPClient\\fonts\\THSarabun_b.ttf", BaseFont.IDENTITY_H, true));
        fontMap.put(new FontKey("TH SarabunPSK", true, false), new PdfFont(resConfig.getString("pathfile")+"\\BPClient\\fonts\\THSarabun_i.ttf", BaseFont.IDENTITY_H, true));
        fontMap.put(new FontKey("TH SarabunPSK", true, false), new PdfFont(resConfig.getString("pathfile")+"\\BPClient\\fonts\\THSarabun_bi.ttf", BaseFont.IDENTITY_H, true));
		
        jasperExporter.setParameter(JRPrintServiceExporterParameter.FONT_MAP, fontMap);*/
		
		return jasperExporter;
	}
	
	public static void executeExportToPrinter(JasperPrint jasperPrint, String reportName) throws Exception {
		PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		JRPrintServiceExporter exporter = getJRPrintServiceExporter();
		exporter.setParameter(JRPrintServiceExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, service.getAttributes());
	    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
	    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
//	    exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(10));//6.55 //6 
		
	    exporter.exportReport();
	    
	    
//	    JRDocxExporter exporter = new JRDocxExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("C:\\test.docx"));
//        exporter.exportReport();
	    logger.info("Export Success..");
	}
	
	public static void executeExportToPrinter(List<?> list, Map<String, Object> parameters, String reportName) throws Exception {
		JasperReport report = null;
		if(!GenericValidator.isBlankOrNull(reportName)){
			report = getReportByName(reportName);
			executeExportToPrinter(JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(list)), reportName);
		}
	}
	
}
