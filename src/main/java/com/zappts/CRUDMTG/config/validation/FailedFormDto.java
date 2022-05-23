package com.zappts.CRUDMTG.config.validation;

public class FailedFormDto {

	private String field;
	private String erro;

	public FailedFormDto(String field, String erro) {
		this.field = field;
		this.erro = erro;
	}
	public String getField() {
		return field;
	}
	public String getErro() {
		return erro;
	}
	
}
