package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.bean.FoodData;
import tw.com.web.tmplate.PageTemplate;

@WebServlet("/page2")
public class ServletPage2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//女生演算法
		FoodData foodData = FoodData.getAttr(req);
	PrintWriter out = resp.getWriter();
	String html = 
			PageTemplate.getHtml(foodData.getColor(), foodData.getSex(), foodData.getFoodList());
	out.println(html);
		
	}
     
}
