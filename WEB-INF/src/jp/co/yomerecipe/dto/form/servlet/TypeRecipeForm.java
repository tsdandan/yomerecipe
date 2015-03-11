package jp.co.yomerecipe.dto.form.servlet;

public class TypeRecipeForm {

	public Long recipe_id;
	public Long indicator_id;
	public int cooklevel;
	public int is_deleted;
	public Long created_at;
	public Long created_id;
	public Long updated_at;
	public Long updated_id;
	/**
	 * @param recipe_id
	 * @param indicator_id
	 * @param cooklevel
	 * @param is_deleted
	 * @param created_at
	 * @param created_id
	 * @param updated_at
	 * @param updated_id
	 */
	public TypeRecipeForm(Long recipe_id, Long indicator_id, int cooklevel,
			int is_deleted, Long created_at, Long created_id, Long updated_at,
			Long updated_id) {
		super();
		this.recipe_id = recipe_id;
		this.indicator_id = indicator_id;
		this.cooklevel = cooklevel;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.created_id = created_id;
		this.updated_at = updated_at;
		this.updated_id = updated_id;
	}


}
