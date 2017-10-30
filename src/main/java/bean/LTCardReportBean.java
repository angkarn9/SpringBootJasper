package bean;

import java.awt.Image;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LTCardReportBean {
	private String bpcd;
	private String efamilynm;
	private String efirstnm;
	private String tfamilynm;
	private String tfirstnm;
	private String nationenm;
	private String nationtnm;
	private String sex;
	private String birthdte;
	private String age;
	private String height;
	private Image imgbp;
	private byte[] imgbpByte;
	private String isucarddteEn;
	private String expcarddteEn;
	private String isucarddteTh;
	private String expcarddteTh;
	private String deptenm;
	private String depttnm;
	private String telno;
	private String url;
	private String bprole;
	private String mrzRow1;
	private String mrzRow2;
	private String mrzRow3;
	
	public String getBpcd() {
		return bpcd;
	}
	public void setBpcd(String bpcd) {
		this.bpcd = bpcd;
	}
	public String getEfamilynm() {
		return efamilynm;
	}
	public void setEfamilynm(String efamilynm) {
		this.efamilynm = efamilynm;
	}
	public String getEfirstnm() {
		return efirstnm;
	}
	public void setEfirstnm(String efirstnm) {
		this.efirstnm = efirstnm;
	}
	public String getTfamilynm() {
		return tfamilynm;
	}
	public void setTfamilynm(String tfamilynm) {
		this.tfamilynm = tfamilynm;
	}
	public String getTfirstnm() {
		return tfirstnm;
	}
	public void setTfirstnm(String tfirstnm) {
		this.tfirstnm = tfirstnm;
	}
	public String getNationenm() {
		return nationenm;
	}
	public void setNationenm(String nationenm) {
		this.nationenm = nationenm;
	}
	public String getNationtnm() {
		return nationtnm;
	}
	public void setNationtnm(String nationtnm) {
		this.nationtnm = nationtnm;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthdte() {
		return birthdte;
	}
	public void setBirthdte(String birthdte) {
		this.birthdte = birthdte;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Image getImgbp() {
		return imgbp;
	}
	public void setImgbp(Image imgbp) {
		this.imgbp = imgbp;
	}
	public String getIsucarddteEn() {
		return isucarddteEn;
	}
	public void setIsucarddteEn(String isucarddteEn) {
		this.isucarddteEn = isucarddteEn;
	}
	public String getExpcarddteEn() {
		return expcarddteEn;
	}
	public void setExpcarddteEn(String expcarddteEn) {
		this.expcarddteEn = expcarddteEn;
	}
	public String getIsucarddteTh() {
		return isucarddteTh;
	}
	public void setIsucarddteTh(String isucarddteTh) {
		this.isucarddteTh = isucarddteTh;
	}
	public String getExpcarddteTh() {
		return expcarddteTh;
	}
	public void setExpcarddteTh(String expcarddteTh) {
		this.expcarddteTh = expcarddteTh;
	}
	public String getDeptenm() {
		return deptenm;
	}
	public void setDeptenm(String deptenm) {
		this.deptenm = deptenm;
	}
	public String getDepttnm() {
		return depttnm;
	}
	public void setDepttnm(String depttnm) {
		this.depttnm = depttnm;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getMrzRow1() {
		return mrzRow1;
	}
	public void setMrzRow1(String mrzRow1) {
		this.mrzRow1 = mrzRow1;
	}
	public String getMrzRow2() {
		return mrzRow2;
	}
	public void setMrzRow2(String mrzRow2) {
		this.mrzRow2 = mrzRow2;
	}
	public String getMrzRow3() {
		return mrzRow3;
	}
	public void setMrzRow3(String mrzRow3) {
		this.mrzRow3 = mrzRow3;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBprole() {
		return bprole;
	}
	public void setBprole(String bprole) {
		this.bprole = bprole;
	}
	public byte[] getImgbpByte() {
		return imgbpByte;
	}
	public void setImgbpByte(byte[] imgbpByte) {
		this.imgbpByte = imgbpByte;
	}
	
	@Override
	public String toString() {
		Map<String, Object> map = null;
		try{
			map = new HashMap<String, Object>();
			for (Field f : getClass().getDeclaredFields()) {
				map.put(f.getName(), f.get(this));
			}
		}catch(Exception e){
			map = new HashMap<String, Object>();
		}
		return map.toString();
	}
}
