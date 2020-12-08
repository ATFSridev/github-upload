


//package com.comcast.nwt.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.comcast.framework.core.helpers.TAFInitializers;
import com.comcast.framework.core.helpers.TAFLogger;
import com.comcast.framework.core.helpers.TAFUtilities;

	/**
	 * 
	 * @author ssrigo001c
	 * Created Date:
	 */
	public class JobList  {
	
		
		public static void clickJobList() throws InterruptedException
		{ 					
			TAFLogger.info("Click Job List");					
			try 
			{				
				TAFLogger.info("Checking Job List");
				TAFUtilities.getElement("landingPage.jobListTab").click();
				TAFLogger.info("Clicked on the Job List");
				
			} catch (IOException e)
			  {			
				e.printStackTrace();
			  }	
		 }
		
		public static void displayedTeamsPopupMultipleTeams() throws InterruptedException
		{ 					
			TAFLogger.info("Displayed Teams Popup");					
			try 
			{	
				Thread.sleep(2000);
//				if(!(TAFUtilities.getElement("jobList.changeDisplayedTeamModal").isDisplayed())){
//					TAFUtilities.getElement("jobList.changeDisplayedTeamButton").click();
//				}
								
				TAFUtilities.getElement("jobList.multipleTeams").click();
				Thread.sleep(2000);
				TAFUtilities.getElement("jobList.multipleTeams.RootIcon").click();
				Thread.sleep(2000);
				TAFUtilities.getElement("jobList.multipleTeams.NationalIcon").click();
				Thread.sleep(2000);
				TAFUtilities.getElement("jobList.multipleTeams.OSSTeamIcon").click();
				Thread.sleep(2000);
				TAFUtilities.getElement("jobList.multipleTeams.ViewButton").click();
				Thread.sleep(5000);
				
			} catch (IOException e)
			  {			
				e.printStackTrace();
			  }	
		 }
		
		public static void enableTaskLabel() throws IOException, InterruptedException
		{
						
			TAFUtilities.getElement("jobLookuppage.menu").click();
	        TAFUtilities.wait(TAFInitializers.driver, TAFUtilities.getLocator("jobLookuppage.ExportVisibleData"), 20, "elementVisible");		
			List<WebElement> menu=TAFInitializers.driver.findElements(By.xpath("//ul[@class='ui-grid-menu-items']//child::button"));
			menu.get(17).click();
			TAFUtilities.getElement("jobLookuppage.menu").click();
	
		}
		
		public static void checkTeamDisplay(String team) throws InterruptedException
		{ 					
			SoftAssert objSoftAssert = new SoftAssert();
			TAFLogger.info("checking displayed team name");					
			try 
			{	
				String checkTeam="//*[.='"+team+"' and @class='ui-grid-cell-contents ng-binding ng-scope']";
				List<WebElement> teamCol = TAFInitializers.driver.findElements(By.xpath(checkTeam));
				List<WebElement> jobRows = TAFUtilities.getElementsList("jobList.JobRows");
				
				objSoftAssert.assertEquals(teamCol, jobRows, "VERIFICATION OF THE TEAM NAME IN ALL THE ROWS");
				if(teamCol.size()==jobRows.size())
				{
					System.out.println("Team name displayed under Team column in job list page is same as Team selected from Display Team tab.");
				}
				
			} catch (IOException e)
			  {			
				e.printStackTrace();
			  }	
		 }
		
		public static List<String[]> getCoulmnDetails() throws InterruptedException, IOException
		{	
			
			List<String[]> rowDetails = getHeaderDetails();
			Actions action1 = new Actions(TAFInitializers.driver);

		        for(int x=0;x<20;x++)
		        {
		        	action1.moveToElement(TAFInitializers.driver.findElement(By.xpath("//*[@style='overflow: scroll;']"))).click().sendKeys(Keys.ARROW_LEFT).build().perform();
		        }
		        		        
		        List<WebElement> gridtt=TAFInitializers.driver.findElements(By.xpath("//div[contains(.,'JB')]/ancestor::div [@class='ng-isolate-scope' and @row-render-index='rowRenderIndex' and @ui-grid-row='row' and @role='row']/.."));		        
		        Iterator<WebElement> gridItems=gridtt.listIterator();
		      
		        while(gridItems.hasNext() )
		        {   //printing the total number of columns in the hierachy page
		        	
		        	 WebElement row = gridItems.next();
	   			     List<WebElement> child = row.findElements(By.xpath("./child::*"));
	   			     int colCount = child.size();	   			     
	   			     SoftAssert objSA = new SoftAssert();
	   			     objSA.assertEquals(colCount, 15);
	   			     String[] rowData = new String[colCount];
	   			     Iterator<WebElement> colItems = child.listIterator();
	   			     int j=0;
	   			     while(colItems.hasNext())
	   			     {
	   			           String columnText=colItems.next().getText();	   			           
	   			           System.out.println("Column Destils::"+ columnText);
	   			           rowData[j] = columnText;
	   			           j++;	   			                 
	   			     }		           
	   			     rowDetails.add(rowData);
		        }		          		        		        		        		      		           
		    
			return rowDetails;     	    
		}
		
		
		
		public static List<String[]> getHeaderDetails() throws IOException, InterruptedException
		{	
			
			List<String[]> rowDetails = new ArrayList<String[]>();
		    TAFLogger.info("Get the column details");
		    TAFLogger.info("Get all the available column count");	                 
		   	
		    	Actions action1 = new Actions(TAFInitializers.driver);     			        			       
		    	// GET ALL THE HEADER SIZE
		        List<WebElement> networkElement = TAFUtilities.getElementsList("jobBrowser.headerNames", "");
		        int TotalHeaders = networkElement.size();
		        int i = 0;	
		        String[] columnHText = new String[TotalHeaders];		        
		        ListIterator<WebElement> networkElementDetails = networkElement.listIterator();		        
		        while(i<3)
		        {
		        	columnHText[i]=networkElementDetails.next().getText();		            
		            System.out.println("Column Header::"+ columnHText[i]);
		            i++;
		        }
		        rowDetails.add(columnHText);
		        for(int moveCursorCount=0;moveCursorCount<6;moveCursorCount++){
		        	action1.moveToElement(TAFInitializers.driver.findElement(By.xpath("//*[@style='overflow: scroll;']"))).click().sendKeys(Keys.ARROW_RIGHT).build().perform();
		        }
		        	        
		        networkElement = TAFUtilities.getElementsList("jobBrowser.headerNames", "");
		        networkElementDetails = networkElement.listIterator();
		        for(int headerCount=0;headerCount<3;headerCount++)
		        {
		        	 networkElementDetails.next();
		        }		       		       
		        
		        while(networkElementDetails.hasNext() )
		        {  		        	
		        	 columnHText[i]=networkElementDetails.next().getText(); 			          
				         System.out.println("Column Header::"+ columnHText[i]);
					     action1.moveToElement(TAFInitializers.driver.findElement(By.xpath("//*[@style='overflow: scroll;']"))).click().sendKeys(Keys.ARROW_RIGHT).build().perform();
					     action1.moveToElement(TAFInitializers.driver.findElement(By.xpath("//*[@style='overflow: scroll;']"))).click().sendKeys(Keys.ARROW_RIGHT).build().perform();
					     Thread.sleep(1000);
					     /*if(i>10)
					     {
					    	for(int headerCount=0;headerCount<3;headerCount++)
					        {
					    		action1.moveToElement(TAFInitializers.driver.findElement(By.xpath("//*[@style='overflow: scroll;']/div[@class='ui-grid-canvas']"))).click().sendKeys(Keys.ARROW_RIGHT).build().perform();
					        }	 				    	  				       	 
					     }*/
					       i++;
		         }
		        		       
		        rowDetails.add(columnHText);  //Header complete		
		        return rowDetails;
		    }
		
		public static void checkHeaderDetails() throws IOException, InterruptedException
		{	
			String colNames[] = {"Team" , "ID" , "Job Label" , "Job Status" , "Assigned To" , "Tasks" ,  "Elements" , "Start Time" , "End Time" , "Suspend Reason" , "Equi Pri." , "Gen Op?" , "Res." , "Comm." };
			List<String> menuList = new ArrayList<String>();
			menuList.addAll(Arrays.asList(colNames));
			
			 JavascriptExecutor js=(JavascriptExecutor) TAFInitializers.driver;
		     String status="";
		     int i = 0;
			 List<String> columnnames = new ArrayList<String>();	     
	
		     while(!status.equals("OVER")){ 
		     	status = (String) js.executeScript("try{return angular.element(document.evaluate(\"//div[contains(@class,'jobLookupPage')]//div[contains(@class,'render-container-body')]//div[@class='ui-grid-canvas']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).scope().colContainer.visibleColumnCache["+i+"].displayName.toString();}catch(err){return \"OVER\";}");
		     	columnnames.add(status);
		            i++;
		            System.out.println("status :::"+status);
		     }
		     columnnames.remove("OVER");
		     //verification of the Equi Pri and Suspend
		     Assert.assertTrue(columnnames.contains("Equi Pri."), "Verification of Equi.pri -Failed");
		     Assert.assertTrue(columnnames.contains("Suspend Reason"), "Verification of Suspend Reason-Failed");
			//Validate the header menu items
			Assert.assertTrue(columnnames.containsAll(menuList), "Column items are not equal ");
			System.out.println("Column names validation Successful");
			System.out.println("EQPRI :" +columnnames.contains("Equi Pri."));
			System.out.println("Suspend Reason:" +columnnames.contains("Suspend Reason"));
			
		}
		
		
	public static void selectOutageRepairFilter() throws InterruptedException { 		
			
			TAFLogger.info("Navigating");		
		
			try {
				
				TAFUtilities.getElement("jobList.taskFilterButton").click();
						
				TAFUtilities.wait(TAFInitializers.driver, TAFUtilities.getLocator("jobList.Tasks.CentralDivision"), 10, "elementVisible");	
				System.out.println("Filtering options are available");
	
				System.out.println("Navigating to Central Division");
				Thread.sleep(1000);
				TAFUtilities.getElement("jobList.Tasks.CentralDivision").click();
				System.out.println("Navigating to Demand Maintenance");
				Thread.sleep(1000);
				TAFUtilities.getElement("jobList.Tasks.DemandMaintenance").click();
				System.out.println("Selecting Outage Repair");
				Thread.sleep(1000);
				TAFUtilities.getElement("jobList.Tasks.OutageRepair").findElement(By.xpath("./../input")).click();
				Thread.sleep(1000);
				TAFUtilities.getElement("jobList.Tasks.OkButton").click();
			} catch (IOException e) {			
				e.printStackTrace();
			  }	
		}
		
	public static void groupBy(String column) throws InterruptedException { 		
		
		TAFLogger.info("Group by "+column);	
	
	
		try {
			
			String jobListDropdown="//div[contains(.,'"+column+"') and @role='columnheader']//i[@class='ui-grid-icon-angle-down']";
			
			TAFInitializers.driver.findElement(By.xpath(jobListDropdown)).click();
			System.out.println("Open dropdown");
			Thread.sleep(3000);
			TAFUtilities.getElement("jobList.dropdown.Group").click();	
			System.out.println("Click group");
			Thread.sleep(1000);
			
			
			//After click verify total no of rows
			
					
			        	
		} catch (IOException e) {			
			e.printStackTrace();
		  }
		
	}
	
	public static List<String> groupResult() throws InterruptedException { 		
		ListIterator<WebElement> groupResults = null;
		List<String> searchContent = new ArrayList<String>();
		String FilterOutPut;
	
		
		// Group by functionality validation for the select type
	//	groupResults=groupBy(columnName);  
				    	
		List<WebElement> SearchResults = null;
		try {
			SearchResults = TAFUtilities.getElementsList("jobBrowser.GroupBySearchResults", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int TotalHeaders = SearchResults.size();
	    System.out.println("Total avialable headers: " + TotalHeaders );
	    groupResults = SearchResults.listIterator();
	    
		 if(groupResults.hasNext())
	     {                        
		        
		        while(groupResults.hasNext()){  
			        	FilterOutPut=groupResults.next().getText();
	//		        	searchContent.add(FilterOutPut);	
			        	searchContent.add(FilterOutPut.substring(0, FilterOutPut.lastIndexOf("(")).trim());
	
		        }
		        
	     } else
	     {
	     	System.out.println("Group by Search Results returned empty results... Please validate the data");
	     	TAFLogger.error("Group by Search Results returned empty results... Please validate the data");
	     	
	     }	    
	    System.out.println("End Result:" + searchContent);
	   return searchContent;
	}
	
	public static void verifySearchResults(List<String> resultOutput,String searchContent) throws IOException{
		  
		for(String e:resultOutput)
		{   
		    if (e.equals(searchContent))
		    {
		       	   System.out.println(searchContent + " available");			        	   
		    }		        	   			           
		}	    
	}
	
	public static void enrouteWorkingTimeDisplay() throws InterruptedException{
		
	    		TAFLogger.info("Verifying the Enroute working times display");
	            Thread.sleep(3000);
	      		//verify if the enroute working time is populated 
	  			try {
					if (TAFUtilities.getElement("jobDetails.workingtimescalenderbutton").isDisplayed()){
					    
						String enroutetimedetails= TAFUtilities.getElement("jobDetails.workingTimesPopup.EnrouteTimeDetails").getText();
					    if (enroutetimedetails !=null){
					  	TAFLogger.info("Successfully saved the enroute time");
					    Reporter.log("Successfully saved the enroute time");
					    }
					    else{
					  	TAFLogger.info("Failed- could not save the enroute time");
					    }
					  
					    //click the close button in the pop-up
					    TAFUtilities.getElement("jobDetails.workingTimesPopup.closeButton").click();
					    Reporter.log("Clicked the close button in the PopUp"); 
					    Thread.sleep(3000);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  				 
	  }
	  			
	      	
	      
	
	
	public static void displayedTeamsPopupMyTeams() throws InterruptedException
	{ 					
		TAFLogger.info("Displayed Teams Popup");					
		try 
		{	
			Thread.sleep(5000);
			if(!(TAFUtilities.getElement("jobList.changeDisplayedTeamModal").isDisplayed())){
				TAFUtilities.getElement("jobList.changeDisplayedTeamButton").click();
			}
			
			TAFUtilities.getElement("jobList.myTeams.ATF").click();
			Thread.sleep(5000);
			
		} catch (IOException e)
		  {			
			e.printStackTrace();
		  }	
	 }
		
	public static void displayedTeamsPopupNoTeamsSelected() throws InterruptedException
	{ 					
		TAFLogger.info("Displayed Teams Popup");					
		try 
		{	
			Thread.sleep(5000);
			if(!(TAFUtilities.getElement("jobList.changeDisplayedTeamModal").isDisplayed())){
				TAFUtilities.getElement("jobList.changeDisplayedTeamButton").click();
			}
			
			TAFUtilities.getElement("jobList.displayedTeams.CloseButton").click();
			Thread.sleep(5000);
			
		} catch (IOException e)
		  {			
			e.printStackTrace();
		  }	
	 }
		
	public static void cancelTaskFilter() throws InterruptedException { 		
		
		TAFLogger.info("Checking");		
	
		try {
				if(TAFUtilities.getElement("jobList.taskFilterButton").isDisplayed()){
				System.out.println("Filter Tasks button is present");	
				
			}
				Thread.sleep(1000);
				TAFUtilities.getElement("jobList.taskFilterButton").click();
			Thread.sleep(5000);
			
			TAFUtilities.getElement("jobList.Tasks.OutageRepair").findElement(By.xpath("./../input")).click();
			Thread.sleep(1000);
			
			TAFUtilities.getElement("jobList.filterTasks.CancelButton").click();
		} catch (IOException e) {			
			e.printStackTrace();
		  }	
	}
	
	public static void clearFilter() throws InterruptedException { 		
		
		TAFLogger.info("Clear filter");		
	
		try {
			
			TAFUtilities.getElement("jobList.taskFilterButtonOrange").click();
					
			TAFUtilities.wait(TAFInitializers.driver, TAFUtilities.getLocator("jobList.Tasks.ClearButton"), 10, "elementVisible");	
	
			TAFUtilities.getElement("jobList.Tasks.ClearButton").click();
			Thread.sleep(1000);
			TAFUtilities.getElement("jobList.Tasks.OkButton").click();
		} catch (IOException e) {			
			e.printStackTrace();
		  }	
	}
	
	public static void enrouteToAssigned(String jobID) throws InterruptedException, IOException { 		
	
		WebElement SearchResult = null;
		try {
			SearchResult = TAFUtilities.getElement("jobLisT.JobId", jobID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(SearchResult.findElement(By.xpath("./../../following-sibling::*/div[@title='En Route']")).isDisplayed())
		{
			SearchResult.click();
			String parent_window=TAFInitializers.driver.getWindowHandle();
			//*** To Get Parent Page Title 
			System.out.println("Parent WebPage Title is ="+TAFInitializers.driver.getTitle());
			Set<String> s1=TAFInitializers.driver.getWindowHandles();  
			Iterator<String> i1=s1.iterator();
			while(i1.hasNext())
			{
				String Child_Window=i1.next();
			    if(!parent_window.equalsIgnoreCase(Child_Window))
			    {
			    	TAFInitializers.driver.switchTo().window(Child_Window);
			        Thread.sleep(10000);
			        System.out.println("Child WebPage Title is ="+TAFInitializers.driver.getTitle());
			        String Child_Window_Title=TAFInitializers.driver.getTitle();
			        Assert.assertEquals(Child_Window_Title, "NWT Job Detail");
			        Thread.sleep(5000);
			        TAFUtilities.getElement("jobDetails.ExpandIcon").click();
			        Thread.sleep(5000);
	        		TAFUtilities.getElement("jobDetails.Assignments.remove").click();
	        	    Thread.sleep(2000);
			        if(TAFUtilities.isAlertPresent())
			        {
			        	TAFUtilities.alertPopUp("ok");
			        }
			        Thread.sleep(10000);
			        TAFUtilities.getElement("jobDetails.AddAssignmentIcon").click();
			        Thread.sleep(2000);
			        JobDetailsPage.assignJobtoTeamMember("!apsautomation1",0);
			        Thread.sleep(10000);
			        System.out.println("Status changed to Assigned");
			        TAFInitializers.driver.close();
			    }
			}
			TAFInitializers.driver.switchTo().window(parent_window);
			System.out.println("Changed Back to Parent WebPage and Title is ="+TAFInitializers.driver.getTitle());
		}     
    } 
	
	public static void assignedToEnroute(String jobID) throws InterruptedException, IOException { 		
	
		WebElement SearchResult = null;
		try {
			SearchResult = TAFUtilities.getElement("jobLisT.JobId", jobID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			        		if(SearchResult.findElement(By.xpath("./../../following-sibling::*/div[@title='Assigned']")).isDisplayed()){
			        			SearchResult.click();
			        			String parent_window=TAFInitializers.driver.getWindowHandle();
			        		    //*** To Get Parent Page Title 
			        		    System.out.println("Parent WebPage Title is ="+TAFInitializers.driver.getTitle());
			        		    Set<String> s1=TAFInitializers.driver.getWindowHandles();  
			        		    Iterator<String> i1=s1.iterator();
			        		    while(i1.hasNext()){
			        		                String Child_Window=i1.next();
			        		                if(!parent_window.equalsIgnoreCase(Child_Window))
			        		                {
			        			                TAFInitializers.driver.switchTo().window(Child_Window);
			        			                Thread.sleep(10000);
			        			                System.out.println("Child WebPage Title is ="+TAFInitializers.driver.getTitle());
			        			                String Child_Window_Title=TAFInitializers.driver.getTitle();
			        			                Assert.assertEquals(Child_Window_Title, "NWT Job Detail");
			        			                TAFUtilities.getElement("jobDetails.StatusDD").click();
			        			               	TAFUtilities.getElement("jobDetails.statusdropdown.EnRoute").click();
			        			    	        TAFUtilities.wait(TAFInitializers.driver, TAFUtilities.getLocator("jobDetails.status.EnRoute"), 20, "elementVisible");
			        			    	        System.out.println("Status changed to En Route");
			        			                TAFInitializers.driver.close();
			        		                }
			        		           }
			        		    TAFInitializers.driver.switchTo().window(parent_window);
			        		    System.out.println("Changed Back to Parent WebPage and Title is ="+TAFInitializers.driver.getTitle());
			        		}     
	     } 
	
	public static void enrouteResult(String jobID) throws InterruptedException, IOException { 		
	
		WebElement SearchResult = null;
		try {
			SearchResult = TAFUtilities.getElement("jobLisT.JobId", jobID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			        		if(SearchResult.findElement(By.xpath("./../../following-sibling::*/div[@title='En Route']")).isDisplayed()){
			        			System.out.println("En Route is present");
			        		}
	}
	
	
	/**
	 * @author ssrigo001c
	 * @description method to select the option from the list             
	 * @param option
	 * @see com.comcast.framework.core.helpers.TAFUtilities 
	 * @editedBy
	 * @revision
	 * @revisionDate
	 */
	public static void headerDropdown(String option) throws IOException, InterruptedException{
		
		TAFUtilities.getElement("jobList.JobId.dropdown").click();
	
		Thread.sleep(5000);
	
		String FilterOutPut;
		int num = 0,i=0;
	
		List<String> groupBy = new ArrayList<String>();
		
		List<WebElement> menu=TAFUtilities.getElementsList("jobBrowser.ColumnHeaderMenu");
		
		ListIterator<WebElement> SearchResultsDetails = menu.listIterator();
	
	    while(SearchResultsDetails.hasNext()){   //printing the total results 
	        	FilterOutPut=SearchResultsDetails.next().getText();
	        	if(FilterOutPut.contains(option)){
	        		num = i;
	        	}
	        	System.out.println("Results :"+FilterOutPut);
	        	TAFLogger.info("Search details" +FilterOutPut );
	        	groupBy.add(FilterOutPut);	
	        	i++;
	        }
		
	    menu.get(num).click();	    
		System.out.println(groupBy);
		Thread.sleep(5000);
	}
	
	/**
	 * @author ssrigo001c
	 * @description method to create the job	with Enroute status              
	 * @param taskName,taskName,ElementType,teamName,teamMember
	 * @see com.comcast.framework.core.helpers.TAFUtilities 
	 * @editedBy
	 * @revision
	 * @revisionDate
	 */
	public static String createEnrouteJob( String taskName, String Node, String ElementType, String teamName, String teamMember) throws InterruptedException, IOException{
	
			String jobNo = null;
			String selectElement = null;
			TAFLogger.startTestCase("");
			//Navigate to the new job page
			LandingPage.navigateToNewJobPage();
			Reporter.log("INFO:Navigated to New Job page");
			//Select the task on new job page
			String taskSelectionStatus = CreateJobPage.selectTask(taskName);
			Reporter.log("INFO:Selected a task");
			Assert.assertTrue(taskSelectionStatus.equalsIgnoreCase("success"),"Failed to select the correct task on new job page.");
			//on successful task selection select the element type and click on add button on new job page and capture city
			selectElement = CreateJobPage.selectElement(ElementType, Node, "", "");
			Reporter.log("INFO:Selected the elementType");
			//verify if element is null
			Assert.assertTrue(selectElement!= "" && selectElement != "failed","Failed to select the Node on new job page.");
			TAFLogger.info("Selected the Node successfully.");
			Reporter.log("INFO: Selected the node successfully");
			//on successful job creation, job number will be generated on the job details page.
			jobNo = JobDetailsPage.readJobNo();
			Assert.assertTrue(jobNo.contains("JB"),"Failed to generate Job Number on job details page.");
			JobDetailsPage.clickAddAsignment();
			//Assign job to the team
			JobDetailsPage.assigntoTeam(teamName);
			//Assign job to the team member
			JobDetailsPage.assignJobtoTeamMember(TAFInitializers.applicationProps.getProperty("application.userName"), 0);
	
	    	TAFUtilities.getElement("jobDetails.enrouteButton").click();
	       	TAFUtilities.wait(TAFInitializers.driver, TAFUtilities.getLocator("jobDetails.status.EnRoute"), 20, "elementVisible");
	       	TAFLogger.info("Status changed to En Route");
	       					
		
		return jobNo;		
	}
	/**
	 * @author ssrigo001c
	 * @description method to get Suspend Job              
	 * @param
	 * @see com.comcast.framework.core.helpers.TAFUtilities 
	 * @editedBy
	 * @revision
	 * @revisionDate
	 */
	public static void suspendJob(String jobID) throws InterruptedException, IOException { 		
	
		WebElement SearchResult = null;
		try {
			SearchResult = TAFUtilities.getElement("jobLisT.JobId", jobID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			        		if(SearchResult.findElement(By.xpath("./../../following-sibling::*/div[@title='Suspended']")).isDisplayed()){
			        			SearchResult.click();
			        			String parent_window=TAFInitializers.driver.getWindowHandle();
			        		    //*** To Get Parent Page Title 
			        		    System.out.println("Parent WebPage Title is ="+TAFInitializers.driver.getTitle());
			        		    Set<String> s1=TAFInitializers.driver.getWindowHandles();  
			        		    Iterator<String> i1=s1.iterator();
			        		    while(i1.hasNext()){
			        		                String Child_Window=i1.next();
			        		                if(!parent_window.equalsIgnoreCase(Child_Window))
			        		                {
			        			                TAFInitializers.driver.switchTo().window(Child_Window);
			        			                Thread.sleep(10000);
			        			                System.out.println("Child WebPage Title is ="+TAFInitializers.driver.getTitle());
			        			                String Child_Window_Title=TAFInitializers.driver.getTitle();
			        			                Assert.assertEquals(Child_Window_Title, "NWT Job Detail");
	//		        			                TAFUtilities.getElement("jobDetails.StatusDD").click();
	//		        			               	TAFUtilities.getElement("jobDetails.statusdropdown.EnRoute").click();
			        			    	        TAFUtilities.wait(TAFInitializers.driver, TAFUtilities.getLocator("jobDetails.status.EnRoute"), 20, "elementVisible");
			        			    	        System.out.println("Status changed to En Route");
			        			                TAFInitializers.driver.close();
			        		                }
			        		           }
			        		    TAFInitializers.driver.switchTo().window(parent_window);
			        		    System.out.println("Changed Back to Parent WebPage and Title is ="+TAFInitializers.driver.getTitle());
			        		}     
	     }
	/**
	 * @author ssrigo001c
	 * @description method to verify the DropDown the list	 *              
	 * @param
	 * @see com.comcast.framework.core.helpers.TAFUtilities 
	 * @editedBy
	 * @revision
	 * @revisionDate
	 */
	public static void verifyDropDownList() throws IOException, InterruptedException {
		
		SoftAssert objSoftAssert=new SoftAssert();
		String[] arrMenuItems= new String[]{"Sort Ascending","Sort Descending","Hide Column","Group","Pin Left","Pin Right"};
		List<String> menuList = new ArrayList<String>();
		menuList.addAll(Arrays.asList(arrMenuItems));
		List<String> groupBy = new ArrayList<String>();			 
		Thread.sleep(15000);
		TAFUtilities.getElement("jobList.JobId.dropdown").click();	
		Thread.sleep(5000);
		List<WebElement> menu=TAFUtilities.getElementsList("jobBrowser.ColumnHeaderMenu");
		for(WebElement menuItems : menu)
		{
			System.out.println("menuItems" +menuItems.getText());
			groupBy.add(menuItems.getText());
		}
		//objSoftAssert.assertTrue(groupBy.containsAll(menuList), "LIST items are not equal ");		
		
		
	} 

	/**
	 * @author ssrigo001c
	 * @description method to get the Job Id's form the list	 *              
	 * @param
	 * @see com.comcast.framework.core.helpers.TAFUtilities 
	 * @editedBy
	 * @revision
	 * @revisionDate
	 */
	public static List<Integer> sort_browserdata(){
		int i=0;
        String rstatus="";
        List<Integer> columnData = new ArrayList<Integer>();
        JavascriptExecutor js=(JavascriptExecutor) TAFInitializers.getDriver();
		while(!rstatus.equals("OVER"))
		{
            rstatus  = (String) js.executeScript("try{return angular.element(document.evaluate(\"//div[contains(@class,'jobLookupPage')]//div[contains(@class,'render-container-body')]//div[@class='ui-grid-canvas']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).scope().rowContainer.visibleRowCache["+i+"].entity.jobid.toString();}catch(err){return \"OVER\";}");            
            if (!rstatus.equals("OVER"))
            {
            	columnData.add(Integer.parseInt(rstatus.trim()));            
            }
            i++;
        }
		columnData.remove("OVER");
		return (columnData);		
	}
	
}
*/