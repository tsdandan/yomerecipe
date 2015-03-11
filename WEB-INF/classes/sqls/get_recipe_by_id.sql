select
	ID,
	NAME,
	STEP,
	COOKLEVEL,
	COOKTIME,
	DESCRIPTION,
	IMG_URL,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from recipe
where is_deleted = 0 and
	id = ?