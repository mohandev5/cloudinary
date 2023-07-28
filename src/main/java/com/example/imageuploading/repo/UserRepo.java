package com.example.imageuploading.repo;

import com.example.imageuploading.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
