package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileManager {

	Properties pro;

	public FileManager()
	{
		try {
			FileInputStream fis=new FileInputStream("./config.properties");
			 pro=new Properties();
			 pro.load(fis);
		} catch (Exception e) {
			System.out.println("invalid path");
		}
		
	}
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		if(url==null)
		{
			throw new RuntimeException("invalid url");
		}
		return url;
		
	}
	
	public long getImplicityWait()
	{
		String implicitlywait = pro.getProperty("iw");
		if(implicitlywait==null)
		{
			throw new RuntimeException("invalid time");
		}
		return Long.parseLong(implicitlywait);
	
	}
	
	public String gerProductionUrl()
	{
		String uatURl = pro.getProperty("uaturl");
		if(uatURl==null)
		{
			throw new RuntimeException("invalid prod url");
		}
		return uatURl;
	}
	
}
