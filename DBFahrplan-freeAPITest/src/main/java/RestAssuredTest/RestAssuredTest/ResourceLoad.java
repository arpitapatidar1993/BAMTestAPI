package RestAssuredTest.RestAssuredTest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
public class ResourceLoad
{
	public Properties prop;
	public void resources() throws IOException {
		
		final String RESOURCE_PATH            = "\\src\\test\\java\\resources\\data.properties";
		final String USERDIR ="user.dir";
         prop = new Properties();
         FileInputStream fis= new FileInputStream(System.getProperty(USERDIR)+RESOURCE_PATH);
 	    prop.load(fis);
       
    }
}



	

	

 	
