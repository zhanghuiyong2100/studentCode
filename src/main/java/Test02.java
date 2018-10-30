import java.util.UUID;

/**
 * @author 章辉勇
 * @创建时间 2018年10月18日
 * @描述:
 **/

public class Test02 {
    public static void main(String[] args) {
        UUID uuid  =  UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString().replaceAll("\\-", ""));
    }
}
