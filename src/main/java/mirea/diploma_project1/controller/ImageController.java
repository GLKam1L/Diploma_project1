package mirea.diploma_project1.controller;

import mirea.diploma_project1.repo.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    @Autowired
    FileStorageService storageService;

    @GetMapping("/images/new")
    public String newImage(Model model){
        return "upload_form";
    }

    @PostMapping("/images/upload")
    public String uploadImage(Model model, @RequestParam("file")MultipartFile) {
        String message = "";

        try {
            storageService.save(file);

            message = "Uploaded the image successfully: " + file.getOriginalFilename();
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Could not upload the image: " + file.getOriginalFilename()+". Error: " + e.getMessage();
            model.addAttribute("message", message);
        }
        return "upload_form";
    }
}
