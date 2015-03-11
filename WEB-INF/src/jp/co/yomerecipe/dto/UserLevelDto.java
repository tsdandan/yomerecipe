package jp.co.yomerecipe.dto;

import java.util.Date;

public class UserLevelDto extends BasicDto {

	/**
	 *
	 */
	private static final long serialVersionUID = -6332982594188066140L;
	public Long user_id;
	public Long indicator_id;
	public int cooklevel;
	public int score;


	public UserLevelDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserLevelDto(Long user_id, Long indicator_id,
			int cooklevel, int score) {
		this.user_id = user_id;
		this.indicator_id = indicator_id;
		this.cooklevel = cooklevel;
		this.score = score;
		this.created_at = new Date().getTime();
		this.updated_at = new Date().getTime();
		this.created_id = user_id;
		this.updated_id = user_id;
		this.is_deleted = 0;
	}

	/**
	 * @param created_id
	 * @param created_at
	 * @param updated_id
	 * @param updated_at
	 * @param is_deleted
	 * @param user_id
	 * @param indicator_id
	 * @param cooklevel
	 * @param score
	 */
	public UserLevelDto(Long user_id, Long indicator_id,
			int cooklevel, int score, int is_deleted,
			Long created_at, Long created_id, Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.user_id = user_id;
		this.indicator_id = indicator_id;
		this.cooklevel = cooklevel;
		this.score = score;
	}

	/**
	 * @return user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score セットする score
	 */
	public void setScore(int score) {
		this.score = score;
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
				+ ((indicator_id == null) ? 0 : indicator_id.hashCode());
		result = prime * result + score;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		UserLevelDto other = (UserLevelDto) obj;
		if (cooklevel != other.cooklevel)
			return false;
		if (indicator_id == null) {
			if (other.indicator_id != null)
				return false;
		} else if (!indicator_id.equals(other.indicator_id))
			return false;
		if (score != other.score)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

}
