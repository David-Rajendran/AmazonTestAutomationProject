package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties pro;

	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
	
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
	public String getChromepath()
	{
		String cpath = pro.getProperty("chromepath");
		return cpath;
	}
	public String getedgepath()
	{
		String epath = pro.getProperty("egdepath");
		return epath;
	}

	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getSearchItem()
	{
		String enteredSearchItem = pro.getProperty("searchItem");
		return enteredSearchItem;
	}
	public String getMyItem()
	{
		String mySearchItem = pro.getProperty("myItem");
		return mySearchItem;
	}
	
	public String getEmail()
	{
		String mailID = pro.getProperty("emailKey");
		return mailID;
	}
	public String getPass()
	{
		String pass = pro.getProperty("passwordKey");
		return pass;
	}
}



