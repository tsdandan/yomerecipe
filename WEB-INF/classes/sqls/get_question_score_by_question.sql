select
	QUESTION_ID,
	INDICATOR_ID,
	SCORE_RIGHT,
	SCORE_WRONG,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from question_score
where is_deleted = 0 and
	question_id = ?