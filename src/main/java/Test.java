import java.util.*;

/**
 * @author 章辉勇
 * @创建时间 2018年10月10日
 * @描述: 日常测试01
 **/

public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();

        new Date();

        // 创建3个学生对象，年龄分别是20、19、21，并将他们依次放入List中
        Student s1 = new Student();
        s1.setAge(20);
        s1.setUsable(true);
        Student s2 = new Student();
        s2.setAge(19);
        s2.setUsable(true);
        Student s3 = new Student();
        s3.setAge(21);
        s3.setUsable(false);
        list.add(s1);
        list.add(s2);
        list.add(s3);

        System.out.println(list.get(0));
        System.out.println("排序前：" + list);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按照学生的年龄进行升序排列
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                }
                if (o1.getAge() == o2.getAge()) {
                    return 0;
                }
                return -1;
            }
        });
        System.out.println("升序排序后：" + list);
    }
}
