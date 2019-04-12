package Com.Create;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class write {
	public static void createTxt(String fname, String s) {
		PrintWriter writer = null;
		System.out.println(System.getProperty("user.dir"));
		try {
			writer = new PrintWriter(System.getProperty("user.dir") + "\\src\\Com\\Create\\" + fname, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.print(s);
		writer.close();
		
	}

}
