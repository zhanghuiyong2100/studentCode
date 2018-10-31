package senSorsTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 章辉勇
 * @创建时间 2018年10月10日
 * @描述:
 **/

public class Student implements EnTest {


    private  Integer age;
    private Boolean usable;
    private List<String> lists;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", usable=" + usable +
                ", lists=" + lists +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    @Override
    public Map<String, Object> getSensorsMap() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("age",this.age);
        return map;
    }
}
