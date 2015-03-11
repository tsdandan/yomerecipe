package jp.co.yomerecipe.dto;

public class RecipeDto extends BasicDto {

	/**
	 *
	 */
	private static final long serialVersionUID = -2291281717517778517L;
	public Long id;
	public String name;
	public int step;
	public int cooklevel;
	public Double cooktime;
	public String description;
	public String img_url;

	public RecipeDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public RecipeDto(Long id, String name, int step, int cooklevel,
			Double cooktime, String description, int is_deleted,
			Long created_at, Long created_id, Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.id = id;
		this.name = name;
		this.step = step;
		this.cooklevel = cooklevel;
		this.cooktime = cooktime;
		this.description = description;
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
	 * @return step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step セットする step
	 */
	public void setStep(int step) {
		this.step = step;
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
	 * @return cooktime
	 */
	public Double getCooktime() {
		return cooktime;
	}

	/**
	 * @param cooktime セットする cooktime
	 */
	public void setCooktime(Double cooktime) {
		this.cooktime = cooktime;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return img_url
	 */
	public String getImg_url() {
		return img_url;
	}

	/**
	 * @param img_url セットする img_url
	 */
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cooklevel;
		result = prime * result
				+ ((cooktime == null) ? 0 : cooktime.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img_url == null) ? 0 : img_url.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + step;
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
		RecipeDto other = (RecipeDto) obj;
		if (cooklevel != other.cooklevel)
			return false;
		if (cooktime == null) {
			if (other.cooktime != null)
				return false;
		} else if (!cooktime.equals(other.cooktime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img_url == null) {
			if (other.img_url != null)
				return false;
		} else if (!img_url.equals(other.img_url))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (step != other.step)
			return false;
		return true;
	}

}
