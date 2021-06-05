package tw.com.bean;

public class ImageObj {
		private String name;
		private String alt;
		private static String imagePath; 
		public ImageObj(String name, String alt) {
			super();
			this.name = name;
			this.alt = alt;
		}
		public String getName() {
			return name;
		}
		public String getAlt() {
			return alt;
		}
		
		public static void setImagePath(String imagePath) {
			ImageObj.imagePath = imagePath;			
		}
		public static String getImagePath() {
			return ImageObj.imagePath;
		}
		
}
