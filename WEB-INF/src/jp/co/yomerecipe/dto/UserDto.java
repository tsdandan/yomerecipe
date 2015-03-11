package jp.co.yomerecipe.dto;

public class UserDto extends BasicDto{

	/**
	 *
	 */
	private static final long serialVersionUID = -6830977505413219980L;
	public Long id;
	public String name;
	public String email;
	public String password;
	public String type;
	public int cooklevel;
	public int age;
	public int is_premium;
	public String premium_expire_date;
	public String last_login_at;
	public String img_url;

	public UserDto(){
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
	 * @return mail
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param mail セットする mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return level
	 */
	public int getCooklevel() {
		return cooklevel;
	}
	/**
	 * @param level セットする level
	 */
	public void setCooklevel(int cooklevel) {
		this.cooklevel = cooklevel;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return is_premium
	 */
	public int getIs_premium() {
		return is_premium;
	}
	/**
	 * @param is_premium セットする is_premium
	 */
	public void setIs_premium(int is_premium) {
		this.is_premium = is_premium;
	}
	/**
	 * @return premium_expire_date
	 */
	public String getPremium_expire_date() {
		return premium_expire_date;
	}
	/**
	 * @param premium_expire_date セットする premium_expire_date
	 */
	public void setPremium_expire_date(String premium_expire_date) {
		this.premium_expire_date = premium_expire_date;
	}
	/**
	 * @return last_login_at
	 */
	public String getLast_login_at() {
		return last_login_at;
	}
	/**
	 * @param last_login_at セットする last_login_at
	 */
	public void setLast_login_at(String last_login_at) {
		this.last_login_at = last_login_at;
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
		result = prime * result + age;
		result = prime * result + cooklevel;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img_url == null) ? 0 : img_url.hashCode());
		result = prime * result + is_premium;
		result = prime * result
				+ ((last_login_at == null) ? 0 : last_login_at.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((premium_expire_date == null) ? 0 : premium_expire_date
						.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		UserDto other = (UserDto) obj;
		if (age != other.age)
			return false;
		if (cooklevel != other.cooklevel)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (is_premium != other.is_premium)
			return false;
		if (last_login_at == null) {
			if (other.last_login_at != null)
				return false;
		} else if (!last_login_at.equals(other.last_login_at))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (premium_expire_date == null) {
			if (other.premium_expire_date != null)
				return false;
		} else if (!premium_expire_date.equals(other.premium_expire_date))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



}
