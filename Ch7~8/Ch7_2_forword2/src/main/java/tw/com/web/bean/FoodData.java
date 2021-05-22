package tw.com.web.bean;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
public class FoodData {
   private String[] foods;
   private String[] foodsTxt = {"","�J�|","�ޱ�","����","�N�n","�ѥ]"};
   private String sex;
   private String[] sexTxt = {"","�k","�k"};
   private String[] color = {"","cadetblue","pink"};
   
	public FoodData(String[] foods,String sex) {
		this.foods = foods;
		this.sex = sex;
	}
	//<li>�J�|</li>
	//ī�G
	//lambda
	public String getFoodList() {
		String list = "";
		if (foods != null) {
			list = Stream.of(foods).
					mapToInt(v->Integer.parseInt(v)).
					mapToObj(inx ->foodsTxt[inx]).
					reduce("",(v1,v2)->{				
				return v1+"<li>"+v2+"</li>";
			});	
		}
		
		return list;
	}
	
	public String getSex() {
		int index =  Integer.parseInt(sex);
		return sexTxt[index];
	}
	
	public boolean isMan() {
		return sex==null|| sex.equals("1");
	}
	
	public String getColor() {
		int index =  Integer.parseInt(sex);
		return color[index];
	}
	
	public static final String FOOD_DATA_KEY = "fooddata";
	public static void setAttr(HttpServletRequest req,FoodData foodata) {
		req.setAttribute(FOOD_DATA_KEY, foodata);
	}
	public static FoodData getAttr(HttpServletRequest req) {
		return ( FoodData)req.getAttribute(FOOD_DATA_KEY);
	}
	
   
}
