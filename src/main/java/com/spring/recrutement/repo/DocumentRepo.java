package com.spring.recrutement.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.recrutement.model.Document;

public interface DocumentRepo extends JpaRepository<Document,Long>{
    
    
}
