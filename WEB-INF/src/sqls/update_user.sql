update yome_user set
	ID = ?,
	NAME = ?,
	EMAIL = ?,
	PASSWORD = ?,
	TYPE = ?,
	AGE = ?,
	COOKLEVEL = ?,
	IS_PREMIUM = ?,
	PREMIUM_EXPIRE_DATE = ?,
	LAST_LOGIN_AT = ?,
	IMG_URL=?,
	IS_DELETED = ?,
	CREATED_AT = ?,
	CREATED_ID = ?,
	UPDATED_AT = ?,
	UPDATED_ID = ?
where is_deleted = 0 and id = ?