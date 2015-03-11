package jp.co.yomerecipe.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.yomerecipe.dao.RecipeDao;
import jp.co.yomerecipe.dao.StepDao;
import jp.co.yomerecipe.dao.StuffDao;
import jp.co.yomerecipe.dto.UserDto;
import jp.co.yomerecipe.dto.form.servlet.RecipeForm;
import jp.co.yomerecipe.dto.form.servlet.StepForm;
import jp.co.yomerecipe.dto.form.servlet.StuffForm;
import jp.co.yomerecipe.dto.form.servlet.TypeRecipeForm;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import yang.framework.action.BasicAction;
import yang.framework.annotation.Authority;
import yang.framework.annotation.ResponseType;
import yang.framework.util.DigestUtil;
import yang.framework.util.IntegerUtil;
import yang.framework.util.MessageUtil;
import yang.framework.util.StringUtil;
import yang.framework.validation.Operation;
import yang.framework.validation.ValidationManager;

/**
 * レシピ追加確定アクション
 * @author VV000584
 *
 */
@ResponseType(type="redirect")
public class AddRecipeCompleteAction extends BasicAction {

	@Override
	@Authority(type="admin")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		RequestContext contex = new ServletRequestContext(request);
		HttpSession session = request.getSession();
		//追加者のIDを取得
		Long userid = ((UserDto) session.getAttribute("user")).getId();
		String loadpath=request.getSession().getServletContext().getRealPath("/public/img/");
		Calendar c = Calendar.getInstance();
        String subDir = StringUtil.toString(c.get(Calendar.YEAR))+StringUtil.toString(c.get(Calendar.MONTH));

		File fileDir = new File(loadpath + "/" + subDir + "/");
		fileDir.mkdirs();
		if (FileUpload.isMultipartContent(contex)){
			//フォーム
			RecipeForm recipe = new RecipeForm();
			HashMap<Integer, Long> indids = new HashMap<Integer, Long>();
			HashMap<Integer, Integer> indlevels = new HashMap<Integer, Integer>();
			HashMap<Integer, String> stuffnames = new HashMap<Integer, String>();
			HashMap<Integer, String> stuffamounts = new HashMap<Integer, String>();
			HashMap<Integer, String> steptitles = new HashMap<Integer, String>();
			HashMap<Integer, String> stepdetails = new HashMap<Integer, String>();
			HashMap<Integer, String> stepimgs = new HashMap<Integer, String>();
			int stuffcount = 0;
			int stepcount = 0;
			int indcount = 0;


			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(100*1024*1024);
			List<?> items = new ArrayList();
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			Iterator<?> it = items.iterator();
			while (it.hasNext()){
				FileItem item = (FileItem)it.next();
				if (item.isFormField()){
					String paramName = item.getFieldName();
					try {
						//レシピ名
						if (paramName.equals("recipename")){
							recipe.name = new String(item.getString().getBytes("iso8859-1"),"UTF-8");
						} else if (paramName.equals("recipedes")){//レシピ詳細
							recipe.description = new String(item.getString().getBytes("iso8859-1"),"UTF-8");
						} else if (paramName.equals("recipelevel")){//レシピレベル
							recipe.cooklevel = IntegerUtil.toInt(item.getString());
						} else if (paramName.contains("indid")){//インディケーター
							int key = IntegerUtil.toInt(paramName.substring(5));
							Long value = IntegerUtil.toLong(item.getString());
							if (key > indcount){
								indcount = key;
							}
							indids.put(key, value);
						} else if (paramName.contains("indlevel")){//インディケーターのレベル
							int key = IntegerUtil.toInt(paramName.substring(8));
							int value = IntegerUtil.toInt(item.getString());
							if (key > indcount){
								indcount = key;
							}
							indlevels.put(key, value);
						} else if (paramName.contains("stuffname")){
							int key = IntegerUtil.toInt(paramName.substring(9));
							String value = new String(item.getString().getBytes("iso8859-1"),"UTF-8");
							if (key > stuffcount){
								stuffcount = key;
							}
							stuffnames.put(key, value);
						} else if (paramName.contains("stuffamount")){
							int key = IntegerUtil.toInt(paramName.substring(11));
							String value = new String(item.getString().getBytes("iso8859-1"),"UTF-8");
							if (key > stuffcount){
								stuffcount = key;
							}
							stuffamounts.put(key, value);
						} else if (paramName.contains("steptitle")){
							int key = IntegerUtil.toInt(paramName.substring(9));
							String value = new String(item.getString().getBytes("iso8859-1"),"UTF-8");
							if (key > stepcount){
								stepcount = key;
							}
							steptitles.put(key, value);
						} else if (paramName.contains("stepdetail")){
							int key = IntegerUtil.toInt(paramName.substring(10));
							String value = new String(item.getString().getBytes("iso8859-1"),"UTF-8");
							if (key > stepcount){
								stepcount = key;
							}
							stepdetails.put(key, value);
						} else if (!paramName.equals("token")){
							MessageUtil.getInstance().addError("パラメータが不正です");
							return "";
						}
					} catch (UnsupportedEncodingException e) {
						// TODO 自動生成された catch ブロック
						MessageUtil.getInstance().addError("パラメータが不正です");
						e.printStackTrace();
					}
				}else{
					if(item.getName()!=null && item.getSize()!=0){
						DigestUtil digest = new DigestUtil(DigestUtil.SHA256);
					    String fileName = digest.hex(StringUtil.toString(new Date().getTime()));
					    File newFile = new File(loadpath + "/" + subDir + "/" + fileName+".jpg");
						try {
							item.write(newFile);
							String paramName = item.getFieldName();
							if (paramName.equals("recipeimg")){
								recipe.img_url = subDir + "/" + fileName+".jpg";
							} else if (item.getFieldName().contains("stepimg")){
								int key = IntegerUtil.toInt(paramName.substring(7));
								String value = subDir + "/" + fileName+".jpg";
								stepimgs.put(key, value);
							} else {
								MessageUtil.getInstance().addError("パラメータが不正です");
								return "";
							}
					    }
						catch (Exception e)
						{
							MessageUtil.getInstance().addError("パラメータが不正です");
							e.printStackTrace();
						}
					}
				}
			}
			//バリデーション
			if (!ValidationManager.validation(recipe.name, "レシピ名",
					Operation.Required(),
					Operation.MaxLength(30)).validate()){
				MessageUtil.getInstance().addError("パラメータが不正です");
				return "";
			}
			if (!ValidationManager.validation(recipe.img_url, "レシピ画像",
					Operation.Required()).validate()){
				MessageUtil.getInstance().addError("パラメータが不正です");
				return "";
			}
			if (!ValidationManager.validation(recipe.description, "レシピ詳細",
					Operation.Required(),
					Operation.MaxLength(255)).validate()){
				MessageUtil.getInstance().addError("パラメータが不正です");
				return "";
			}
			if (!ValidationManager.validation(recipe.cooklevel, "レシピレベル",
					Operation.Required(),
					Operation.Pattern("が不正です", Pattern.compile("[1-5]"))).validate()){
				MessageUtil.getInstance().addError("パラメータが不正です");
				return "";
			}
			//フォーム作成
			ArrayList<StuffForm> stuffForms = new ArrayList<StuffForm>();
			ArrayList<StepForm> stepForms = new ArrayList<StepForm>();
			ArrayList<TypeRecipeForm> typeRecipeForms = new ArrayList<TypeRecipeForm>();
			Long nowtime = new Date().getTime();

			Long maxstep = StepDao.getMaxId().id + (long)1;
			Long maxstuff = StuffDao.getMaxId().id + (long)1;
			Long maxrecipe = RecipeDao.getMaxId().id + (long)1;

			//レシピフォーム作成
			recipe.id = maxrecipe;
			recipe.cooktime = (double) 0;
			recipe.step = stepcount;
			recipe.is_deleted = 0;
			recipe.created_at = nowtime;
			recipe.created_id = userid;
			recipe.updated_at = nowtime;
			recipe.updated_id = userid;

			for (int i = 1; i <= stepcount; i++){
				if (steptitles.containsKey(i)&&stepdetails.containsKey(i)){
					String imgurl = "";
					if (stepimgs.containsKey(i)){
						imgurl = stepimgs.get(i);
					}
					StepForm step = new StepForm(maxstep++,maxrecipe,steptitles.get(i),stepdetails.get(i),imgurl,0,nowtime,userid,nowtime,userid);
					stepForms.add(step);
				}
			}

			for (int i = 1; i <= stuffcount; i++){
				if (stuffnames.containsKey(i)&&stuffamounts.containsKey(i)){
					StuffForm stuff = new StuffForm(maxstuff++,maxrecipe,stuffnames.get(i),stuffamounts.get(i),0,nowtime,userid,nowtime,userid);
					stuffForms.add(stuff);
				}
			}

			for (int i = 1; i <= indcount; i++){
				if (indids.containsKey(i)&&indlevels.containsKey(i)){
					TypeRecipeForm typeRecipe = new TypeRecipeForm(maxrecipe,indids.get(i),indlevels.get(i),0,nowtime,userid,nowtime,userid);
					typeRecipeForms.add(typeRecipe);
				}
			}

			RecipeDao.addRecipe(recipe, stuffForms, stepForms, typeRecipeForms);
			return "RecipeDetail?user_id=" + userid + "&recipe_id=" + maxrecipe;
		}
		return "AddRecipe";
	}

}
