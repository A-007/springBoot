package com.infotect.mytodoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.infotect.mytodoapp.model.Task;

public interface TaskRepository extends MongoRepository<Task, Long>{

}
