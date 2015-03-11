package jp.co.yomerecipe.dto.form.servlet;

public class StepForm {

	public Long id;
	public Long recipe_id;
	public String name;
	public String detail;
	public String img_url;
	public int is_deleted;
	public Long created_at;
	public Long created_id;
	public Long updated_at;
	public Long updated_id;
	/**
	 * @param id
	 * @param recipe_id
	 * @param name
	 * @param detail
	 * @param img_url
	 * @param is_deleted
	 * @param created_at
	 * @param created_id
	 * @param updated_at
	 * @param updated_id
	 */
	public StepForm(Long id, Long recipe_id, String name, String detail,
			String img_url, int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super();
		this.id = id;
		this.recipe_id = recipe_id;
		this.name = name;
		this.detail = detail;
		this.img_url = img_url;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.created_id = created_id;
		this.updated_at = updated_at;
		this.updated_id = updated_id;
	}



}
