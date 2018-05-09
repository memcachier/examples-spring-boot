package com.memcachier.tutorial;

import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import com.google.code.ssm.api.ReadThroughAssignCache;
import com.google.code.ssm.api.InvalidateAssignCache;

public class TaskRepositoryImpl implements CachedTaskRepository {

  @Autowired
  TaskRepository taskRepository;

  @ReadThroughAssignCache(namespace="Taskrepo", assignedKey="all")
  public Iterable<Task> findAllCached() {
    return this.taskRepository.findAll();
  }

  @InvalidateAssignCache(namespace="Taskrepo", assignedKey="all")
  public Task saveAndClearCache(Task t){
    return this.taskRepository.save(t);
  }

  @InvalidateAssignCache(namespace="Taskrepo", assignedKey="all")
  public void deleteByIdAndClearCache(Long id){
    this.taskRepository.deleteById(id);
  }
}
