select
	ID,
	QUESTION_ID,
	CONTENT,
	IS_CORRECT,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from options
where is_deleted = 0 and
	question_id = ?