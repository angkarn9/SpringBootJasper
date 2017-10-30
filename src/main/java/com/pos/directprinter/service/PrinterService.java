package com.pos.directprinter.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.pos.utils.jasper.JasperReportUtilsFactory;
import com.pos.utils.jasper.OtherUtils;

import bean.LTCardReportBean;
import constant.BpConstant;

public class PrinterService {

	private static ResourceBundle resConfig = null;
	private static ResourceBundle lTCardReportTextFile = null;
	
	public PrinterService() throws Exception {
//		FileInputStream fileConfilg = new FileInputStream("C:/images/BPClient/properties/config.properties");
//		resConfig = new PropertyResourceBundle(fileConfilg);
//		getClass().getResource("jsonschema.json").getFile()
	}

	public void execute(LTCardReportBean ltCardReportBean, String filename) throws Exception{
		Map<String, Object> parameters = null;
		List<LTCardReportBean> list = null;
		
		FileInputStream fileInout = null;
		String reportName = null;
		
		try{
			parameters = new HashMap<String, Object>();
			list = new ArrayList<LTCardReportBean>();
			fileInout = new FileInputStream("C:\\Users\\Angkarn\\workspaces\\directprinter\\src\\main\\resources\\04506011413191804021.txt");
			lTCardReportTextFile = new PropertyResourceBundle(fileInout);
			
			list.add(ltCardReportBean);
			reportName = "C:\\Users\\Angkarn\\workspaces\\directprinter\\src\\main\\resources\\jasper\\LTCARD01Report.jasper";
			
			parameters.put("picSymbolSrc", "C:\\Users\\Angkarn\\workspaces\\directprinter\\src\\main\\resources\\jasper\\symbol.png");
			JasperReportUtilsFactory.executeExportToPrinter(list, parameters, reportName); 
		}catch (Exception exception) {
			throw exception;
		}finally {
			fileInout.close();
		}
	}
	
	public LTCardReportBean setTextFileToBean(String filename) throws Exception {
		LTCardReportBean ltCardReportBean = null;
		FileInputStream fileInout = null;
		try{
			fileInout = new FileInputStream("C:\\Users\\Angkarn\\workspaces\\directprinter\\src\\main\\resources\\04506011413191804021.txt");
			lTCardReportTextFile = new PropertyResourceBundle(fileInout);
			
			ltCardReportBean = new LTCardReportBean();
			ltCardReportBean.setDeptenm(lTCardReportTextFile.getString(BpConstant.DEPTENM));
			ltCardReportBean.setDepttnm(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.DEPTTNM)).toString());
			ltCardReportBean.setTelno(lTCardReportTextFile.getString(BpConstant.TELNO));
			ltCardReportBean.setUrl(lTCardReportTextFile.getString(BpConstant.URL));
			ltCardReportBean.setBprole(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.BPROLE)).toString());
			ltCardReportBean.setBpcd(lTCardReportTextFile.getString(BpConstant.BPCD));
			ltCardReportBean.setEfamilynm(lTCardReportTextFile.getString(BpConstant.EFAMILYNM));
			ltCardReportBean.setEfirstnm(lTCardReportTextFile.getString(BpConstant.EFIRSTNM));
			ltCardReportBean.setTfamilynm(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.TFAMILYNM)).toString());
			ltCardReportBean.setTfirstnm(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.TFIRSTNM)).toString());
			ltCardReportBean.setNationenm(lTCardReportTextFile.getString(BpConstant.NATIONENM));
			ltCardReportBean.setNationtnm(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.NATIONTNM)).toString());
			ltCardReportBean.setSex(lTCardReportTextFile.getString(BpConstant.SEX));
			ltCardReportBean.setBirthdte(lTCardReportTextFile.getString(BpConstant.BIRTHDTE));
			ltCardReportBean.setIsucarddteEn(lTCardReportTextFile.getString(BpConstant.ISUCARDDTEEN));
			ltCardReportBean.setExpcarddteEn(lTCardReportTextFile.getString(BpConstant.EXPCARDDTEEN));
			ltCardReportBean.setIsucarddteTh(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.ISUCARDDTETH)).toString());
			ltCardReportBean.setExpcarddteTh(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.EXPCARDDTETH)).toString());
			ltCardReportBean.setAge(lTCardReportTextFile.getString(BpConstant.AGE));
			ltCardReportBean.setHeight(lTCardReportTextFile.getString(BpConstant.HEIGHT));
			
			try{
				BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\Angkarn\\workspaces\\directprinter\\src\\main\\resources\\04506011413191804021.jpg"));	 
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write( originalImage, "jpg", baos );
				baos.flush();
				byte[] imgbpByte = baos.toByteArray();
				ImageIcon imageIcon = new ImageIcon(imgbpByte);
				ltCardReportBean.setImgbp(imageIcon.getImage());
				
				baos.close();
			}catch(IOException e){
				throw e;
			}
			
			ltCardReportBean.setMrzRow1(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.MRZROW1)).toString());
			ltCardReportBean.setMrzRow2(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.MRZROW2)).toString());
			ltCardReportBean.setMrzRow3(OtherUtils.encodeStringToUTF8(lTCardReportTextFile.getString(BpConstant.MRZROW3)).toString());
			
			fileInout.close();
			return ltCardReportBean;
		}catch (Exception e) {
			throw e;
		}
	}
	
}
