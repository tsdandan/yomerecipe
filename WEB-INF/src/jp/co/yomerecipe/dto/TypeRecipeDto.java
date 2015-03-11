package jp.co.yomerecipe.dto;

import java.io.Serializable;

public class TypeRecipeDto extends BasicDto implements Serializable{



	/**
	 *
	 */
	private static final long serialVersionUID = -4977548251728423058L;

	public Long recipe_id;
	public Long Indicator_id;
	public int cooklevel;

	public TypeRecipeDto() {
	}



	/**
	 * @param created_id
	 * @param created_at
	 * @param updated_id
	 * @param updated_at
	 * @param is_deleted
	 * @param recipe_id
	 * @param indicator_id
	 * @param cooklevle
	 */
	public TypeRecipeDto( Long recipe_id,
			Long indicator_id, int cooklevel, int is_deleted,
			Long created_at, Long created_id, Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.recipe_id = recipe_id;
		Indicator_id = indicator_id;
		this.cooklevel = cooklevel;
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
	 * @return indicator_id
	 */
	public Long getIndicator_id() {
		return Indicator_id;
	}



	/**
	 * @param indicator_id セットする indicator_id
	 */
	public void setIndicator_id(Long indicator_id) {
		Indicator_id = indicator_id;
	}



	/**
	 * @return cooklevel
	 */
	public int getCooklevel() {
		return cooklevel;
	}



	/**
	 * @param cooklevel セットする cooklevel
	 */
	public void setCooklevel(int cooklevel) {
		this.cooklevel = cooklevel;
	}



	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((Indicator_id == null) ? 0 : Indicator_id.hashCode());
		result = prime * result + cooklevel;
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
		TypeRecipeDto other = (TypeRecipeDto) obj;
		if (Indicator_id == null) {
			if (other.Indicator_id != null)
				return false;
		} else if (!Indicator_id.equals(other.Indicator_id))
			return false;
		if (cooklevel != other.cooklevel)
			return false;
		if (recipe_id == null) {
			if (other.recipe_id != null)
				return false;
		} else if (!recipe_id.equals(other.recipe_id))
			return false;
		return true;
	}


}
