SELECT count(*) c
from recipe
inner join user_recipe on recipe.id = user_recipe.recipe_id
where recipe.is_deleted = 0 and
	user_recipe.is_deleted = 0 and
	user_id = ?