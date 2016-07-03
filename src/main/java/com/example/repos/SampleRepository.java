package com.example.repos;

import com.example.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by charles on 7/3/16.
 */
public interface SampleRepository extends PagingAndSortingRepository<User, Long> {
}
