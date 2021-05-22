package tw.com.web.test;

import tw.com.web.bean.FoodData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] box = {"1","2","3"};
		String sex = "2";
		FoodData foodData = new FoodData(box,sex);
		System.out.println(foodData.getFoodList());
		System.out.println(foodData.getSex());
		System.out.println(foodData.getColor());
	}

}
