package com.example.controllers;

import com.example.model.User;
import com.example.repos.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by charles on 7/3/16.
 */
@RestController
@RequestMapping("/users")
public class SampleController {

    @Autowired
    private SampleRepository sampleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return sampleRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        sampleRepository.save(user);
    }
}
