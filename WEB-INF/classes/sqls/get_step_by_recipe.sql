select
	ID,
	RECIPE_ID,
	NAME,
	DETAIL,
	IMG_URL,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from recipe_step
where is_deleted = 0 and
	RECIPE_ID = ?