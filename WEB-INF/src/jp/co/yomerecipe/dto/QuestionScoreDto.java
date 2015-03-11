package jp.co.yomerecipe.dto;

public class QuestionScoreDto extends BasicDto {


	/**
	 *
	 */
	private static final long serialVersionUID = 1329822488480768825L;

	public Long question_id;
	public Long indicator_id;
	public int score_right;
	public int score_wrong;

	public QuestionScoreDto() {
	}



	/**
	 * @param is_deleted
	 * @param created_at
	 * @param created_id
	 * @param updated_at
	 * @param updated_id
	 * @param question_id
	 * @param indicator_id
	 * @param score_right
	 * @param score_wrong
	 */
	public QuestionScoreDto(Long question_id,	Long indicator_id, int score_right,
			int score_wrong, int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.question_id = question_id;
		this.indicator_id = indicator_id;
		this.score_right = score_right;
		this.score_wrong = score_wrong;
	}



	public QuestionScoreDto(int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
	}



	/**
	 * @return question_id
	 */
	public Long getQuestion_id() {
		return question_id;
	}



	/**
	 * @param question_id セットする question_id
	 */
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
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
	 * @return score_wrong
	 */
	public int getScore_wrong() {
		return score_wrong;
	}



	/**
	 * @param score_wrong セットする score_wrong
	 */
	public void setScore_wrong(int score_wrong) {
		this.score_wrong = score_wrong;
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
				+ ((question_id == null) ? 0 : question_id.hashCode());
		result = prime * result + score_right;
		result = prime * result + score_wrong;
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
		QuestionScoreDto other = (QuestionScoreDto) obj;
		if (indicator_id == null) {
			if (other.indicator_id != null)
				return false;
		} else if (!indicator_id.equals(other.indicator_id))
			return false;
		if (question_id == null) {
			if (other.question_id != null)
				return false;
		} else if (!question_id.equals(other.question_id))
			return false;
		if (score_right != other.score_right)
			return false;
		if (score_wrong != other.score_wrong)
			return false;
		return true;
	}

}
