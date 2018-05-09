package com.memcachier.tutorial;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long>, CachedTaskRepository {}
