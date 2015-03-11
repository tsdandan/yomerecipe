package jp.co.yomerecipe.dto;

import java.io.Serializable;

public class BasicDto implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 3610680036293790784L;
	public int is_deleted;
	public Long created_at;
	public Long created_id;
	public Long updated_at;
	public Long updated_id;

	public BasicDto(){

	}
	/**
	 * @param created_id
	 * @param created_at
	 * @param updated_id
	 * @param updated_at
	 * @param is_deleted
	 */
	public BasicDto(int is_deleted, Long created_at, Long created_id,
			Long updated_at, Long updated_id) {
		super();
		this.created_id = created_id;
		this.created_at = created_at;
		this.updated_id = updated_id;
		this.updated_at = updated_at;
		this.is_deleted = is_deleted;
	}
	/**
	 * @return created_id
	 */
	public Long getCreated_id() {
		return created_id;
	}
	/**
	 * @param created_id セットする created_id
	 */
	public void setCreated_id(Long created_id) {
		this.created_id = created_id;
	}
	/**
	 * @return created_at
	 */
	public Long getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at セットする created_at
	 */
	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return updated_id
	 */
	public Long getUpdated_id() {
		return updated_id;
	}
	/**
	 * @param updated_id セットする updated_id
	 */
	public void setUpdated_id(Long updated_id) {
		this.updated_id = updated_id;
	}
	/**
	 * @return updated_at
	 */
	public Long getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at セットする updated_at
	 */
	public void setUpdated_at(Long updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return is_deleted
	 */
	public int getIs_deleted() {
		return is_deleted;
	}
	/**
	 * @param is_deleted セットする is_deleted
	 */
	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result
				+ ((created_id == null) ? 0 : created_id.hashCode());
		result = prime * result + is_deleted;
		result = prime * result
				+ ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result
				+ ((updated_id == null) ? 0 : updated_id.hashCode());
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicDto other = (BasicDto) obj;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (created_id == null) {
			if (other.created_id != null)
				return false;
		} else if (!created_id.equals(other.created_id))
			return false;
		if (is_deleted != other.is_deleted)
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		if (updated_id == null) {
			if (other.updated_id != null)
				return false;
		} else if (!updated_id.equals(other.updated_id))
			return false;
		return true;
	}


}
