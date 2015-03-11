select
	OPTION_ID,
	INDICATOR_ID,
	SCORE_RIGHT,
	IS_DELETED,
	CREATED_AT,
	CREATED_ID,
	UPDATED_AT,
	UPDATED_ID
from option_score
where is_deleted = 0 and
	option_id = ?