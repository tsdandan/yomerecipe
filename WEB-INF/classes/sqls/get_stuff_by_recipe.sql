select
	ID,
	RECIPE_ID,
	NAME,
	AMOUNT,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from recipe_stuff
where is_deleted = 0 and
	RECIPE_ID = ?