select
	RECIPE_ID,
	INDICATOR_ID,
	COOKLEVEL,
    IS_DELETED,
    CREATED_AT,
    CREATED_ID,
    UPDATED_AT,
    UPDATED_ID
from type_recipe
where recipe_id = ? and
	indicator_id = ?