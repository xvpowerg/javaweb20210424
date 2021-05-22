package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Stream;
@WebServlet("/readCookies")
public class TestReadCookiesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookieArray= req.getCookies();
		if (cookieArray != null) {
			Stream.of(cookieArray).
			forEach(ck->System.out.println(ck.getName()+":"+ck.getValue()));
			
			Optional<Cookie> opc= Stream.of(cookieArray).
			filter(ck->ck.getName().equals("cookiName")).findFirst();
			opc.ifPresent(ck->System.out.println(ck.getValue()));			
		}
		
		
	}
	
	
	

}
