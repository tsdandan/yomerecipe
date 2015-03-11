package jp.co.yomerecipe.dto;

public class QuestionDto extends BasicDto {


	/**
	 *
	 */
	private static final long serialVersionUID = -2613103262728310383L;

	public Long id;
	public String title;
	public int type;
	public String imgurl;

	public QuestionDto(){

	}

	/**
	 * @param is_deleted
	 * @param created_at
	 * @param created_id
	 * @param updated_at
	 * @param updated_id
	 * @param id
	 * @param title
	 * @param type
	 * @param imgurl
	 */
	public QuestionDto(Long id, String title, int type,
			String imgurl, int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super(is_deleted, created_at, created_id, updated_at, updated_id);
		this.id = id;
		this.title = title;
		this.type = type;
		this.imgurl = imgurl;
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
	 * @return title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return type
	 */
	public int getType() {
		return type;
	}



	/**
	 * @param type セットする type
	 */
	public void setType(int type) {
		this.type = type;
	}



	/**
	 * @return imgurl
	 */
	public String getImgurl() {
		return imgurl;
	}



	/**
	 * @param imgurl セットする imgurl
	 */
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + type;
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
		QuestionDto other = (QuestionDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgurl == null) {
			if (other.imgurl != null)
				return false;
		} else if (!imgurl.equals(other.imgurl))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}


}
