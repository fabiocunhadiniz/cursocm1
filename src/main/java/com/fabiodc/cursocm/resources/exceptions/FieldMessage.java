package com.fabiodc.cursocm.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	  
	  private static final long serialVersionUID= 1L;

	  private String fieldName;
	  private String messagem;
	  
	  public FieldMessage() {
		  
	  }
	  
	  public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.messagem = message;
	}



	  public String getFieldName() {
		  return fieldName;
	  }

	  public void setFieldName(String fieldName) {
		  this.fieldName = fieldName;
	  }

	  public String getMessage() {
		  return messagem;
	  }

	  public void setMessage(String messagem) {
		  this.messagem = messagem;
	  }
	  
}
