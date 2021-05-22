package tw.com.web.tmplate;

public class PageTemplate {
    public static final String tmplate = "<!DOCTYPE html>\r\n"
    		+ "<html>\r\n"
    		+ "<head>\r\n"
    		+ "<meta charset=\"UTF-8\">\r\n"
    		+ "<title>Insert title here</title>\r\n"
    		+ "<!--background-color:pink;-->\r\n"
    		+ "<style>\r\n"
    		+ "/*background-color:pink;*/\r\n"
    		+ "		body{		\r\n"
    		+ "	background-color: %s;	 	\r\n"
    		+ "		 	    \r\n"
    		+ "		}\r\n"
    		+ "</style>\r\n"
    		+ "</head>\r\n"
    		+ "<title>­¹ª«³ß¦n</title>\r\n"
    		+ "<body>\r\n"
    		+ "	\r\n"
    		+ "	<h2>%s</h2>\r\n"
    		+ "	\r\n"
    		+ "	<ol>\r\n"
    		+ "		%s"    			
    		+ "	</ol>\r\n"
    		+ "</body>\r\n"
    		+ "</html>" ;
    //
    
    public static String getHtml(String color,String sex,String foodList) {
    		return String.format(tmplate, color,sex,foodList);
    }
    
}
