package com.sandhya.librarymanagement.repository;

import com.sandhya.librarymanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
