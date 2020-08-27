package com.ebanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext){
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter("C:/UsersPhurkan/workspace/ebanking/test-output/"+repName);
		htmlReporter.loadXMLConfig("/C:/UsersPhurkan/workspace/ebanking/test-output/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Window10");
		extent.setSystemInfo("User", "Radhe");
		
		htmlReporter.config().setDocumentTitle("ebanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		}
		
		public void onTestSuccess(ITestResult tr){
		
		test=extent.createTest(tr.getName());//create new entry in the report
		test.log(Status.PASS	, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN	));
	}
		
		 public void onTestFailure(ITestResult tr){
		    	
         test=extent.createTest(tr.getName());//create new entry in the report
	   	 test.log(Status.FAIL	, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED	));
	   	 
	   	 String screenshotPath=System.getProperty("user-dir")+"\\Screenshort\\"+tr.getName()+".png";
	   	 
	   	 File f= new File(screenshotPath);
	   	 
	   	 if(f.exists()){
	   		 try{
	   			 test.fail("Screenshot is below"+test.addScreencastFromPath(screenshotPath));
	   		 }catch(Exception e){
	   			 e.printStackTrace();
	   		 }
	   	 }
		
		}
		 
		 public void onTestSkiped(ITestResult tr){
				
				test=extent.createTest(tr.getName());//create new entry in the report
				test.log(Status.SKIP	, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE	));

		 }
		 
		 public void onFinish(ITestResult testContext){
			 extent.flush();
		 }
}