package jp.co.yomerecipe.dto.form.servlet;

import yang.framework.annotation.Validate;

public class RecipeDetailForm {

	@Validate(method="Required")
	public Long user_id;

	@Validate(method="Required")
	public Long recipe_id;

}
