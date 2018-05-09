package com.memcachier.tutorial;

import java.lang.Iterable;

public interface CachedTaskRepository {

  public Iterable<Task> findAllCached();
  public Task saveAndClearCache(Task t);
  public void deleteByIdAndClearCache(Long id);

}
