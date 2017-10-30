package com.pos.utils.jasper;

import java.io.Serializable;

public class GenericValidator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5751397309060633864L;

	public static boolean isBlankOrNull(String value) {
		return (value == null) || (value.trim().length() == 0);
	}
}