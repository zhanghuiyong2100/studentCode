package com.springboot.api.web.restcontroller;

import com.springboot.api.dao.PersonRepository;
import com.springboot.api.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 章辉勇
 * @创建时间 2018年11月12日
 * @描述: 实现
 **/

@RestController
public class PersonRestController {
    /**
     * 1 Spring Data JPA 已自动为你注册 bean，所以可自动注入
     */
    @Autowired
    PersonRepository personRepository;

    /**
     * 保存
     * *save支持批量保存：<s extends T>Iterable<s> save（Iterable<S> entities）；
     * 删除：
     * 支持使用id删除对象、批量删除以及删除全部：
     * void delete（ID id）；
     * void delete（T entity）；
     * void delete（Iterable<？extends T> entities）；
     * void deleteAl1（）；
     */

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person person = new Person(null, name, age, address);
        Person p = personRepository.save(person);
        return p;
    }

    /**
     * 测试findByAddress
     */
    @RequestMapping("/findByAddress")
    public List<Person> findByAddress(String address) {
        List<Person> personList = personRepository.findByAddress(address);
        return personList;
    }

    /**
     * 测试findByNameAndAddress
     */
    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name, String address) {
        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }

    /**
     * 则试 withNameAndAddressQuery
     */
    @RequestMapping("/withNameAndAddressQuery")
    public Person withNameAndAddressQuery(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }

    /**
     * 则试 withNameAndAddressNameQuery
     */
    @RequestMapping("/withNameAndAddressNameQuery")
    public Person withNameAndAddressNameQuery(String name, String address) {
        Person person = personRepository.withNameAndAddressNameQuery(name, address);
        return person;
    }

    /**
     * 測試排序
     */
    @RequestMapping("/sort")
    public List<Person> sort() {

        List<Person> repositoryAll = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return repositoryAll;
    }

    /**
     * 測試分頁
     */
    //@RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> repositoryAll = personRepository.findAll(new Pageable() {
            @Override
            public int getPageNumber() {
                return 1;
            }

            @Override
            public int getPageSize() {
                return 3;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                Sort orders = new Sort(Sort.Direction.ASC, "address");
                return orders;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });
        return repositoryAll;
    }

}
