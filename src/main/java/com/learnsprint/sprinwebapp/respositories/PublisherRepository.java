package com.learnsprint.sprinwebapp.respositories;

import org.springframework.data.repository.CrudRepository;

import com.learnsprint.sprinwebapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
