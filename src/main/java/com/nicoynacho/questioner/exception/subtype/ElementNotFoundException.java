package com.nicoynacho.questioner.exception.subtype;

import com.nicoynacho.questioner.exception.QuestionerPapaException;

public class ElementNotFoundException extends QuestionerPapaException {

	private static final long serialVersionUID = 1L;
	
	private static final int HTTP_CODE = 404;

	public ElementNotFoundException(String message) {
		super(HTTP_CODE, message);
	}

}
