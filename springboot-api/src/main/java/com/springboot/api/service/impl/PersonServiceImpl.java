package com.springboot.api.service.impl;

import com.springboot.api.dao.PersonRepository;
import com.springboot.api.domain.Person;
import com.springboot.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 章辉勇
 * @创建时间 2018年11月15日
 * @描述: person回滚测试实现
 **/

@Service
public class PersonServiceImpl implements PersonService {


    /**
     * ①可以直接注入我们的RersonRepository的Bean.
     */
    @Autowired
    PersonRepository personRepository;


    @Override
    /**
     * ②使用@Transactional注解的 rollbackFor属性，指定特定异常时，数据回滚，
     * */
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person personSave = personRepository.save(person);
        if ("天之涯".equals(personSave.getName())) {
            /**
             * ③硬编码手动触发异常。
             * */
            throw new IllegalArgumentException("用户名已经存在，数据即将回滚");
        }

        return personSave;

    }

    @Override
    /**
     * ④使用@Transactional注解的noRollbackFor属性，指定特定异常时，数据回滚。
     * */
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person personSave = personRepository.save(person);
        if ("天之涯".equals(personSave.getName())) {
            throw new IllegalArgumentException("用户名已经存在，但是数据不会回滚");
        }

        return personSave;
    }

    /**
     * ①@CachePut缓存新增的或更新的数据到缓存，其中缓存名称为people，数据的key是person的id。
     */
    @Override
    @CachePut(value = "perple", key = "#person.id")
    public Person save(Person person) {
        Person save = personRepository.save(person);
        System.out.println("id、key为:" + save.getId() + "数据做了缓存");
        return save;
    }


    /**
     * ②@CacheEvict从缓存people中删除key为id的数据。
     */
    @Override
    @CacheEvict(value = "perple")
    public void remove(Long id) {
        System.out.println("刪除id" + id + "為的緩存數據");
//        personRepository.deleteById(id);
    }

    /**
     * ③@Cacheable缓存key为person的id数据到缓存people中。
     */
    @Override
    @Cacheable(value = "perple", key = "#person.id")
    public Person findOne(Person person) {
        List<Long> idList = new ArrayList<>();
        idList.add(person.getId());
        List<Person> repositoryAllById = personRepository.findAllById(idList);
        System.out.println("id、key为:" + person.getId() + "数据做了缓存");
        return repositoryAllById.get(0);
    }
}
