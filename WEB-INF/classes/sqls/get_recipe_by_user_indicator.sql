select
	recipe.ID,
	recipe.NAME,
	recipe.STEP,
	recipe.COOKLEVEL,
	recipe.COOKTIME,
	recipe.DESCRIPTION,
	recipe.IMG_URL,
	recipe.IS_DELETED,
	recipe.CREATED_AT,
	recipe.CREATED_ID,
	recipe.UPDATED_AT,
	recipe.UPDATED_ID
from recipe
inner join type_recipe on recipe.id = type_recipe.recipe_id
inner join user_recipe on recipe.id = user_recipe.recipe_id
where recipe.is_deleted = 0 and
	type_recipe.is_deleted = 0 and
	user_recipe.is_deleted = 0 and
	user_id = ? and indicator_id = ?