package com.pos.utils.jasper;

import java.io.UnsupportedEncodingException;

public class OtherUtils {
	public static final String BLANK = "";

	public static String reValueNull(String txtValue) {

		if (txtValue == null) {
			txtValue = BLANK;
		}
		if ("null".equals(txtValue)) {
			txtValue = BLANK;
		}

		return txtValue;
	}

	public static Object encodeStringToUTF8(final String value) {
		if (value == null || "".equals(value))
			return "";
		try {
			return new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			throw new RuntimeException("Encoding not supported", e);
		}
	}
}
