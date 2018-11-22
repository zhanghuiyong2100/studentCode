package com.springboot.api;

import com.springboot.api.dao.PersonRepository;
import com.springboot.api.domain.Person;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApiApplicationTests {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void contextLoads() {
    }
    @Test
    public void sort() {
        List<Person> repositoryAll = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        System.out.println(repositoryAll);
    }


}
