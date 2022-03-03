package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import org.springframework.data.repository.CrudRepository;

public interface HashtagRepo extends CrudRepository<Hashtag,Long> {
}
