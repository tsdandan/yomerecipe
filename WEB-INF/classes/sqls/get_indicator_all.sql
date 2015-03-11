select
	ID,
	NAME,
	TYPE_CLASSIFY,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from indicator
where is_deleted = 0