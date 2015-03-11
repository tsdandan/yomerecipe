package jp.co.yomerecipe.dto;

public class UserRecipeDto extends BasicDto{

	/**
	 *
	 */
	private static final long serialVersionUID = -4338980534772018680L;
	public Long user_id;
	public Long recipe_id;
	public Long last_feedback;
	public int fbcounts;
	public int feedback;

	public UserRecipeDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * @param created_id
	 * @param created_at
	 * @param updated_id
	 * @param updated_at
	 * @param is_deleted
	 * @param user_id
	 * @param recipe_id
	 * @param last_feedback
	 * @param fbcounts
	 * @param feedback
	 */
	public UserRecipeDto(Long user_id, long recipe_id,
			Long last_feedback, int fbcounts, int feedback,
			int is_deleted,
			Long created_at, Long created_id, Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.user_id = user_id;
		this.recipe_id = recipe_id;
		this.last_feedback = last_feedback;
		this.fbcounts = fbcounts;
		this.feedback = feedback;
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
	 * @return recipe_id
	 */
	public long getRecipe_id() {
		return recipe_id;
	}

	/**
	 * @param recipe_id セットする recipe_id
	 */
	public void setRecipe_id(long recipe_id) {
		this.recipe_id = recipe_id;
	}

	/**
	 * @return last_feedback
	 */
	public Long getLast_feedback() {
		return last_feedback;
	}

	/**
	 * @param last_feedback セットする last_feedback
	 */
	public void setLast_feedback(Long last_feedback) {
		this.last_feedback = last_feedback;
	}

	/**
	 * @return fbcounts
	 */
	public int getFbcounts() {
		return fbcounts;
	}

	/**
	 * @param fbcounts セットする fbcounts
	 */
	public void setFbcounts(int fbcounts) {
		this.fbcounts = fbcounts;
	}

	/**
	 * @return feedback
	 */
	public int getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback セットする feedback
	 */
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + fbcounts;
		result = prime * result + feedback;
		result = prime * result
				+ ((last_feedback == null) ? 0 : last_feedback.hashCode());
		result = prime * result + (int) (recipe_id ^ (recipe_id >>> 32));
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
		UserRecipeDto other = (UserRecipeDto) obj;
		if (fbcounts != other.fbcounts)
			return false;
		if (feedback != other.feedback)
			return false;
		if (last_feedback == null) {
			if (other.last_feedback != null)
				return false;
		} else if (!last_feedback.equals(other.last_feedback))
			return false;
		if (recipe_id != other.recipe_id)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

}
