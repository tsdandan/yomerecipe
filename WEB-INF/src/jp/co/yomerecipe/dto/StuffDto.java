package jp.co.yomerecipe.dto;

public class StuffDto extends BasicDto {

	/**
	 *
	 */
	private static final long serialVersionUID = -4179922917512531640L;
	public Long id;
	public Long recipe_id;
	public String name;
	public String amount;


	public StuffDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param created_id
	 * @param created_at
	 * @param updated_id
	 * @param updated_at
	 * @param is_deleted
	 * @param id
	 * @param recipe_id
	 * @param name
	 * @param amount
	 */
	public StuffDto(Long id, Long recipe_id, String name, String amount,
			int is_deleted,	Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.id = id;
		this.recipe_id = recipe_id;
		this.name = name;
		this.amount = amount;
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return recipe_id
	 */
	public Long getRecipe_id() {
		return recipe_id;
	}

	/**
	 * @param recipe_id セットする recipe_id
	 */
	public void setRecipe_id(Long recipe_id) {
		this.recipe_id = recipe_id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount セットする amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((recipe_id == null) ? 0 : recipe_id.hashCode());
		return result;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StuffDto other = (StuffDto) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipe_id == null) {
			if (other.recipe_id != null)
				return false;
		} else if (!recipe_id.equals(other.recipe_id))
			return false;
		return true;
	}

}
