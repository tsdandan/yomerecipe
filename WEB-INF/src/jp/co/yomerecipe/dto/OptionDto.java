package jp.co.yomerecipe.dto;

public class OptionDto extends BasicDto {

	/**
	 *
	 */
	private static final long serialVersionUID = 8235987501634323582L;

	public Long id;
	public Long question_id;
	public String content;
	public int is_correct;

	public OptionDto(){

	}

	public OptionDto(Long id, Long question_id, String content, int is_correct,
			int is_deleted,	Long created_at, Long created_id, Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.id = id;
		this.question_id = question_id;
		this.content = content;
		this.is_correct = is_correct;
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
	 * @return content
	 */
	public String getContent() {
		return content;
	}



	/**
	 * @param content セットする content
	 */
	public void setContent(String content) {
		this.content = content;
	}



	/**
	 * @return is_correct
	 */
	public int getIs_correct() {
		return is_correct;
	}



	/**
	 * @param is_correct セットする is_correct
	 */
	public void setIs_correct(int is_correct) {
		this.is_correct = is_correct;
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + is_correct;
		result = prime * result
				+ ((question_id == null) ? 0 : question_id.hashCode());
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
		OptionDto other = (OptionDto) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_correct != other.is_correct)
			return false;
		if (question_id == null) {
			if (other.question_id != null)
				return false;
		} else if (!question_id.equals(other.question_id))
			return false;
		return true;
	}


}
