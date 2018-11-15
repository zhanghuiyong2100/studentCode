package com.springboot.api.dao;

import com.springboot.api.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 章辉勇
 * @创建时间 2018年11月12日
 * @描述: 用户数据库操作数据访问接口
 **/
public interface PersonRepository extends JpaRepository<Person, Long> {
    /**
     * ①使用方法名查询，接受一个name参数，返回值为列表。
     */
    List<Person> findByAddress(String address);

    /**
     * ②使用方法名查询，接受name和address，返回值为单个对象。
     */
    Person findByNameAndAddress(String name, String address);

    /**
     * ③使用@Query查询，参数按照名称绑定。
     */
    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    /**
     * ④使用@NamedQuery查询，请注意我们在实体类中做的@NamedQuery的定义。
     */
    Person withNameAndAddressNameQuery(String name, String address);
}
