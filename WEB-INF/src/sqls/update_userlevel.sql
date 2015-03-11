update user_level set
	USER_ID = ?,
	INDICATOR_ID = ?,
	COOKLEVEL = ?,
	SCORE = ?,
	IS_DELETED = ?,
	CREATED_AT = ?,
	CREATED_ID = ?,
	UPDATED_AT = ?,
	UPDATED_ID = ?
where is_deleted = 0 and
	user_id = ? and
	indicator_id = ?