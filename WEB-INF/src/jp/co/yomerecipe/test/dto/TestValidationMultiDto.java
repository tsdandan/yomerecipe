package jp.co.yomerecipe.test.dto;

import yang.framework.annotation.Validate;

public class TestValidationMultiDto {

	@Validate(propertyName="Name",method="Required")
	public String name;

	//@Validate(propertyName="ID",method="Required")
	//public Long id;

}
