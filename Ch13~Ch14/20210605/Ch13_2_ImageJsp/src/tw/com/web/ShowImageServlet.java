package tw.com.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tw.com.bean.ImageObj;

@WebServlet(name="showImage",urlPatterns = {"/showImage"})
public class ShowImageServlet extends HttpServlet{
//C:\Users\xvpow\eclipse-workspace\Ch13_2_ImageJsp\WebContent\images
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String FILE_PATH= getServletContext().getInitParameter("imagePath");	
		Path imagePath = Paths.get(FILE_PATH);
		
	List<ImageObj> imageObjList = 	Files.list(imagePath).map(p->{
			String fileName= p.getFileName().toString();
			String alt = fileName;
			return new ImageObj(fileName,alt);
		}).collect(Collectors.toList());
	req.setAttribute("imageList", imageObjList);	
	req.getRequestDispatcher("/showImage.jsp").forward(req, resp);
		
	
	}
}
