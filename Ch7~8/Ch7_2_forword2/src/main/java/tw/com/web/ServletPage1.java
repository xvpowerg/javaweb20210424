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

@WebServlet("/page1")
public class ServletPage1 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		  String[] food =  req.getParameterValues("food");
		  String sex  = req.getParameter("sex");
		  FoodData foodData = new FoodData(food,sex);
		  if (!foodData.isMan()) {
			  FoodData.setAttr(req, foodData);
			  req.getRequestDispatcher("/page2").forward(req, resp);			  			  
			  return;
		  }
		  String html = PageTemplate.getHtml(foodData.getColor(), 
				  foodData.getSex(), 
				  foodData.getFoodList());
		  
		  PrintWriter out =  resp.getWriter();
		  out.print(html);
		  
	}
     
}
