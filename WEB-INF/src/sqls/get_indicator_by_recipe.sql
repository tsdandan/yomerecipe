select
	indicator.ID,
	indicator.NAME,
	indicator.TYPE_CLASSIFY,
	indicator.IS_DELETED,
	indicator.CREATED_AT,
	indicator.CREATED_ID,
	indicator.UPDATED_AT,
	indicator.UPDATED_ID
from indicator
inner join type_recipe on id = indicator_id
where type_recipe.is_deleted = 0 and type_recipe.recipe_id = ?