package com.springboot.api.service;

import com.springboot.api.domain.Person;

/**
 * @author 章辉勇
 * @创建时间 2018年11月15日
 * @描述: personService
 **/

public interface PersonService {
    public Person savePersonWithRollBack(Person person);

    /**
     * <p> 回滚注解测试 </p>
     *
     * @param person
     * @return PerSon
     * @其它信息
     */
    public Person savePersonWithoutRollBack(Person person);

    /**
     * <p> 缓存测试 保存 </p>
     *
     * @param person
     * @return person
     * @其它信息
     */
    public Person save(Person person);

    /**
     * <p> 缓存测试 删除 </p>
     *
     * @param id
     * @return
     * @其它信息
     */
    public void remove(Long id);

    /**
     * <p> 缓存测试 查找 </p>
     *
     * @param person
     * @return
     * @其它信息
     */
    public Person findOne(Person person);
}
