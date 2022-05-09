//import java.io.InputStream;
//import java.net.URL;
//
//public class testingurl {
//	private static int fetchRemoteFile(String location) throws Exception {
//		  URL url = new URL(location);
//		  InputStream is = null;
//		  int length;
//		  is = url.openStream();
//		  length = is.available();
//		  if (is != null)
//			  is.close();
//		  return length;
//		}
//	public static void main(String[] args) throws Exception
//	{
//	    String url = "https://www.google.com";
//		System.out.println(fetchRemoteFile(url));
//	}
//}
