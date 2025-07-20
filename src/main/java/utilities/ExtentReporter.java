package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport;
	public static ExtentReports getExtentReport() {
		
		   String extentReportPath = System.getProperty("user.dir") + "/reports/extentreport.html";
	        File reportFile = new File(extentReportPath);

	        // Create parent directory if it doesn't exist
	        if (!reportFile.getParentFile().exists()) {
	            boolean created = reportFile.getParentFile().mkdirs();
	            if (created) {
	                System.out.println("✅ 'reports' folder created at: " + reportFile.getParent());
	            } else {
	                System.out.println("❌ Failed to create 'reports' folder.");
	            }
	        }
		    ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		    reporter.config().setReportName("TutorialsNinja Automation Results");
		    reporter.config().setDocumentTitle("Test Result");
		    
		    extentReport = new ExtentReports();
		    extentReport.attachReporter(reporter);
		    extentReport.setSystemInfo("Operating System", "Mac M3");
		    extentReport.setSystemInfo("Tested By", "Sajan Rajak");
		    
		    return extentReport;
		    
		    
	}

}
