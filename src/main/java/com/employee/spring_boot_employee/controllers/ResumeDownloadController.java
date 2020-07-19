package com.employee.spring_boot_employee.controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.spring_boot_employee.domain.ResumeUpload;
import com.employee.spring_boot_employee.services.ResumeService;

@RestController
public class ResumeDownloadController {

	  @Autowired
	    private ResumeService resumeService;

	    @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        ResumeUpload file = resumeService.getFile(fileName);

	        return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(file.getFileType()))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
	            .body(new ByteArrayResource(file.getData()));
	    }
}


