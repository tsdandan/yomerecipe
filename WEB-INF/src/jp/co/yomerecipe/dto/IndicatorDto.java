package jp.co.yomerecipe.dto;

public class IndicatorDto extends BasicDto{
	/**
	 *
	 */
	private static final long serialVersionUID = 2496478804900560453L;
	public Long id;
	public String name;
	public int type_classify;

	public IndicatorDto(){
	}

	/**
	 * @param created_id
	 * @param created_at
	 * @param updated_id
	 * @param updated_at
	 * @param is_deleted
	 * @param id
	 * @param name
	 * @param type_classify
	 */
	public IndicatorDto(Long id, String name, int type_classify, int is_deleted,
			Long created_at, Long created_id, Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.id = id;
		this.name = name;
		this.type_classify = type_classify;
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
	 * @return type_classify
	 */
	public int getType_classify() {
		return type_classify;
	}
	/**
	 * @param type_classify セットする type_classify
	 */
	public void setType_classify(int type_classify) {
		this.type_classify = type_classify;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + type_classify;
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
		IndicatorDto other = (IndicatorDto) obj;
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
		if (type_classify != other.type_classify)
			return false;
		return true;
	}
}
