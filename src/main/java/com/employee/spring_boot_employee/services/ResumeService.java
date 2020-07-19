package com.employee.spring_boot_employee.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.employee.spring_boot_employee.domain.ResumeUpload;
import com.employee.spring_boot_employee.exception.FileNotFoundException;
import com.employee.spring_boot_employee.exception.FileStorageException;
import com.employee.spring_boot_employee.repositories.ResumeRepository;

@Service
public class ResumeService {
	@Autowired
	private ResumeRepository resumeRepository; 
	
	public ResumeUpload storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            ResumeUpload upload=new ResumeUpload(fileName, file.getContentType(), file.getBytes());
            return resumeRepository.save(upload);
     	}
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
        public ResumeUpload getFile(String fileId) {
        	return resumeRepository.findById(fileId)
                    .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
        }

}
