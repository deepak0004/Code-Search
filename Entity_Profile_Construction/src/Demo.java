// Just mining data and recording codes which have java tag and code.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.events.StartElement;

import org.apache.commons.lang.StringUtils;

public class Demo extends SOMiner {

	static ArrayList<String> a = new ArrayList<>();
	
	public static void main(String[] args) {
		String filePath = "posts.xml";
		Demo demo = new Demo();
		demo.mine(filePath); //Mine and call processRow for each row.	
		
		BufferedWriter out = null;

		try {
		    out = new BufferedWriter(new FileWriter("p3.xml"));
		    for (int i = 0; i < a.size(); i++) {
		    	out.write(a.get(i));
			}
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if(out != null){
		            out.close();
		        } else {
		            System.out.println("Buffer has not been initialized!");
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		System.out.println("done!");
	 
	}

	@Override
	public void processRow(StartElement startElement, String line)
			throws IOException {
		
		String title = getStringElement(startElement, "Tags");
		String body = getStringElement(startElement, "Body");//Get Title from each line.
		if (StringUtils.containsIgnoreCase(title, "java") && !StringUtils.containsIgnoreCase(title, "javascript")
				&& StringUtils.containsIgnoreCase(body, "<code>")){
			a.add(line + '\n');
//			System.out.println(line);
		}
		
	}
}