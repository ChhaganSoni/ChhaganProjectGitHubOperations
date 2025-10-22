package commonUtility_Pkg;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	
	 private static ExtentReports extent;
	 private static ExtentSparkReporter spark; 
	 String timestamp;

	    public static ExtentReports getInstance() {
	        if (extent == null) 
	        {
	        	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	            spark.config().setDocumentTitle("Toshitkumar SONI Report");
	            spark.config().setReportName("RIDDHISHA SONI - Test Execution Summary");
	            spark.config().setTheme(Theme.DARK);
	            
	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            extent.setSystemInfo("Environment", "QA");
	            extent.setSystemInfo("OS", System.getProperty("os.name"));
	            extent.setSystemInfo("User", System.getProperty("user.name"));
	        }
	        return extent;
	    }

}
