package com.example.imageuploading.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.imageuploading.dto.UserDto;
import com.example.imageuploading.entity.User;
import com.example.imageuploading.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    Cloudinary cloudinary;

    public String addNewUser( MultipartFile file,String name,String email) throws IOException {
        
        String imageUrl = null;
        if (file != null && !file.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());//uploads the file to the Cloudinary service
            imageUrl = (String) uploadResult.get("secure_url");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setImage(imageUrl);
        userRepo.save(user);
        return "user successfully";
    }

}
