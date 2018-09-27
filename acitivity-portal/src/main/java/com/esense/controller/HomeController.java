package com.esense.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.esense.entity.Activity;
import com.esense.entity.ActivityType;
import com.esense.entity.Options;
import com.esense.entity.QuestionBank;
import com.esense.other.EncoderBase64;
import com.esense.service.CommonService;
import com.google.gson.Gson;

import net.iharder.Base64;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CommonService commonService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<ActivityType> activityTypes=commonService.getListByObject(ActivityType.class);
		model.addAttribute("activityTypes", activityTypes);
		return "home";
	}
	
	@PostMapping(value="save-question")
	public @ResponseBody String saveActivity(@RequestParam("activity_name")String name,@RequestParam("tip") String tip,HttpServletRequest request,
			@RequestParam("hint")String hint,@RequestParam("activity_type") int activityType,@RequestParam("template")String template,
			@RequestParam("question")String question,@RequestParam("ans") String ans) {
		
		System.out.println("@@@@ :::"+question);
		for(int i=0;i<10;i++) {
			System.out.println("@@@@ :opt ::::"+i+"::::"+request.getParameter("opt"+i));;
		}
		
		
	/*	System.out.println("@@@@opt1 :::"+opt1);
		System.out.println("@@@@opt2 :::"+opt2);
		System.out.println("@@@@opt3 :::"+opt3);
		System.out.println("@@@@opt4 :::"+opt4);
	*/	System.out.println("@@@@ :::"+question);	
		System.out.println("@@@@ :::"+question);
		List <Activity> activities=commonService.getListByQuery("From Activity where activity_name='"+name+"'");
		/*List <Activity> activities=commonService.getListByQuery("From Activity where activity_name='"+name+"'");
		Activity activity;
		if(activities.size()==0) {
			activity=new Activity();
			activity.setActivityName(name);
			activity.setHint(hint);
			activity.setHowToPlay(tip);
			activity.setStatus(true);
			activity.setTemplate(template);
			activity.setActivityType((ActivityType)commonService.getObjectById(ActivityType.class,activityType ));
			commonService.save(activity);
		}else {
			activity=activities.get(0);
		}
		
		QuestionBank questionBank=new QuestionBank();
		questionBank.setActivity(activity);
		questionBank.setQuestion(question);
		commonService.save(questionBank);
		
		Options options1=new Options();
		options1.setName(opt1);
		options1.setQuestionBank(questionBank);
		commonService.save(options1);
		
		Options options2=new Options();
		options2.setName(opt2);
		options2.setQuestionBank(questionBank);
		commonService.save(options2);

		Options options3=new Options();
		options3.setName(opt3);
		options3.setQuestionBank(questionBank);
		commonService.save(options3);
		
		Options options4=new Options();
		options4.setName(opt4);
		options4.setQuestionBank(questionBank);
		commonService.save(options4);
		List<Options> options=commonService.getListByQuery("From Options where name='"+ans+"'");
		questionBank.setOptions(options.get(0));
		commonService.updateObject(questionBank);*/
		
		return "Save Succesfully";
	}
	
	@PostMapping(value="/upload_image")
	public @ResponseBody void saveFile(@RequestParam("file")MultipartFile file,HttpServletRequest request,   HttpServletResponse response) throws IOException {
		
		System.out.println("File   Upload   "+file);
		   // Create path components to save the file.
        final PrintWriter writer = response.getWriter();

        String linkName = null;
		  Map< Object, Object > responseData = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "D:\\bhavin\\work_space\\acitivity-portal\\src\\main\\webapp\\resources";/* System.getProperty("catalina.home");*/
				File dir = new File(rootPath + File.separator + "image");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="+ serverFile.getAbsolutePath());
				 // Create link.
	            String path = request.getHeader("referer");
	            linkName = path + "tmpFiles/" + serverFile.getName();
	            
	            
				  responseData = new HashMap< Object, Object > ();
		            responseData.put("link",request.getContextPath()+File.separator+"resources"+File.separator+"image"+File.separator+serverFile.getName());
		 
		            // Send response data.
		            String jsonResponseData = new Gson().toJson(responseData);
		            response.setContentType("application/json");
		            response.setCharacterEncoding("UTF-8");
		            response.getWriter().write(jsonResponseData);
				
			} catch (Exception e) {
	            e.printStackTrace();
	            writer.println("You either did not specify a file to upload or are " +
	                "trying to upload a file to a protected or nonexistent " +
	                "location.");
	            writer.println("<br/> ERROR: " + e.getMessage());
	            responseData = new HashMap < Object, Object > ();
	            responseData.put("error", e.toString());
			}
		}
	}
	
	@PostMapping(value="/upload_image-base")
	public @ResponseBody void getBsse64Image(@RequestParam("file")MultipartFile file,HttpServletRequest request,   HttpServletResponse response) throws IOException {
		
		System.out.println("File   Upload   "+file);
		   // Create path components to save the file.
 		  Map< Object, Object > responseData = null;
		if (!file.isEmpty()) {
				
	            
				  responseData = new HashMap< Object, Object > ();
		            responseData.put("link",EncoderBase64.encodeFileToBase64Binary(file));
		 
		            // Send response data.
		            String jsonResponseData = new Gson().toJson(responseData);
		            response.setContentType("application/json");
		            response.setCharacterEncoding("UTF-8");
		            response.getWriter().write(jsonResponseData);
				
			
		}
	}
	
}
