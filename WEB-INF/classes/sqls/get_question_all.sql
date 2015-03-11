select
	ID,
	TITLE,
	TYPE,
	IMGURL,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from questions
where is_deleted = 0