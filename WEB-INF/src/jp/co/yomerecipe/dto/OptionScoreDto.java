package jp.co.yomerecipe.dto;

public class OptionScoreDto extends BasicDto {


	/**
	 *
	 */
	private static final long serialVersionUID = -3837195218512758597L;

	public Long option_id;
	public Long indicator_id;
	public int score_right;

	public OptionScoreDto() {
	}



	/**
	 * @param is_deleted
	 * @param created_at
	 * @param created_id
	 * @param updated_at
	 * @param updated_id
	 * @param option_id
	 * @param indicator_id
	 * @param score_right
	 */
	public OptionScoreDto(Long option_id, Long indicator_id, int score_right,
			int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.option_id = option_id;
		this.indicator_id = indicator_id;
		this.score_right = score_right;
	}



	public OptionScoreDto(int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
	}



	/**
	 * @return option_id
	 */
	public Long getOption_id() {
		return option_id;
	}



	/**
	 * @param option_id セットする option_id
	 */
	public void setOption_id(Long option_id) {
		this.option_id = option_id;
	}



	/**
	 * @return indicator_id
	 */
	public Long getIndicator_id() {
		return indicator_id;
	}



	/**
	 * @param indicator_id セットする indicator_id
	 */
	public void setIndicator_id(Long indicator_id) {
		this.indicator_id = indicator_id;
	}



	/**
	 * @return score_right
	 */
	public int getScore_right() {
		return score_right;
	}



	/**
	 * @param score_right セットする score_right
	 */
	public void setScore_right(int score_right) {
		this.score_right = score_right;
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
				+ ((indicator_id == null) ? 0 : indicator_id.hashCode());
		result = prime * result
				+ ((option_id == null) ? 0 : option_id.hashCode());
		result = prime * result + score_right;
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
		OptionScoreDto other = (OptionScoreDto) obj;
		if (indicator_id == null) {
			if (other.indicator_id != null)
				return false;
		} else if (!indicator_id.equals(other.indicator_id))
			return false;
		if (option_id == null) {
			if (other.option_id != null)
				return false;
		} else if (!option_id.equals(other.option_id))
			return false;
		if (score_right != other.score_right)
			return false;
		return true;
	}



}
