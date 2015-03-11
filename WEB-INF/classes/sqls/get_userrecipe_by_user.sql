select
	USER_ID,
	RECIPE_ID,
	LAST_FEEDBACK,
	FBCOUNTS,
	FEEDBACK,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from user_recipe
where is_deleted = 0 and
	user_id = ?