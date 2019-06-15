package com.springboot.pm.restcontroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/upload")
public class FileUploadController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	private final String FILEPATH="C:/Mahendra Work Details/upload/";
	
	
	@RequestMapping("/fileUpload")
	public ModelAndView setTestAPI()
	{
		ModelAndView modelAndView = new ModelAndView("uploadFile");
		//modelAndView.addObject("message", "File Upload Example");
		//modelAndView.addObject("message2", "File Upload Example");
		return modelAndView;
	}

	@RequestMapping("/save")
	public ModelAndView uploadFile(@RequestParam("files") MultipartFile file)
	{
		ModelAndView modelAndView = new ModelAndView("uploadFile");
		logger.debug("in fileupload..");
		if (file.isEmpty()) {
			modelAndView.addObject("message", "Please select a file to upload");
            return modelAndView;
        }

        try {
            	byte[] bytes = file.getBytes();
            	Path path = Paths.get(FILEPATH + file.getOriginalFilename());
            	Files.write(path, bytes);

            	modelAndView.addObject("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/save2")
	public ResponseEntity<?> uploadFile2(@RequestParam("files") MultipartFile file)
	{
		ModelAndView modelAndView = new ModelAndView("uploadFile");
		logger.debug("in fileupload..");
		if (file.isEmpty()) {
			modelAndView.addObject("message", "Please select a file to upload");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            	byte[] bytes = file.getBytes();
            	Path path = Paths.get(FILEPATH + file.getOriginalFilename());
            	Files.write(path, bytes);

            	//modelAndView.addObject("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity("Successfully uploaded - "+ file.getOriginalFilename(), HttpStatus.OK);
	}
}
