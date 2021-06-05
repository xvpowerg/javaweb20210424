package tw.com.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//MultipartConfig 表示此Servlet要接收檔案
@MultipartConfig
@WebServlet(name="uploadImage",urlPatterns = {"/uploadImage"})
public class UploadImageServlet extends HttpServlet{
//C:\Users\xvpow\eclipse-workspace\Ch13_2_ImageJsp\WebContent\images
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		 String FILE_PATH = getServletContext().getInitParameter("imagePath");
		 String partName = getServletConfig().getInitParameter("partName");
		 Part photo = req.getPart(partName);
		 String fileName = photo.getSubmittedFileName();
		 String uploadPath = FILE_PATH+fileName;
		 InputStream in= photo.getInputStream();
		 Path imagePath = Paths.get(uploadPath);
		 Files.copy(in, imagePath, StandardCopyOption.REPLACE_EXISTING);
		 System.out.println(fileName);
		 
	}
}
