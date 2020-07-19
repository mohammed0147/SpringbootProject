package com.employee.spring_boot_employee.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.spring_boot_employee.Response.Response;
import com.employee.spring_boot_employee.domain.ResumeUpload;
import com.employee.spring_boot_employee.services.ResumeService;

@RestController
@RequestMapping("/api")
public class ResumeUploadControll {

	@Autowired
	private ResumeService resumeService;
	

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam(value = "file") MultipartFile file) {
        ResumeUpload fileName=resumeService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
            file.getContentType(), file.getSize());
    }

	 @PostMapping("/uploadMultipleFiles")
	  public List < Response >uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) { 
		 return Arrays.asList(files) .stream() .map(file -> uploadFile(file))
	  .collect(Collectors.toList());
	  
	 }
		/*
		 * @GetMapping("/downloadFile/{fileId}") public ResponseEntity < Resource >
		 * downloadFile(@PathVariable(value = "fileId") String fileId) { ResumeUpload
		 * dbFile = resumeService.getFile(fileId);
		 * 
		 * return ResponseEntity.ok()
		 * .contentType(MediaType.parseMediaType(dbFile.getFileType()))
		 * .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
		 * dbFile.getFileName() + "\"") .body(new ByteArrayResource(dbFile.getData()));
		 * }
		 */

}
