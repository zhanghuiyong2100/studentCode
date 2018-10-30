package senSorsTest;

import java.util.Map;

/**
 * @author 章辉勇
 * @创建时间 2018年10月15日
 * @描述: 神策埋点测试03
 **/

public class SenSorsTest03 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(88);
        Map<String, Object> map = student.getSensorsMap();
        System.out.println(map);

    }
}
