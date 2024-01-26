package tests;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import utilities.ReadConfig;

public class BaseClass {

	
ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String searchItem=readconfig.getSearchItem();
	public String myItem=readconfig.getMyItem();
	public String emailKey=readconfig.getEmail();
	public String passwordKey=readconfig.getPass();
	
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		log= LogManager.getLogger(BaseClass.class);
		
		
		if(br.equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver",readconfig.getChromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("Webdriver.edge.driver",readconfig.getedgepath());
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
	}
		
		

	 
}
